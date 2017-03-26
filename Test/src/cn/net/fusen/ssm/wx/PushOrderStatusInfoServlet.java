package cn.net.fusen.ssm.wx;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.net.fusen.ssm.utils.CommonUtils;
import cn.net.fusen.ssm.utils.DBResource;
import cn.net.fusen.ssm.utils.DaoSupport;
import cn.net.fusen.ssm.wx.utils.R_WX;

public class PushOrderStatusInfoServlet extends HttpServlet {

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

		request.setCharacterEncoding("utf-8");
		String aaa = request.getParameter("aaa");
		String bbb = request.getParameter("bbb");
		Map<String, String> params = CommonUtils.parseParamsStr(bbb);
		//根据erpoid查到openid
		List<String> openid = new ArrayList<String>();
		DBResource dbres = DaoSupport.executeProcedureWithOutParam("{call proc_getopenidbyerpoid(?,?)}", new Object[]{params.get("ERPOID")}, new int[]{-10});
		CallableStatement cs = (CallableStatement)dbres.getPreparedStatement();
		try {
			ResultSet rs = (ResultSet)cs.getObject(2);
			while(rs.next()){
				openid.add(rs.getString("openid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DaoSupport.closeDBRes(dbres);
		}
		if (openid.size()<1) {
			response.getWriter().print("根据erpoid差不到openid!");
			return;
		}
		
		String apiUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
		if("PUSH_ORDER_STATUS_INFO_FA".equals(aaa)){
			//发货提醒
			for (int i = 0; i < openid.size(); i++) {
				String postData = "{    \"touser\": \""+openid.get(i)+"\",    \"template_id\": \"HaFDkfGlQw5rNQ_vIK96JnsmAZy4tpRZkGeXjpOTLTk\",    \"url\": \"\",    \"topcolor\": \"#FF0000\",    \"data\": {        \"first\": {            \"value\": \""+params.get("1")+"\",            \"color\": \"#173177\"        },        \"keyword1\": {            \"value\": \""+params.get("2")+"\",            \"color\": \"#173177\"        },        \"keyword2\": {            \"value\": \""+params.get("3")+"\",            \"color\": \"#173177\"        },        \"keyword3\": {            \"value\": \""+params.get("4")+"\",            \"color\": \"#173177\"        },\"keyword4\": {            \"value\": \""+params.get("5")+"\",            \"color\": \"#173177\"        },\"keyword5\": {            \"value\": \""+params.get("6")+"\",            \"color\": \"#173177\"        },\"remark\": {            \"value\": \""+params.get("7")+"\",            \"color\": \"#173177\"        }    }}";
				String result = HttpRequestUtils.requestStringPost(apiUrl+R_WX.ACCESS_TOKEN_wei, postData);
				System.out.println(result);
			}
			//response.getWriter().print("ok");
			
		}else if("PUSH_ORDER_STATUS_INFO_SHOU".equals(aaa)){
			//收获提醒
			for (int i = 0; i < openid.size(); i++) {
				String postData = "{    \"touser\": \""+openid.get(i)+"\",    \"template_id\": \"AAf5e8u62Tr6yfrh8MhgjNvLMQnk9iuoQtz7JOHx2LI\",    \"url\": \"\",    \"topcolor\": \"#FF0000\",    \"data\": {        \"first\": {            \"value\": \""+params.get("1")+"\",            \"color\": \"#173177\"        },        \"keyword1\": {            \"value\": \""+params.get("2")+"\",            \"color\": \"#173177\"        },        \"keyword2\": {            \"value\": \""+params.get("3")+"\",            \"color\": \"#173177\"        },        \"keyword3\": {            \"value\": \""+params.get("4")+"\",            \"color\": \"#173177\"        },\"remark\": {            \"value\": \""+params.get("5")+"\",            \"color\": \"#173177\"        }    }}";
				HttpRequestUtils.requestStringPost(apiUrl+R_WX.ACCESS_TOKEN_wei, postData);
			}
			//response.getWriter().print("ok");
			
		}
	}
}
