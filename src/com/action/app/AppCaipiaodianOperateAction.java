package com.action.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Caipiaodian;
import com.service.app.AppCaipiaodianOperateService;

/**
* @author 全恒
* 彩票店业务模块
*/
@Controller
@RequestMapping("/cpdOperation.do")
public class AppCaipiaodianOperateAction {
	
	@Autowired
	private AppCaipiaodianOperateService caipiaodianOperateService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * 分页查询订单记录/订单详情记录（所有）
	 */
	@RequestMapping(params="p=orders")
	@ResponseBody
	public String getOrders(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		String json = caipiaodianOperateService.getOrders(caipiaodian.getId(), page, size);
		return json;
	}
	
	/**
	 * 根据订单id，查出订单详情
	 */
	@RequestMapping(params="p=orderById")
	@ResponseBody
	public String getOrderById(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String orderid = request.getParameter("orderid");
		String json = caipiaodianOperateService.getOrderById(orderid);
		return json;
	}

	/**
	 * 进入抢单页面
	 * 查出可抢的订单
	 */
	@RequestMapping(params="p=qiangdanList")
	@ResponseBody
	public String qiangdanList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String json = caipiaodianOperateService.qiangdanList(caipiaodian);
		return json;
	}
	
	/**
	 * 进入蓝牙打印界面
	 * 查出所有的已抢订单
	 */
	@RequestMapping(params="p=lanyaDayinList")
	@ResponseBody
	public String lanyaDayinList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		caipiaodianOperateService.lanyaDayinList(caipiaodian);
		return "yes";
	}
	
	/**
	 * 进入彩票机打印界面
	 * 查出所有的已抢订单
	 */
	@RequestMapping(params="p=caipiaojiDayinList")
	@ResponseBody
	public String caipiaojiDayinList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		caipiaodianOperateService.caipiaojiDayinList(caipiaodian);
		return "yes";
	}
	
	/**
	 * 根据ID进行蓝牙打印
	 */
	
	/**
	 * 根据订单ID进行彩票机打印
	 */
	@RequestMapping(params="p=cpjDayinById")
	@ResponseBody
	public String cpjDayinById(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String orderid = request.getParameter("orderid");
		caipiaodianOperateService.cpjDayinById(orderid);
		return "yes";
	}
	
	/**
	 * 根据订单ID和抢单的店铺
	 * 执行抢单操作
	 */
	@RequestMapping(params="p=qiangdan")
	@ResponseBody
	public String qiangdan(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String orderid = request.getParameter("orderid");
		caipiaodianOperateService.qiangdan(orderid, caipiaodian);
		return "yes";
	}
	
	/**
	 * 查询出当前彩票店可接的订单数
	 */
	@RequestMapping(params="p=kejieOrderNum")
	@ResponseBody
	public String kejieOrderNum(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String num = caipiaodianOperateService.kejieOrderNum(caipiaodian);
		return num;
	}
}
