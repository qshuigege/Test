package cn.net.fusen.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.net.fusen.ssm.mapper.TestPoMapper;
import cn.net.fusen.ssm.po.ChengPinChuKu_addrInfo;
import cn.net.fusen.ssm.po.TestPo;
import cn.net.fusen.ssm.service.TestPoService;

@Service
public class TestPoServiceImpl implements TestPoService{

	@Autowired
	private TestPoMapper mapper;
	
	public TestPo findUserById(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(mapper.getClass().getName());
		return mapper.findUserById(map);
	}

	public TestPo findB2b001oidByWebserviceno(Map<String, String> map)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.findB2b001oidByWebserviceno(map);
	}

	@Override
	public int insertWithReturnPK(ChengPinChuKu_addrInfo addr) throws Exception {
		// TODO Auto-generated method stub
		return mapper.insertWithReturnPK(addr);
	}

	@Override
	public void insertByBatch(List<ChengPinChuKu_addrInfo> list)
			throws Exception {
		// TODO Auto-generated method stub
		mapper.insertByBatch(list);
	}

}
