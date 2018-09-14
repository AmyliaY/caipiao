package com.action.back;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.guice.RequestParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Admin;
import com.pojo.Cpzchongzhijilu;
import com.pojo.Dingdan;
import com.service.back.GoodsorderService;

@Controller
@RequestMapping("/goodsorder.do")
public class GoodsorderAction {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private GoodsorderService service;
	
	@RequestMapping(params="p=orderslisting")
	public String orderslisting(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="5") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		System.out.println(id);
		String mintime = request.getParameter("mintime");
		String maxtime = request.getParameter("maxtime");
		String status = request.getParameter("status");
		Map map = service.goodsorderlisting(id,mintime,maxtime,status);
		request.setAttribute("map", map);
		return "/admin/goodsorder/goodsorderlisting.jsp";
	}
	
	@RequestMapping(params="p=delete")
	@ResponseBody
	public String delete()
	{
		String id = request.getParameter("kjId");
		System.out.println(id);
		service.delete(id);
		return "success";
	}
	
	@RequestMapping(params = "p=getgoodsorderById")
	public String getChongzhijiluById() {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		System.out.println(id);
		Dingdan dingdan = service.getgoodsorderById(id);
		request.setAttribute("dingdan", dingdan);
		return "admin/goodsorder/goodsorder_bianji.jsp";
	}
	
	@RequestMapping(params="p=getjiedancpdid")
	@ResponseBody
	public String getjiedancpdid()
	{
		
		String json = service.getjiedancpdid();
		return json;
	}
	
	@RequestMapping(params = "p=bianji")
	@ResponseBody
	public String bianji() {
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String time = request.getParameter("time");
		String money = request.getParameter("money");
		String begintime = request.getParameter("begintime");
		String endtime = request.getParameter("endtime");
		String num = request.getParameter("num");
		String status = request.getParameter("status");
		String jiedancpd1 = request.getParameter("jiedancpd1");
		String jiedancpd2 = request.getParameter("jiedancpd2");
		String jiedancpd3 = request.getParameter("jiedancpd3");
		String jiedancpd4 = request.getParameter("jiedancpd4");
		String jiedancpd5 = request.getParameter("jiedancpd5");
		String shijizhongbiaocpd = request.getParameter("shijizhongbiaocpd");
		service.bianji(id, time, phone, money, begintime, endtime, num,status,jiedancpd1,jiedancpd2,jiedancpd3,jiedancpd4,jiedancpd5,shijizhongbiaocpd);
		return "success";
	}
}
