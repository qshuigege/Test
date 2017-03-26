package cn.net.fusen.ssm.controller.sqlserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.net.fusen.ssm.po.ChengPinChuKu_addrInfo;
import cn.net.fusen.ssm.service.TestPoService;

@Controller
public class TestSqlServerDBController {

	@Autowired
	private TestPoService service;
	
	@RequestMapping("/controller/sqlserver/TestSqlServerDBController/test")
	public void test(HttpServletResponse response) throws IOException, Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("webserviceno", "BE_BAS0001");
		response.getWriter().print(service.findB2b001oidByWebserviceno(map).getB2b001oid());
	}

	@RequestMapping("/controller/sqlserver/TestSqlServerDBController/testInsertWithReturnPK")
	public void testInsertWithReturnPK(HttpServletResponse response) throws IOException, Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("webserviceno", "BE_BAS0001");
		ChengPinChuKu_addrInfo addr = new ChengPinChuKu_addrInfo();
		addr.setGKWDEL01ADDOID(UUID.randomUUID().toString());
		addr.setAtt("atttttttt");
		addr.setBASB001_FK("000C814C-0000-0000-0000-00002267999B");
		addr.setSendAdd("sendaddddddd");
		addr.setSendCom("sendCommmmmmm");
		addr.setSendDetailAdd("sendDetailAddddddddddd");
		addr.setTel("Telllllllllll");
		service.insertWithReturnPK(addr);
		response.getWriter().print(addr.toString());
	}

	@RequestMapping("/controller/sqlserver/TestSqlServerDBController/testInsertByBatch")
	public void testInsertByBatch(HttpServletResponse response) throws IOException, Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("webserviceno", "BE_BAS0001");
		ChengPinChuKu_addrInfo addr1 = new ChengPinChuKu_addrInfo();
		addr1.setAtt("atttttttt");
		addr1.setBASB001_FK("000C814C-0000-0000-0000-00002267999B");
		addr1.setSendAdd("sendaddddddd");
		addr1.setSendCom("sendCommmmmmm");
		addr1.setSendDetailAdd("sendDetailAddddddddddd");
		addr1.setTel("Telllllllllll");
		ChengPinChuKu_addrInfo addr2 = new ChengPinChuKu_addrInfo();
		addr2.setAtt("atttttttt");
		addr2.setBASB001_FK("000C814C-0000-0000-0000-00002267999B");
		addr2.setSendAdd("sendaddddddd");
		addr2.setSendCom("sendCommmmmmm222");
		addr2.setSendDetailAdd("sendDetailAddddddddddd");
		addr2.setTel("Telllllllllll");
		List<ChengPinChuKu_addrInfo> list = new ArrayList<ChengPinChuKu_addrInfo>();
		list.add(addr1);
		list.add(addr2);
		
		service.insertByBatch(list);
		response.getWriter().print("How are you Indian Mi fans?");
	}
	
}
