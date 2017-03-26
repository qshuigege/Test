package cn.net.fusen.ssm.wx.utils;

import cn.net.fusen.ssm.wx.HttpRequestUtils;
import cn.net.fusen.ssm.wx.apimodel.AccessTokenGZPT;
import cn.net.fusen.ssm.wx.apimodel.AccessTokenGZPT_WY;
import cn.net.fusen.ssm.wx.apimodel.WXUserInfo;
import net.sf.json.JSONObject;


public class WXUtils {
	
	/*public static String getAccessToken(String apiUrl){
		String jsonStr = HttpRequestUtils.requestStringGet(apiUrl);
		JSONObject jo = JSONObject.fromObject(jsonStr);
		String access_token = (String)jo.get("access_token");
		if(access_token!=null&&!"".equals(access_token)){
			return access_token;
		}else{
			return null;
		}
	}
	
	*//**
	 * 创建自定义菜单
	 * @param apiUrl
	 * @param menuJson
	 * @return	返回操作后提示信息(json格式{"errcode":0,"errmsg":"ok"}{"errcode":40018,"errmsg":"invalid button name size"})
	 *//*
	public static String createMenu(String apiUrl, String menuJson){
		
		String jsonStr = HttpRequestUtils.requestStringPost(apiUrl, menuJson);
		return jsonStr;
		
	}
	
	*//**
	 * 获得用户基本信息
	 * @param apiUrl
	 * @param openid
	 * @return
	 * 
	 * 正常情况返回：{   "subscribe": 1, 
   "openid": "o6_bmjrPTlm6_2sgVt7hMZOPfL2M", 
   "nickname": "Band", 
   "sex": 1, 
   "language": "zh_CN", 
   "city": "广州", 
   "province": "广东", 
   "country": "中国", 
   "headimgurl":  "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4
eMsv84eavHiaiceqxibJxCfHe/0",
  "subscribe_time": 1382694957,
  "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
  "remark": "",
  "groupid": 0,
  "tagid_list":[128,2]
}
	 */
	public static JSONObject getUserInfo(String openid){
		String apiUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+R_WX.ACCESS_TOKEN_wei+"&lang=zh_CN&openid="+openid;
		String jsonStr = HttpRequestUtils.requestStringGet(apiUrl);
		
		return JSONObject.fromObject(jsonStr);
	}
	
	/**
	 * 微信公众平台开发获取AccessToken接口
	 * @return JavaBean,包装了AccessToken
	 */
	public static AccessTokenGZPT getAccessToken(){
		String apiUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ R_WX.APPID_GZPT + "&secret=" + R_WX.APPSECRET_GZPT;
		String jsonStr = HttpRequestUtils.requestStringGet(apiUrl);
		JSONObject jo = JSONObject.fromObject(jsonStr);
		if(jo.get("errcode")==null){
			AccessTokenGZPT obj = (AccessTokenGZPT)JSONObject.toBean(jo, AccessTokenGZPT.class);
			return obj;
		}else{
			return null;
		}
	}
	
	/**
	 * 微信网页开发获取AccessToken接口
	 * @return JavaBean,包装了AccessToken
	 */
	public static AccessTokenGZPT_WY getAccessToken_WY(String code){
		String apiUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+R_WX.APPID_GZPT+"&secret="+R_WX.APPSECRET_GZPT+"&code="+code+"&grant_type=authorization_code";
		String jsonStr = HttpRequestUtils.requestStringGet(apiUrl);
		JSONObject jo = JSONObject.fromObject(jsonStr);
		if(jo.get("errcode")==null){
			AccessTokenGZPT_WY obj = (AccessTokenGZPT_WY)JSONObject.toBean(jo, AccessTokenGZPT_WY.class);
			return obj;
		}else{
			return null;
		}
	}
	
	/**
	 * 获取微信用户基本信息
	 * @param accessToken
	 * @param openid
	 * @return javaBean,包装了用户基本信息
	 */
	public static WXUserInfo getUserInfo(String accessToken, String openid){
		String apiUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+accessToken+"&lang=zh_CN&openid="+openid;
		String jsonStr = HttpRequestUtils.requestStringGet(apiUrl);
		JSONObject jo = JSONObject.fromObject(jsonStr);
		if(jo.get("errcode")==null){
			return (WXUserInfo)JSONObject.toBean(jo, WXUserInfo.class);
		}else{
			return null;
		}
		
	}
	
	/**
	 * 创建微信公众号菜单
	 * @param accessToken
	 * @param menuJson
	 * @return 创建成功返回true,否则返回false
	 */
	public static boolean createMenu(String accessToken, String menuJson){
		String apiUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken;
		String jsonStr = HttpRequestUtils.requestStringPost(apiUrl, menuJson);
		JSONObject jo = JSONObject.fromObject(jsonStr);
		if(jo.get("errcode")==null){
			return true;
		}else{
			return false;
		}
		
	}

	
	
}
