package cn.net.fusen.ssm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.net.fusen.ssm.mapper.UserMapper;
import cn.net.fusen.ssm.po.User;
import cn.net.fusen.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	public User findUserByUseridAndPwd(Map<String, String> map) throws Exception {
		return mapper.findUserByUseridAndPwd(map);
	}

	public int addUser(User user) throws Exception {
		return mapper.addUser(user);
	}

	public void getMenuTree(Map<String, Object> map) throws Exception {
		mapper.getMenuTree(map);
	}

}
