package cn.net.fusen.ssm.wx;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import cn.net.fusen.ssm.service.WXBusinessService;
import cn.net.fusen.ssm.utils.DBResource;
import cn.net.fusen.ssm.utils.DaoSupport;
import cn.net.fusen.ssm.wx.utils.R_WX;
import cn.net.fusen.ssm.wx.utils.WXUtils;

/**
 * 核心服务类
 * @author 简爱微萌
 * @Email zyw205@gmial.com
 *Administrator
 */
public class WeiXinCoreService {
	public static String keyWord;
	
	
	public static final String MENU2="感谢您的关注！！！ \n" +
			"以后有更精彩丰富的内容我们会第一时间推送给您。 \n\n" +
			"【休闲娱乐】笑话,人品张三,糗事,鬼故事,歌词,星座运势,脑筋急转,周公解梦,成语接龙~七上八下~\n"+
			"【实用查询】天气,空气质量,时间,手机归属地,快递查询,历史上的今天\n"+
			"【实用工具】翻译,新闻,万年历,苹果IMEI查询 如:苹果+序列号\n"+
			"【小Q陪聊】输入你先说的话即可\n\n"+
			//"<a href=\"http://fl.act.qq.com/25871/addev/h5/49994\">功能待定</a>"+
			"<a href=\"http://wx.wsq.qq.com/170814115\">我的社区</a>"+
			//"<a href=\"http://118.244.214.202/WeiXin_food_Javen/index.html\">食品安全</a> "+
			"<a href=\"http://www.cnblogs.com/zyw-205520/\">微信干货</a> \n\n"+
			"回复 “菜单”或者“?” 显示帮助菜单   \n技术支持群:347245650 345531810 欢迎关注：Javen_Crazy /::)/::)/::) ";
	
