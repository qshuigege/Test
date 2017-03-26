package cn.net.fusen.ssm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.net.fusen.ssm.mapper.MybatisTestMapper;
import cn.net.fusen.ssm.po.ChengPinChuKu;
import cn.net.fusen.ssm.po.Test;
import cn.net.fusen.ssm.service.MybatisTestService;

@Service
public class MybatisTestServiceImpl implements MybatisTestService{

	@Autowired
	private MybatisTestMapper mapper;

	public int save(Test test) throws Exception {
		return mapper.save(test);
	}
	
	public List<Test> getList() throws Exception {
		return mapper.getList();
	}

	public void getListByProc(Map<String, Object> map) throws Exception {
		mapper.getListByProc(map);
	}

	public void getListByProc3(Map<String, Object> map) {
		mapper.getListByProc3(map);
	}

	public void getTwoCursor_proc_test_getList2_2(Map<String, Object> map) {
		mapper.getTwoCursor_proc_test_getList2_2(map);
	}

	@Override
	public List<ChengPinChuKu> getCaiGouDanList(Map<String, Object> map) {
		return mapper.getCaiGouDanList(map);
	}

	@Override
	public int getCaiGouDanCount(Map<String, Object> map) {
		return mapper.getCaiGouDanCount(map);
	}
	
	
	
}
