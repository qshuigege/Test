package cn.net.fusen.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.net.fusen.ssm.po.TestPo;
import cn.net.fusen.ssm.po.User;
import cn.net.fusen.ssm.service.MybatisTestService;
import cn.net.fusen.ssm.service.TestPoService;
import cn.net.fusen.ssm.service.UserService;
import cn.net.fusen.ssm.wx.utils.DynamicDataSource;

@Controller
@Component
public class MybatisTestController {
	
	@Autowired
	private TestPoService service;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private MybatisTestService mybatisTestService;
	
	@RequestMapping("/controller/MybatisTestController/testMybatis")
	public void testMybatis(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.getWriter().print("testMybatis ok");
	}
	
	@RequestMapping("/controller/MybatisTestController/testOracle")
	public void testOracle(HttpServletRequest request, HttpServletResponse response) throws IOException{
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_A);
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", "admin");
		try {
			TestPo tPo = service.findUserById(map);
			response.getWriter().print(tPo.getId()+"-->"+this.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/controller/MybatisTestController/testSqlServer")
	public void testSqlServer(HttpServletRequest request, HttpServletResponse response) throws IOException{
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
		Map<String, String> map = new HashMap<String, String>();
		map.put("webserviceno", "BE_BAS0001");
		try {
			TestPo tPo = service.findB2b001oidByWebserviceno(map);
			response.getWriter().print(tPo.getB2b001oid());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/controller/MybatisTestController/testJson")
	@ResponseBody
	public User testJson(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
		Map<String, String> map = new HashMap<String, String>();
//		map.put("webserviceno", "BE_BAS0001");
//		TestPo tPo = service.findB2b001oidByWebserviceno(map);
		map.put("userid", "admin");
		map.put("password", "1");
		User user = uService.findUserByUseridAndPwd(map);
		return user;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/controller/MybatisTestController/getTwoCursor")
	public void getTwoCursor(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaa", "aaa");
		map.put("bbb", new BigDecimal("160629101759"));
		map.put("ccc", new java.sql.Date(0));
		map.put("ddd", 'a');
		map.put("eee", 291019);
		mybatisTestService.getTwoCursor_proc_test_getList2_2(map);
		//System.out.println(map.get("rt").getClass().getName());
		List<Object> list = (List<Object>)map.get("rt1");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).toString()).append("<br/>");
		}
		list = (List<Object>)map.get("rt2");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).toString()).append("<br/>");
		}
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.print(map.get("rt1").getClass().getName());
		out.print(map.get("rt2").getClass().getName());
		out.flush();
		out.close();
	}
}
