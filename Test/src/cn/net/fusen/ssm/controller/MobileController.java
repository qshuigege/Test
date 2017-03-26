package cn.net.fusen.ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import cn.net.fusen.ssm.mapper.BO;
import cn.net.fusen.ssm.po.OrderLogistics;
import cn.net.fusen.ssm.po.UserOrder;
import cn.net.fusen.ssm.service.impl.MobileOrderImpl;
import cn.net.fusen.ssm.utils.JSONUtils;
import cn.net.fusen.ssm.wx.utils.DynamicDataSource;

@Controller
public class MobileController {
	@Autowired
	private  MobileOrderImpl  orderImpl;
	
	/**
	 * 微信端---手机网页 查询显示客户进口订单信息
	 * @param ERPUSEROID
	 * @param MINONO
	 * @param MAXONO
	 * @return
	 */
	@RequestMapping("/selectGetOrderData")
	public  ModelAndView selectGetOrderData(
			@RequestParam("ERPUSEROID") String ERPUSEROID,
			@RequestParam("MINONO") Integer MINONO,
			@RequestParam("MAXONO") Integer MAXONO){
		BO bo = new BO();
		bo.setERPUSEROID(ERPUSEROID);
		bo.setMAXONO(MAXONO);
		bo.setMINONO(MINONO);
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
		List<UserOrder>  userOrder = orderImpl.selectGetuserOrder(bo);
		ModelAndView  mav = new ModelAndView("/test/mobileOrderTrack");
		mav.addObject("ERPUSEROID",userOrder);
		return mav;
	}
	/**
	 * 微信端---手机网页 查询显示客户订单的本地物流信息
	 * @param ERPUSEROID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectOrderLogistics")//, produces = "application/json; charset=utf-8")
	public String selectOrderLogistics(@RequestParam("ERPUSEROID") String ERPUSEROID){
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
		List<OrderLogistics> orderlogistics = orderImpl.selectGetOrderLogistics(ERPUSEROID);
		return JSONUtils.toJsonByGson(orderlogistics);
	}
	/*@RequestMapping("/selectOrderLogistics")
	public void selectOrderLogistics(@RequestParam("ERPUSEROID") String ERPUSEROID,HttpServletResponse response){
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
		List<OrderLogistics> orderlogistics = orderImpl.selectGetOrderLogistics(ERPUSEROID);
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().print(JSONUtils.toJsonByGson(orderlogistics));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

}
