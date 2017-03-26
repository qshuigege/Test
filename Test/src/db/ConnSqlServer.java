package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

import javax.sound.midi.SysexMessage;

public class ConnSqlServer {
	private static Connection conn = null;
	private PreparedStatement pt = null;
	private ResultSet rs = null;
	static{
		String url = "jdbc:oracle:thin:@10.1.1.52:1521:fsorcl";
		String user = "fsaws";
		String password = "aws6";
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("创建数据库连接失败！");
				System.out.println(e.getMessage());
				
			}
	}
	public void connDB(String sql){
		System.out.println("this-->"+this);
		try {
			pt = conn.prepareStatement(sql);
			PreparedStatement pt2 = conn.prepareStatement(sql);
			
			System.out.println(pt==pt2);
			rs = pt.executeQuery();
			rs.next();
			System.out.println(rs.getObject(1));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DaoSupport.close(null, pt, rs);
		}
		
		
	}
	public static void main(String[] args) {/*
		String url = "jdbc:oracle:thin:@10.1.1.52:1521:fsorcl";
		// String url = "jdbc:sqlserver://localhost:1433;databasename=master";
		// String url =
		// "jdbc:mysql://localhost:3306/数据库名?characterEncoding=utf-8";
		String user = "fsaws";
		String password = "aws6";
		String sql = "select id, createuser from bo_act_menb_getno_forerp";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Class.forName("com.mysql.jdbc.Driver");//或者"org.gjt.mm.mysql.Driver"
			conn = DriverManager.getConnection(url, user, password);
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int count = metaData.getColumnCount();
			System.out.println(count);
			while (rs.next()) {
				System.out.println(rs.getObject(1));
				String date = (String)rs.getObject("createuser");
				System.out.println(rs.getObject("id"));
			}
			
			System.out.println("conn-->"+conn);
			conn.close();
			System.out.println("conn2-->"+conn);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pt != null)
					pt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	*/
		
	
	
	ConnSqlServer obj = new ConnSqlServer();
	for (int i = 0; i < 2; i++) {
		obj.connDB("select id, createuser from bo_act_menb_getno_forerp");
	}
	
	}
}
