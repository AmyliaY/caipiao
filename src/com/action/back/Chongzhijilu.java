package com.action.back;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Admin;
import com.pojo.Userschongzhijilu;
import com.service.back.ChongzhijiluService;
import com.util.StringUtil;

/**
 * @author marisheng
 */
@Controller
@RequestMapping("/chongzhirecord.do")
public class Chongzhijilu {
	
	@Autowired
	private ChongzhijiluService service;
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(params="p=chongzhilisting")
	public String chongzhilisting(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="5") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String mintime = request.getParameter("mintime");
		String maxtime = request.getParameter("maxtime");
		String id = request.getParameter("id");
		System.out.println(id);
		Map map = service.chongzhilisting(page,size,mintime,maxtime,id);
		request.setAttribute("map", map);
		return "/admin/chongzhijilu/chongzhijilu.jsp";
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
	
	@RequestMapping(params="p=getChongzhijiluById")
	public String getChongzhijiluById()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		System.out.println(id);
		Userschongzhijilu userschongzhijilu = service.chongzhijilu_bianji(id);
		request.setAttribute("userschongzhijilu", userschongzhijilu);
		return "admin/chongzhijilu/chongzhijilu_bianji.jsp";
	}
	
	@RequestMapping(params="p=getdingdanid")
	@ResponseBody
	public String getdingdanid()
	{
		String json = service.getdingdanid();
		return json;
	}
	
	@RequestMapping(params="p=bianji")
	@ResponseBody
	public String bianji(){
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String time = request.getParameter("time");
		String money = request.getParameter("money");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		String dingdanid = request.getParameter("dingdanid");
		service.bianji(id,time,phone,money,type,status,dingdanid);
		return "success";
	}
}
