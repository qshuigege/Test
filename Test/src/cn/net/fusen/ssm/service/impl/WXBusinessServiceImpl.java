package cn.net.fusen.ssm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.net.fusen.ssm.mapper.WXBusinessMapper;
import cn.net.fusen.ssm.po.WXAccount;
import cn.net.fusen.ssm.service.WXBusinessService;

@Service
public class WXBusinessServiceImpl implements WXBusinessService {

	@Autowired
	private WXBusinessMapper wxBusinessMapper;
	
	public int isBinded(String unionid) throws Exception {
		return wxBusinessMapper.isBinded(unionid);
	}

	public String getOrgidByUniqueid(String uniqueid) throws Exception {
		return wxBusinessMapper.getOrgidByUniqueid(uniqueid);
	}

	public int binding(Map<String, String> map) throws Exception {
		return wxBusinessMapper.binding(map);
	}

	public int unbinding(String unionid) throws Exception {
		return wxBusinessMapper.unbinding(unionid);
	}

	public void addAcc(WXAccount wxAccount) throws Exception {
		wxBusinessMapper.addAcc(wxAccount);
	}

}
