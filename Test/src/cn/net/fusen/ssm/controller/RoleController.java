package cn.net.fusen.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.net.fusen.ssm.po.Role;
import cn.net.fusen.ssm.service.RoleService;
import cn.net.fusen.ssm.utils.CommonUtils;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	/**
	 * 角色列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/role_list")
	public ModelAndView roleList(String userid){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("b2b/addRoleUI");
		return modelAndView;
		
	}
	
	/**
	 * 添加角色页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/controller/RoleController/addRoleUI")
	public ModelAndView addRoleUI() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("b2b/addRoleUI");
		return modelAndView;
		
	}
	
	/**
	 * 添加角色
	 * @param request
	 * @param response
	 * @param userid
	 * @param password
	 * @throws Exception
	 */
	@RequestMapping("/controller/RoleController/addRole")
	public ModelAndView addRole(HttpSession session, HttpServletRequest request, String rolename, String categoryname, String roledesc) throws Exception{

		ModelAndView modelAndView = new ModelAndView();
		Role role = new Role("", rolename, categoryname, roledesc);
		CommonUtils.replaceNullValue(role);
		int num = service.addRole(role);
		System.out.println("addRole():受影响的行数："+num);
		if (num>0) {

			modelAndView.addObject("title", "添加成功！");
			modelAndView.addObject("content", "<a href=\""+request.getContextPath()+"/controller/UserController/addRoleUI.action\">返回</a>");
			modelAndView.setViewName("b2b/message");
			
		}else{

			modelAndView.addObject("title", "添加失败！");
			modelAndView.addObject("content", "<a href=\""+request.getContextPath()+"/controller/UserController/addRoleUI.action\">返回</a>");
			modelAndView.setViewName("b2b/message");
		}
		return modelAndView;
		
	}
	
	/**
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
	}*/

}
