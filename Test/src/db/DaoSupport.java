package db;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DaoSupport<T> {
	protected static Connection conn = getConnection();

	public static Connection getConnection() {
		if (conn == null) {
			String url = "jdbc:oracle:thin:@10.1.1.52:1521:fsorcl";
			String user = "fsaws";
			String password = "aws6";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return conn;
	}

	/**
	 * 查询数据库记录并组装成实体对象(支持只查询部分字段)
	 * @param clazz
	 * @param sql
	 * @param params sql语句中的占位符相对应的参数,如果sql语句中没有点位符,该参数可以传null
	 * @return
	 */
	public static <E> List<E> getRecords(Class<E> clazz, String sql, Object[] params){

		List<E> list = new ArrayList<E>();
//		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
//			conn = DBSql.open();
			pt = conn.prepareStatement(sql);
			
			if (params!=null) {
				for (int i = 0; i < params.length; i++) {
					pt.setObject(i+1, params[i]);
				}
			}
			rs = pt.executeQuery();
			
			Field[] fields = clazz.getDeclaredFields();//通过反射取得实体所有字段
			Map<String, Field> fieldMap = new HashMap<String, Field>();//保存所有field
			Map<String, String> fieldNameMap = new HashMap<String, String>();//保存实体的所有字段名
			
			String fieldName = null;
			int fieldsCount = fields.length;//实体类字段个数
			for (int i = 0; i < fieldsCount; i++) {
				fieldName = fields[i].getName();
				fieldMap.put(fieldName, fields[i]);
				fieldNameMap.put(fieldName.toUpperCase(), fieldName);
			}
			
			
			ResultSetMetaData metaData = rs.getMetaData();
			int rsColumnCount = metaData.getColumnCount();//查询结果的列数
			
			// 组装Bean
			E t = null;
			Object value = null;
			String fieldClassName = null;
			while (rs.next()) {
				t = clazz.newInstance();
				for (int i = 0; i < rsColumnCount; i++) {
					fieldName = fieldNameMap.get((metaData.getColumnName(i+1)).toUpperCase());
					System.out.println("fieldName-->"+ fieldName);
					fieldClassName = fieldMap.get(fieldName).getType().getName();
					System.out.println("fieldClassName-->"+fieldClassName);
					try{//如果数据库中的数据有异常(比如数据库中整形字段的值为null,日期类型的字段为null等等)
						value = rs.getObject(fieldName);
						if (value instanceof BigDecimal&&"java.lang.Integer".equals(fieldClassName)) {
							value = ((BigDecimal)(value)).intValue();
						}
					}catch(Exception e){
						if ("java.util.Date".equals(fieldClassName)) {//如果字段是日期类型
							value = new Date(0);
						}else if ("java.lang.Integer".equals(fieldClassName)) {//如果字段是整型
							value = new Integer(-1);
						}
					}
					
					fieldMap.get(fieldName).setAccessible(true);
					fieldMap.get(fieldName).set(t, value);

				}
				
				
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally{
//			DBSql.close(conn, pt, rs);//释放数据库资源
			close(conn, pt, rs);
		}
		
		
		return list;
	}

	/**
	 * 释放数据库资源
	 * 
	 * @param conn
	 * @param pt
	 * @param rs
	 */
	public static void close(Connection conn, PreparedStatement pt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pt != null) {
					pt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 往数据库插入一条记录(通过JDBC)
	 * 
	 * @param sql 
	 * @param params
	 */
	public static void save(String sql, Object[] params){
		PreparedStatement pt = null;
		try {
			pt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pt.setObject(i+1, params[i]);
			}
			
			pt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(conn, pt, null);
		}
		
	}
}
