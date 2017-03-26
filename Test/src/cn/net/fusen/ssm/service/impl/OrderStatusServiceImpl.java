package cn.net.fusen.ssm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.net.fusen.ssm.mapper.OrderStatusMapper;
import cn.net.fusen.ssm.service.OrderStatusService;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

	@Autowired
	private OrderStatusMapper mapper;
	
	public void getErpoidByOpenid(Map<String, String> map) throws Exception {
		mapper.getErpoidByOpenid(map);
	} 

}
