package com.action.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.Caipiaodian;
import com.pojo.Dingdanxiangqing;
import com.pojo.Users;
import com.service.app.AppBuyCaipiaoService;
import com.pojo.Dingdan;
import com.pojo.Dingdanxiangqing;
import com.pojo.Users;
import com.service.app.AppBuyCaipiaoService;
import com.service.app.AppCaipiaodianYewuService;

/**
 *  @author 全恒
 */
@Controller
@RequestMapping("/caipiaodianyewu.do")
public class AppCaipiaodianYewuAction {

	@Autowired
	private HttpServletRequest request;
	@Autowired 
	private AppCaipiaodianYewuService caipiaodianYewuService;
	
	/**
	 * 彩票店进入抢单页面，查出当前地区所有的可抢订单
	 */
	@RequestMapping(params="p=qiangdan")
	@ResponseBody
	public String qiangdan(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		if(caipiaodian==null)
			return null;
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = caipiaodianYewuService.qiangdan(caipiaodian, page, size);
		return json;
	}
	
	/**
	 * 抢单(根据订单id)，将dingdan的caipiaodianByCpzid设置为当前彩票店，并修改订单状态。
	 */
	@RequestMapping(params="p=qiangdanByorderId")
	@ResponseBody
	public String qiangdanByorderId(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String orderid = request.getParameter("orderid");
		Dingdan dingdan =caipiaodianYewuService.qiangdanByorderId(orderid, caipiaodian);
		if(dingdan.getCaipiaodianByCpzid()==caipiaodian)
		return "yes";
		return "no";
	}	
	
	/**
	 * 根据订单id查看订单详情
	 */
	@RequestMapping(params="p=orderDescByorderId")
	@ResponseBody
	public String orderDescByorderId(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String orderid = request.getParameter("orderid");
		String json = caipiaodianYewuService.orderDescByorderId(orderid);
		return json;
	}
	
	/**
	 * 查看当前彩票店抢到的所有订单
	 */
	@RequestMapping(params="p=getOrders")
	@ResponseBody
	public String getOrders(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = caipiaodianYewuService.getOrders(caipiaodian, page, size);
		return json;
	}
}
