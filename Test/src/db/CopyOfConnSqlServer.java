package db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CopyOfConnSqlServer {
	/*static{
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
		
		
	}*/
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
//		String url = "jdbc:oracle:thin:@10.1.1.42:1521:fusen42";
		String url = "jdbc:sqlserver://10.1.1.31:1433;databasename=fusenTarget";
		// "jdbc:mysql://localhost:3306/数据库名?characterEncoding=utf-8";
		String user = "sa";
		String password = "jpmg4r8d";
//		String sql = "SELECT TOP 1 erploggeroid, logid, logtime, webserviceno,params,operationtype, step FROM erplogger ORDER BY logtime ASC";
//		String user = "aws6";
//		String password = "aws6";
		String sql = "SELECT top 10  *  FROM( 	SELECT  ROW_NUMBER() OVER (order by ttt.采购单日期 DESC) as rownum, *  	FROM( 		SELECT GKW01D1.GKW01D1OID , 			( SELECT TOP 1 						PartnerShortName 			  FROM      dbo.BASB001 			  WHERE     BASB001OID = alGKW01_FK.BASB001_FK 			) AS '客户简称' , 			alGKW01_FK.GKWNo AS '采购单号' , 			alGKW01_FK.GCDate AS '采购单日期' , 			GKW01D1.FIName '终端客户名称', 			GKW01D1.FIProNo '终端项目编号', 			GKW01D1.FIOrdNo '终端订单号码', 			GKW01D1.FIWLNo '终端物料编码', 			GKW01D1.MZCWLNo '模组厂物料编码', 			GKW01D1.Suplier '供应商', 			GKW01D1.FIBrand '品牌', 			GKW01D1.GCChip '摄像头芯片型号', 			GKW01D1.GCQty '项目总数', 			GKW01D1.YCKqty '模组成品发货数量', 			( ISNULL(GCQty, 0) - ISNULL(YCKqty, 0) ) AS '模组成品未发货数量' , 			GKW01D1.GKW01_FK ,        			alGKW01_FK.BASB001_FK AS '客户外键' 		FROM    GKW01D1 			LEFT OUTER JOIN GKW01 alGKW01_FK ON GKW01D1.GKW01_FK = alGKW01_FK.GKW01OID WHERE alGKW01_FK.BASB001_FK = '000D8AF8-0000-0000-0000-0000225F72F1' 	)as ttt 	 )as uuu where uuu.rownum>20";
		//String sql = "DECLARE @NumberNO varchar(20) exec PR_GetDocno 'YA',@NumberNO OUTPUT   SELECT @NumberNO AS NumberNO";
//		String param2 = "c76d972c-20b2-42ca-b62a-cd01d060321a";
//		Date param1 = new Date(0);
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Class.forName("com.mysql.jdbc.Driver");//或者"org.gjt.mm.mysql.Driver"
			conn = DriverManager.getConnection(url, user, password);
			pt = conn.prepareStatement(sql);
//			pt.setObject(1, param1);
//			pt.setObject(2, param2);
			
//			pt.executeUpdate();
			rs = pt.executeQuery();
			
			while (rs.next()) {
//				System.out.println(rs.getObject("rownum"));
//				System.out.println(rs.getObject("GKW01D1OID"));
				System.out.println(rs.getObject("PartnerShortName"));
//				System.out.println(rs.getObject(4));
//				System.out.println(rs.getObject(5));
//				System.out.println(rs.getObject("nUm"));
//				BigDecimal bgd = rs.getBigDecimal(1);
//				System.out.println(bgd);
//				int bgdint = rs.getInt(1);
//				System.out.println(bgdint);
//				System.out.println(rs.getObject("name"));
//				System.out.println(rs.getObject("age"));
//				System.out.println(rs.getObject("birthday"));
//				System.out.println(rs.getObject("gender"));
//				System.out.println(rs.getObject("photo"));
//				Object obj = rs.getObject("isend");
//				System.out.println(obj.getClass().getName());
//				System.out.println(rs.getObject("logid").getClass().getName());
//				System.out.println(rs.getObject("logtime").getClass().getName());
//				System.out.println(rs.getObject("webserviceno").getClass().getName());
//				System.out.println(rs.getObject("params").getClass().getName());
//				System.out.println(rs.getObject("operationtype").getClass().getName());
//				System.out.println(rs.getObject("step").getClass().getName());
			}


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
	
	}
}
