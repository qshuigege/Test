package cn.net.fusen.ssm.service;

import java.util.Map;

import cn.net.fusen.ssm.po.WXAccount;

public interface WXBusinessService {
	public int isBinded(String unionid)throws Exception;
	
	public String getOrgidByUniqueid(String uniqueid) throws Exception;
	
	public int binding(Map<String, String> map) throws Exception;
	
	public int unbinding(String unionid) throws Exception;
	
	public void addAcc(WXAccount wxAccount) throws Exception;

}
