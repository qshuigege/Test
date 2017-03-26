package cn.net.fusen.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import cn.net.fusen.ssm.po.OrderLogistics;
import cn.net.fusen.ssm.po.UserOrder;

public interface MobileOrder {
	public List<UserOrder>  selectGetUserOrder(BO bo);
	public List<OrderLogistics> selectGetOrderLogistics(@Param(value="ERPUSEROID") String ERPUSEROID);
}
