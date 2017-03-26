package cn.net.fusen.ssm.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.net.fusen.ssm.po.Test;
import cn.net.fusen.ssm.service.MybatisTestService;
import cn.net.fusen.ssm.utils.CommonUtils;
import cn.net.fusen.ssm.utils.JSONUtils;
import cn.net.fusen.ssm.wx.utils.DynamicDataSource;


@Controller
@Component
public class EasyUITestController {
	
	@Autowired
	private MybatisTestService mybatisTestService;
	
	/*@RequestMapping("/controller/EasyUITestController/testMybatis")
	public void testMybatis(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.getWriter().print("testMybatis ok");
	}*/
	
	
	@RequestMapping("/controller/EasyUITestController/dataGridWithPaginationPage")
	public ModelAndView dataGridWithPaginationPage(HttpServletRequest request, HttpServletResponse response) throws Exception{

		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
		System.out.println("成品出库页面，查到第一页数据");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("erpUserOID", "000C814C-0000-0000-0000-00002267999B");
		int count = mybatisTestService.getCaiGouDanCount(map);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("total", count);
		//modelAndView.setViewName("/html/easyui-test/pagination.html");
//		List<Test> list = mybatisTestService.getList();
//		modelAndView.addObject("list", list);
		modelAndView.setViewName("easyuitest/dataGridWithPagination");
		return modelAndView;
	}
	
	
	@RequestMapping("/controller/EasyUITestController/dataGridWithPagination")
	public void dataGridWithPagination(HttpServletRequest request, HttpServletResponse response) throws Exception{
		/*ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/html/easyui-test/pagination.html");
		return modelAndView;*/
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String total = request.getParameter("total");
		String paramsStr = request.getParameter("paramsStr");
		Map<String, String> params = CommonUtils.parseParamsStr(paramsStr);
		String flag = params.get("FLAG");
		System.out.println("分页方法执行,page-->"+page+", rows-->"+rows+", paramsStr-->"+paramsStr);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", Integer.parseInt(rows));
		map.put("erpUserOID", "000C814C-0000-0000-0000-00002267999B");
		map.put("rowIndex", (Integer.parseInt(page)-1)*Integer.parseInt(rows));
		map.put("param_GKWNo", params.get("PARAM_GKWNO"));
		map.put("param_FIOrdNo", params.get("PARAM_FIORDNO"));
		System.out.println(map);
		if (flag.equals("true")) {
			total = mybatisTestService.getCaiGouDanCount(map)+"";
			System.out.println("自定义查询total-->"+total);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("total", total);
		dataMap.put("rows", mybatisTestService.getCaiGouDanList(map));
		response.getWriter().print(JSONUtils.toJsonByGsonNotDatetime(dataMap));
	}
	
	/*@Intercepts({@Signature(type=StatementHandler.class,method="prepare", args={Connection.class})})
	private class PageInterceptor implements Interceptor{

		reflectutil
		
		
		@Override
		public Object intercept(Invocation invocation) throws Throwable {
			if(invocation.getTarget() instanceof RoutingStatementHandler){  
	            RoutingStatementHandler statementHandler = (RoutingStatementHandler)invocation.getTarget();  
	            StatementHandler delegate = (StatementHandler) ReflectHelper.getFieldValue(statementHandler, "delegate");  
	            BoundSql boundSql = delegate.getBoundSql();
	            Object obj = boundSql.getParameterObject();
	            if (obj instanceof Page) {  
	                Page page = (Page) obj;  
	                //通过反射获取delegate父类BaseStatementHandler的mappedStatement属性  
	                MappedStatement mappedStatement = (MappedStatement)ReflectHelper.getFieldValue(delegate, "mappedStatement");  
	                //拦截到的prepare方法参数是一个Connection对象  
	                Connection connection = (Connection)invocation.getArgs()[0];  
	                //获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句  
	                String sql = boundSql.getSql();  
	                //给当前的page参数对象设置总记录数  
	                this.setTotalRecord(page,  
	                       mappedStatement, connection);  
	                //获取分页Sql语句  
	                String pageSql = this.getPageSql(page, sql);  
	                //利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句  
	                ReflectHelper.setFieldValue(boundSql, "sql", pageSql);  
	            } 
	        }  
	        return invocation.proceed();  
		}

		@Override
		public Object plugin(Object arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setProperties(Properties arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class Page{
		private Integer rows;  
	      
	    private Integer page = 1;  
	      
	    private Integer totalRecord;  
	  
	    public Integer getRows() {  
	        return rows;  
	    }  
	  
	    public void setRows(Integer rows) {  
	        this.rows = rows;  
	    }  
	  
	    public Integer getPage() {  
	        return page;  
	    }  
	  
	    public void setPage(Integer page) {  
	        this.page = page;  
	    }  
	  
	    public Integer getTotalRecord() {  
	        return totalRecord;  
	    }  
	  
	    public void setTotalRecord(Integer totalRecord) {  
	        this.totalRecord = totalRecord;  
	    }  
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
