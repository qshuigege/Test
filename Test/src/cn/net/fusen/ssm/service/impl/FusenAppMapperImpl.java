package cn.net.fusen.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.net.fusen.ssm.mapper.FusenAppMapper;
import cn.net.fusen.ssm.wx.utils.DynamicDataSource;

@Service
public class FusenAppMapperImpl {

	@Autowired
	private FusenAppMapper appMapper;
	
	public Integer selectPSSTATUS(String psorder){
		return appMapper.selectPSSTATUS(psorder);
	}
}
