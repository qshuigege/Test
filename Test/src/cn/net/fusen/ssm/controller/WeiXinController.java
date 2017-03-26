package cn.net.fusen.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.net.fusen.ssm.service.WXBusinessService;
import cn.net.fusen.ssm.wx.WeiXinCoreService;

@Controller
public class WeiXinController {
	
	@Autowired
	private WXBusinessService service;
	
	@RequestMapping("/WX")
	public void handleWeiXinMsg(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		//SignUtil.yanzheng(request, response);
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
		//request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		// 调用核心业务类接收消息、处理消息  
		String respMessage = WeiXinCoreService.processRequest(request, service);

		// 响应消息  
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();
	}
}
