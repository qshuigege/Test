package cn.net.fusen.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.net.fusen.ssm.mapper.BO;
import cn.net.fusen.ssm.mapper.MobileOrder;
import cn.net.fusen.ssm.po.OrderLogistics;
import cn.net.fusen.ssm.po.UserOrder;
@Service
public class MobileOrderImpl {
	@Autowired
	private MobileOrder mobileOrder;
	/**
	 * 实现查询用户进口订单
	 * @param bo
	 * @return
	 */
	public List<UserOrder> selectGetuserOrder(BO bo){
		List<UserOrder> userOrder = mobileOrder.selectGetUserOrder(bo);
		
		return userOrder;
	}
	/**
	 * 实现查询用户订单的本地物流信息
	 * @param ERPUSEROID
	 * @return
	 */
	public List<OrderLogistics> selectGetOrderLogistics(String ERPUSEROID){
		List<OrderLogistics> orderlogistics = mobileOrder.selectGetOrderLogistics(ERPUSEROID);
		return orderlogistics;
	}
}
