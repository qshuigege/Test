package cn.net.fusen.ssm.wx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.fusen.ssm.wx.utils.R_WX;

public class PushAccessTokenServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String aaa = request.getParameter("aaa");
		String bbb = request.getParameter("bbb");
		if("aaa".equals(aaa)&&"bbb".equals(bbb)){

			String access_token = request.getParameter("access_token");
			String sid = request.getParameter("sid");
			PrintWriter out = response.getWriter();
			if(sid==null||"".equals(sid)){
				if(access_token==null||"".equals(access_token)){
					System.out.println("微信服务器的ACCESS_TOKEN接受AWS的推送-->空空空空空空空空空空空空空空空空空空空！");
					out.print("error");
					out.flush();
					out.close();
				}else{
					R_WX.ACCESS_TOKEN_wei=access_token;
					System.out.println("微信服务器的ACCESS_TOKEN接受AWS的推送-->"+R_WX.ACCESS_TOKEN_wei);
					out.print("ok");
					out.flush();
					out.close();
				}
			}else{
				R_WX.SID_wei=sid;
				System.out.println("微信服务器的sid接受AWS的推送-->"+R_WX.SID_wei);
				out.print("ok");
				out.flush();
				out.close();
			}
		}
	}
}
