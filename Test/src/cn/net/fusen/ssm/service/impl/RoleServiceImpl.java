package cn.net.fusen.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.net.fusen.ssm.mapper.RoleMapper;
import cn.net.fusen.ssm.po.Role;
import cn.net.fusen.ssm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper mapper;

	public int addRole(Role role) throws Exception {
		return mapper.addRole(role);
	}

}
