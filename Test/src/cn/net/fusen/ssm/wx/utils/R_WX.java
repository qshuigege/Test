package cn.net.fusen.ssm.wx.utils;

import java.util.List;
import java.util.Map;

import cn.net.fusen.ssm.utils.DaoSupport;


public class R_WX {
	public static String APPID_GZPT = "wxf48eadf1ba6a4e64";
	public static String APPSECRET_GZPT = "2351893b2755f98c823a0bf527746ad7";
	public static String ACCESS_TOKEN_wei=getAccessToken();
	public static String SID_wei=getSid();
	//获取AccessToken接口 wxf48eadf1ba6a4e64 2351893b2755f98c823a0bf527746ad7 "wx633dc6d72b14c174"; "f40df3e84e9ad02567d3ece30df0ee26";
	/*public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ APPID + "&secret=" + APPSECRET;
	
	//获取带参数的二维码ticket接口
	public static String TICKET_QR_CODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+ACCESS_TOKEN;

	
	//二维码ticket接口
	public static String QR_CODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

	//获取用户基本信息（包括UnionID机制）
	public static String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+ACCESS_TOKEN+"&lang=zh_CN&openid=";
	
	//创建自定义菜单
	public static String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+ACCESS_TOKEN;*/

	private static String getAccessToken(){
		List<Map<String, Object>> list = DaoSupport.executeQuerySpecifiedFields("wx_access_token", null, "accesstoken");
		if (list.size()>0) {
			System.out.println("初始化ACCESS_TOKEN_wei："+list.get(0).get("ACCESSTOKEN"));
			return (String)list.get(0).get("ACCESSTOKEN");
		}
		return "aaaaaaaaaaaaa";
	}
	private static String getSid(){
		List<Map<String, Object>> list = DaoSupport.executeQuerySpecifiedFields("B2B_MAINTENANCE", "name='sid'", "value");
		if (list.size()>0) {
			System.out.println("初始化SID_wei："+list.get(0).get("VALUE"));
			return (String)list.get(0).get("VALUE");
		}
		return "bbbbbbbbbbbbb";
	}
	
}
