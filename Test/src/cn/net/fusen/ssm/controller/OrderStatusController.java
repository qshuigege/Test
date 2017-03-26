package cn.net.fusen.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.net.fusen.ssm.service.OrderStatusService;
import cn.net.fusen.ssm.wx.apimodel.AccessTokenGZPT_WY;
import cn.net.fusen.ssm.wx.utils.R_WX;
import cn.net.fusen.ssm.wx.utils.WXUtils;

@Controller
public class OrderStatusController {

	@Autowired
	private OrderStatusService service;

	@RequestMapping("/controller/OrderStatusController/getOrderStatusInfo")
	public void getOrderStatusInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		//response.setHeader("Content-type", "text/html;charset=UTF-8");
		String code = request.getParameter("code");
		// String state = request.getParameter("state");
		AccessTokenGZPT_WY accessTokenGZPT_WY = WXUtils.getAccessToken_WY(code);
		// String apiUrl =
		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxf48eadf1ba6a4e64&secret=2351893b2755f98c823a0bf527746ad7&code="+code+"&grant_type=authorization_code";
		// String jsonData = HttpRequestUtils.requestStringGet(apiUrl);
		// JSONObject jo = JSONObject.fromObject(jsonData);
		// String openid = (String)jo.get("openid");
		// String access_token = (String)jo.get("access_token");
		// DBResource dbres =
		// DaoSupport.executeProcedureWithOutParam("{call proc_geterpoidbyopenid(?,?)}",
		// new Object[]{openid}, new int[]{12});
		// CallableStatement cs =
		// (CallableStatement)dbres.getPreparedStatement();
		if (accessTokenGZPT_WY != null) {

			Map<String, String> map = new HashMap<String, String>();
			map.put("openid", accessTokenGZPT_WY.getOpenid());
			try {
				service.getErpoidByOpenid(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String erpoid = map.get("erpoid");
			if (erpoid == null) {
				PrintWriter out = response.getWriter();
				out.print("您的微信号未与B2B账号绑定！");
				out.flush();
				out.close();
			} else {
				/*
				 * try { erpoid = (String)cs.getObject(2); } catch (SQLException
				 * e) { e.printStackTrace(); } DaoSupport.closeDBRes(dbres);
				 */
				request.setAttribute("erpoid", erpoid);
				request.setAttribute("sid", R_WX.SID_wei);
				request.getRequestDispatcher(
						"/WEB-INF/jsp/wx/orderQueryIndex.jsp").forward(request,
						response);
			}
		}else{
			PrintWriter out = response.getWriter();
			out.print("服务器异常！");
			System.out.println("微信网页开发接口获取accesstoken和openid异常！");
			out.flush();
			out.close();
			
		}
	}

}
