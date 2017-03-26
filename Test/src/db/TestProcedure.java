package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

public class TestProcedure {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String url = "jdbc:oracle:thin:@10.1.1.42:1521:fusen42";
//		String url = "jdbc:sqlserver://10.1.1.31:1433;databasename=fusenTarget";
		//String url = "jdbc:mysql://localhost:3306/数据库名?characterEncoding=utf-8";
//		String user = "sa";
//		String password = "jpmg4r8d";
		String user = "aws6";
		String password = "aws6";
//		String sql = "select * from B2B001";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Class.forName("com.mysql.jdbc.Driver");//或者"org.gjt.mm.mysql.Driver"
			conn = DriverManager.getConnection(url, user, password);
			cstmt = conn.prepareCall("{call proc_test_getList2_2(?,?)}");
//			cstmt.registerOutParameter(1, Types.OTHER);
//			cstmt.registerOutParameter(2, Types.OTHER);
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
//			CallableStatement cstmt = conn.prepareCall("{call PR_GetOrderNos('X03168-A',1,1)}");
//			CallableStatement cstmt = conn.prepareCall("{call PR_B2B_ZYVMQuery_4(?,?)}");
//			cstmt.setString(2, "X03168-A");PR_B2B_ZYVMQuery_4(?,?)}
//			cstmt.setInt(3, 1);
//			cstmt.setInt(4, 1);
//			cstmt.setString(1, "3");
//			cstmt.setString(2, "063660");
			//cstmt.execute();
			cstmt.execute();//返回游标这样写
			rs = (ResultSet)cstmt.getObject(1);//返回游标这样写
//			rs = cstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getObject(1));
			}
			rs.close();
			rs = null;
			rs = (ResultSet)cstmt.getObject(2);//返回游标这样写
			while (rs.next()) {
				System.out.println(rs.getObject(1));
			}
			System.out.println("----------------what fuck?--------------");
			/*while(cstmt.getMoreResults()&&cstmt.getUpdateCount()==-1){
				rs = cstmt.getResultSet();
				while(rs.next()){
					System.out.println(rs.getObject(1));
//					rs.close();
				}
				System.out.println("------------------------------------");
			}*/
			

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
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	
		
	}

}
