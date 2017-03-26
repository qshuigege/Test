package cn.net.fusen.ssm.mapper;

import java.util.Map;

import cn.net.fusen.ssm.po.WXAccount;


public interface WXBusinessMapper {
	/**
	 * 从wxacc_orguser_relation表中查询是否绑定
	 * @param unionid
	 * @return
	 * @throws Exception
	 */
	public int isBinded(String unionid)throws Exception;
	/**
	 * orguser表中根据uniqueid查到id
	 * @param uniqueid
	 * @return
	 * @throws Exception
	 */
	public String getOrgidByUniqueid(String uniqueid) throws Exception;
	
	public int binding(Map<String, String> map) throws Exception;
	
	public int unbinding(String unionid) throws Exception;
	
	public void addAcc(WXAccount wxAccount) throws Exception;

}
