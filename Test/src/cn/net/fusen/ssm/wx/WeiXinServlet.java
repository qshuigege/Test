package cn.net.fusen.ssm.wx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeiXinServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignUtil.yanzheng(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		// 调用核心业务类接收消息、处理消息  
		String respMessage = WeiXinCoreService.processRequest(request, null);

		// 响应消息  
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();
	}
}
