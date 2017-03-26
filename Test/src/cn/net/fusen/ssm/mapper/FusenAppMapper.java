package cn.net.fusen.ssm.mapper;

import org.apache.ibatis.annotations.Param;


public interface FusenAppMapper {

	public Integer selectPSSTATUS(@Param(value="psorder") String psorder);
}
