package cn.net.fusen.ssm.service;

import java.util.List;
import java.util.Map;

import cn.net.fusen.ssm.po.ChengPinChuKu_addrInfo;
import cn.net.fusen.ssm.po.TestPo;

public interface TestPoService {

	public TestPo findUserById(Map<String, String> map) throws Exception;
	
	public TestPo findB2b001oidByWebserviceno(Map<String, String> map) throws Exception;

	public int insertWithReturnPK(ChengPinChuKu_addrInfo addr)throws Exception;

	public void insertByBatch(List<ChengPinChuKu_addrInfo> list) throws Exception;

}
