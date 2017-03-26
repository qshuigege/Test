package cn.net.fusen.ssm.wx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.fusen.ssm.utils.DBResource;
import cn.net.fusen.ssm.utils.DaoSupport;
import net.sf.json.JSONObject;

public class WeiXinWangYeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String apiUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxf48eadf1ba6a4e64&secret=2351893b2755f98c823a0bf527746ad7&code="+code+"&grant_type=authorization_code";
		String jsonData = HttpRequestUtils.requestStringGet(apiUrl);
		JSONObject jo = JSONObject.fromObject(jsonData);
		String openid = (String)jo.get("openid");
		String access_token = (String)jo.get("access_token");
		DBResource dbres = DaoSupport.executeProcedureWithOutParam("{call proc_geterpoidbyopenid(?,?)}", new Object[]{openid}, new int[]{12});
		CallableStatement cs = (CallableStatement)dbres.getPreparedStatement();
		String erpoid = "";
		try {
			erpoid = (String)cs.getObject(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DaoSupport.closeDBRes(dbres);
		request.setAttribute("erpoid", erpoid);
		request.getRequestDispatcher("/WEB-INF/jsp/wx/orderQueryIndex.jsp").forward(request, response);
	}
}
