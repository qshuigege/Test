package cn.net.fusen.ssm.mapper;

import java.util.Map;

import cn.net.fusen.ssm.po.User;


public interface UserMapper {

	public User findUserByUseridAndPwd(Map<String, String> map) throws Exception;

	public int addUser(User user) throws Exception;
	
	public void getMenuTree(Map<String, Object> map) throws Exception;
}