	public static final String MENU="感谢您的关注！！！"; /*\n\n" +
			"<a href=\"http://wx.wsq.qq.com/170814115\">我的社区</a>  "+
			"<a href=\"http://www.cnblogs.com/zyw-205520/\">微信干货</a> \n\n"+
			"1、苹果IMEI查询 如:苹果+序列号\n" +
			"2、手机归属地查询  如:手机+手机号\n" +
			"3、身份证查询 如:身份证+身份证号\n" +
			"4、星座运势 如:运势天秤座\n" +
			"5、人品测试 如:人品张三\n" +
			"6、天气查询 如:天气深圳\n" +
			"7、在线翻译 如:翻译我爱你\n"+
			"8、快递查询 如:快递+圆通7430648889 \n"+
			"9、菜谱大全 如:菜谱+蛋炒饭\n"+
			"10、周公解梦 如:解梦钓鱼 \n"+
			"11、历史上的今天 如:历史\n"+
			"12、成为开发者 如:接入+原始id\n"+
			"13、公交查询 如：公交深圳@m233\n"+
			"回复 “菜单”或者“?” 显示帮助菜单   \n技术支持群:347245650 345531810 /::)/::)/::) ";*/
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request, WXBusinessService service) {
		System.out.println("ACCESS_TOKEN_wei-->"+R_WX.ACCESS_TOKEN_wei);
		
//		String user=(String) request.getAttribute("id");
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "您输入的内容无效！";
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			Set<Entry<String, String>> set = requestMap.entrySet();
			Iterator<Entry<String, String>> it = set.iterator();
			while (it.hasNext()) {
				Entry<String,String> en = it.next();
				System.out.println("key-->"+en.getKey()+", value-->"+en.getValue());
			}
			

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
//			String CreateTime = requestMap.get("CreateTime");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				
				String msgCont=requestMap.get("Content");
				
				System.out.println("您输入的内容-->"+msgCont);
				respContent = "你输入的是文本消息，内容为：\n"+msgCont;
				
				/*if (msgCont.startsWith("接入")) {
					keyWord = msgCont.replaceAll("^接入[\\+ ~!@#%^-_=]?", "");
					if (keyWord.startsWith("gh_")) {
						respContent="URL:http://java205.sinaapp.com/Javen?id="+ keyWord+"\n Token:Javen";
					}else {
						respContent="请输入正确的原始id \n 请登录微信公众平台>设置>账号信息>查看原始ID";
					}
					//respContent="因为服务器原因此功能暂时不开放 /::P/::P";
				}*/
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				///System.out.println("您发送的是图片消息！");
				String picUrl=requestMap.get("PicUrl");
				respContent=FaceService.detect(picUrl);
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
				String Location_X=requestMap.get("Location_X");
				String Location_Y=requestMap.get("Location_Y");
				System.out.println("Location_X:"+Location_X+" Location_Y:"+Location_Y);
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				
				String recognition=requestMap.get("Recognition");
				if ( recognition==null || recognition.trim().equals("")) {
					respContent = "您发送的是音频消息！";
				}else {
					respContent="语音识别结果:"+recognition;
				}
				
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					String eventKey = requestMap.get("EventKey");
					if(eventKey==null||"".equals(eventKey)){//用户扫描公众号二维码并点击关注
						JSONObject jo = WXUtils.getUserInfo(requestMap.get("FromUserName"));
						BindingService.addAcc(jo,requestMap,service);//用户关注公众号，将该用户的信息保存到账号表（如果是用户取消关注后再次关注，一样可以直接往wxaccount表插入数据，但是会插入失败，因为openid是主键）
						respContent= MENU;
					}else{//用户扫描带参数的二维码并点击关注
						System.out.println("二维码带的参数----------->"+eventKey);
						JSONObject jo = WXUtils.getUserInfo(requestMap.get("FromUserName"));
						if("0".equals(eventKey)||"qrscene_0".equals(eventKey)){
							//用户解绑
							if(BindingService.isBinded(requestMap, jo, service)){
								
								if(BindingService.unbinding(requestMap, jo,service)){
									respContent = "感谢关注！\n解绑成功！";
								}else{
									respContent = "感谢关注！\n服务器异常，解绑失败！";
								}
							}else{
								respContent = "感谢关注！\n您的微信尚未与B2B账号绑定，无需解绑！";
							}
							
						}else{
							//用户绑定
							if(eventKey.startsWith("qrscene_")){//可能是微信的Bug，如果用户未关注公众号，扫描带参数的二维码，参数前会加上"qrscene_"
								eventKey = eventKey.replace("qrscene_", "");
								requestMap.put("EventKey",eventKey);
							}
							BindingService.addAcc(jo,requestMap,service);//用户关注公众号，将该用户的信息保存到账号表
							if(jo.get("unionid")==null||"".equals(jo.get("unionid"))){
								System.out.println("获取用户基本信息失败！");
								respContent="感谢关注！\n服务器异常，绑定失败！";
							}else{
								boolean isBinded = BindingService.isBinded(requestMap,jo,service);
								if(isBinded){//如果已经绑定
									respContent = "感谢关注！\n您的B2B账号已经与该微信绑定过，无需再次绑定！";
								}else{
									boolean b = BindingService.binding(requestMap,jo,service);
									if(b){
										respContent = "感谢关注！\n您的微信已与B2B账号绑定，您现在可以通过微信扫描的方式来登录富森B2B系统！";
									}else{
										respContent="感谢关注！\n服务器异常，绑定失败！";
									}
								}
							
								
							}
							
						}
					}
				}
				//用户已关注时的事件推送
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
					String eventKey = requestMap.get("EventKey");
					System.out.println("二维码带的参数----------->"+eventKey);
					JSONObject jo = WXUtils.getUserInfo(requestMap.get("FromUserName"));
					if("0".equals(eventKey)||"qrscene_0".equals(eventKey)){
						//用户解绑
						if(BindingService.isBinded(requestMap, jo,service)){
							
							if(BindingService.unbinding(requestMap, jo,service)){
								respContent = "解绑成功！";
							}else{
								respContent = "服务器异常，解绑失败！";
							}
						}else{
							respContent = "您的微信尚未与B2B账号绑定，无需解绑！";
						}
						
					}else{
						//用户绑定
						if(eventKey.startsWith("qrscene_")){//可能是微信的Bug，如果用户未关注公众号，扫描带参数的二维码，参数前会加上"qrscene_"
							eventKey = eventKey.replace("qrscene_", "");
							requestMap.put("EventKey",eventKey);
						}
						if(jo.get("unionid")==null||"".equals(jo.get("unionid"))){
							System.out.println("获取用户基本信息失败！");
							respContent="服务器异常，绑定失败！";
						}else{
							boolean isBinded = BindingService.isBinded(requestMap, jo,service);
							if(isBinded){//如果已经绑定
								respContent = "您的B2B账号已经与该微信绑定过，无需再次绑定！";
							}else{
								boolean b = BindingService.binding(requestMap, jo,service);
								if(b){
									respContent = "绑定成功！您现在可以通过微信扫描的方式来登录富森B2B系统！";
								}else{
									respContent="服务器异常，绑定失败！";
								}
							}

							
							/*
							//用户已关注时的事件推送
							System.out.println("用户已关注时的事件推送");
							
							String eventKey=requestMap.get("EventKey");
							if (eventKey.equals("123")) {
								respContent="用户已关注时的事件推送   事件KEY值》》》"+eventKey;
							}*/
							
						}
						
					}
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {

					//用户取消关注，将wxaccount表subscribe字段设为0
					
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
					if(requestMap.get("EventKey").equals("V1001_TODAY_MUSIC")){
						respContent = "对不起，今日没有歌曲！";
					}else if(requestMap.get("EventKey").equals("V1001_GOOD")){
						respContent = "谢谢你的赞，我们会做得更好的！";
					}else if(requestMap.get("EventKey").equals("wuliugenzong")){
						String erpoid = "";
						String sql = "select o.erp_useroid from orguser o where o.id = (select r.orgid from wxaccount a join wxacc_orguser_relation r on a.unionid = r.unionid where a.openid =?)";
						DBResource dbres = DaoSupport.executeQuery(sql, new Object[]{requestMap.get("FromUserName")});
						ResultSet rs = dbres.getResultSet();
						while (rs.next()) {
							erpoid = rs.getString("erp_useroid");
						}
						DaoSupport.closeDBRes(dbres);
						respContent = "<a href='http://b2b.fusen.net.cn/r/w?sid="+R_WX.SID_wei+"&cmd=com.actionsoft.apps.fs_b2b.ckwl.CheckLogistcs.GetOrderMobileWeb&ERPUSERID="+erpoid+"'>物流跟踪</a>";
					}
				}
				
			}
			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
}
