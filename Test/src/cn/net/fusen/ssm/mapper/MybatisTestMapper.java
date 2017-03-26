package cn.net.fusen.ssm.mapper;

import java.util.List;
import java.util.Map;

import cn.net.fusen.ssm.po.ChengPinChuKu;
import cn.net.fusen.ssm.po.Test;

public interface MybatisTestMapper {
	
	public List<Test> getList()throws Exception;
	
	public void getListByProc(Map<String, Object> map)throws Exception;
	
	public void getListByProc3(Map<String, Object> map);

	public int save(Test test) throws Exception;
	
	public void getTwoCursor_proc_test_getList2_2(Map<String, Object> map);
	
	public List<ChengPinChuKu> getCaiGouDanList(Map<String, Object> map);
	
	public int getCaiGouDanCount(Map<String, Object> map);
	
}

