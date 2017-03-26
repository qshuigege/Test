package cn.net.fusen.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.net.fusen.ssm.po.User;
import cn.net.fusen.ssm.service.UserService;
import cn.net.fusen.ssm.utils.CommonUtils;

@Controller
public class MenuController {
	
	@RequestMapping("/controller/UserController/addMenuUI")
	public void addMenuUI(){
		
	}
	
	
	
	
	
	
	
	/*
	
	@Autowired
	private UserService service;
	
	*//**
	 * 登录页面
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping("/controller/UserController/loginUI")
	public ModelAndView loginUI() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("b2b/loginUI");
		return modelAndView;
		
	}
	
	*//**
	 * 登录
	 * @param request
	 * @param response
	 * @param userid
	 * @param password
	 * @throws Exception
	 *//*
	@RequestMapping("/controller/UserController/login")
	public ModelAndView login(HttpSession session, HttpServletRequest request, String userid, String password) throws Exception{

		ModelAndView modelAndView = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("password", password);
		User user = service.findUserByUseridAndPwd(map);
		if (user!=null) {
			//将user信息保存到session
			request.getSession().setAttribute("user", user);
			modelAndView.addObject("user", user);
			//返回登录后的首页
			modelAndView.setViewName("b2b/index");
			
		}else{

			modelAndView.addObject("title", "登录失败！");
			modelAndView.addObject("content", "<a href=\""+request.getContextPath()+"/controller/UserController/loginUI.action\">返回</a>");
			modelAndView.setViewName("b2b/message");
		}
		return modelAndView;
		
	}
	
	*//**
	 * 退出登录
	 * @param session
	 * @param request
	 * @param response
	 * @param userid
	 * @throws Exception
	 *//*
	@RequestMapping("/controller/UserController/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//移除session
		session.removeAttribute("user");
		return "redirect:/controller/UserController/loginUI.action";
	}
	
	*//**
	 * 添加用户页面
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping("/controller/UserController/addUserUI")
	public ModelAndView addUserUI() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("b2b/addUserUI");
		return modelAndView;
	}
	
	*//**
	 * 添加用户
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping("/controller/UserController/addUser")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, User user) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		CommonUtils.replaceNullValue(user);
		int num = service.addUser(user);
		System.out.println("addUser():受影响的行数："+num);
		if (num>0) {

			modelAndView.addObject("title", "添加成功！");
			modelAndView.addObject("content", "<a href=\""+request.getContextPath()+"/controller/UserController/addUserUI.action\">返回</a>");
			modelAndView.setViewName("b2b/message");
			
		}else{

			modelAndView.addObject("title", "添加失败！");
			modelAndView.addObject("content", "<a href=\""+request.getContextPath()+"/controller/UserController/addUserUI.action\">返回</a>");
			modelAndView.setViewName("b2b/message");
		}
		return modelAndView;
	}
*/
}
