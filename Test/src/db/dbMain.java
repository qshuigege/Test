package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dbMain {
	public static void main(String[] args) {
		/*String sql = "select ZDRZH,JKDDH,CGDDH,SFYY,SFYX,BZ from bo_act_menb_getno_forerp t where t.createuser = ? order by t.createdate desc";
		List<FANO> list = DaoSupport.getRecords(FANO.class, sql, new Object[]{"admin"});
		String json = new Gson().toJson(list);
		System.out.println(json);
		System.out.println("==========================================");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/
//		String sql2 = "insert into orguser (id, userid, password, closed) values(?, ?, ?, ?)";
//		DaoSupport.save(sql2, new Object[]{new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), "84cf150730c28fe444b3f507142dba68", 0});
		String sql2 = "select * from orguser";
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "aws6";
			String password = "aws6";
				try {
					conn = DriverManager.getConnection(url, user, password);
					pt = conn.prepareStatement(sql2);
					rs = pt.executeQuery();
					while (rs.next()) {
						String departmentid = rs.getString("departmentid");
						System.out.println("departmentid-->"+departmentid);
					}
					
				} catch (SQLException e) {
					DaoSupport.close(conn, pt, rs);
					
				}
				System.exit(0);
		}
		
}
