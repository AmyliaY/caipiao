package com.action.back;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Admin;
import com.pojo.Caipiaodian;
import com.pojo.Dingdan;
import com.pojo.Userschongzhijilu;
import com.service.back.UsersCaiWuService;

@Controller
@RequestMapping("/userscaiwu.do")
public class UsersCaiWuAction {
	
	@Autowired
	private UsersCaiWuService service;
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(params="p=userscaiwu")
	public String usercaiwu(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="10") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		Map map = service.userscaiwu(page,size);
		request.setAttribute("map", map);
		return "/admin/userscaiwu_guanli/userscaiwu.jsp";
	}
	
	@RequestMapping(params="p=userschongzhi")
	public String userchongzhi(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="10") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		Map map = service.userschongzhi(page,size);
		request.setAttribute("map", map);
		return "/admin/userscaiwu_guanli/userschongzhi.jsp";
	}
	
	@RequestMapping(params="p=usercaiwu_bianji")
	public String usercaiwu_bianji()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		List list = service.usercaiwu_bianji(id);
		request.setAttribute("list", list);
		return "/admin/userscaiwu_guanli/userscaiwu_bianji.jsp";
	}
	
	@RequestMapping(params="p=userscaiwu_bianji_tijiao")
	@ResponseBody
	public String userscaiwu_bianji_tijiao()
	{
		
		String id = request.getParameter("id");
		String usersname = request.getParameter("username");
		String phone = request.getParameter("phone");
		String touxiang = request.getParameter("touxiang");
		String jifen = request.getParameter("jifen");
		String dongjie = request.getParameter("dongjie");
		String yitixian = request.getParameter("yitixian");
		service.tijiao(id,usersname,phone,touxiang,jifen,dongjie,yitixian);
		return "success";
	}
	
	@RequestMapping(params="p=userscaiwu_bianji_json")
	@ResponseBody
	public String userscaiwu_bianji_json()
	{
		String id = request.getParameter("id");
		String json = service.bianji_json(id);
		return json;
	}
	
	@RequestMapping(params="p=userschongzhi_bianji")
	public String userschongzhi_bianji_json()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		Userschongzhijilu userschongzhijilu = service.chongzhibianji(id);
		request.setAttribute("userschongzhijilu", userschongzhijilu);
		request.setAttribute("status", "tijiao");
		return "/admin/userscaiwu_guanli/userschongzhi_bianji.jsp";
	}
	
	@RequestMapping(params="p=usersjson")
	@ResponseBody
	public String usersjson() 
	{
		String json = service.usersjson();
		return json;
	}
	
	@RequestMapping(params="p=chongzhitijiao")
	public String zhongZhiTiJiao() throws ServletException, IOException 
	{	
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String money = request.getParameter("money");
		String time = request.getParameter("time");
		String type = request.getParameter("type");
		service.chongZhiTiJiao(id,phone,money,time,type);
		request.setAttribute("status", "success");
		return "/admin/userscaiwu_guanli/userschongzhi_bianji.jsp";
	}
	
	@RequestMapping(params="p=usersxiaofei")
	public String userxiaofei(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="10") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		Map map = service.usersxiaofei(page,size);
		request.setAttribute("map", map);
		return "/admin/userscaiwu_guanli/usersxiaofei.jsp";
	}
	
	@RequestMapping(params="p=usersxiaofei_bianji")
	public String usersxiaofei_bianji()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		Dingdan dingdan = service.usersxiaofei_bianji(id);
		request.setAttribute("dingdan", dingdan);
		request.setAttribute("status", "tijiao");
		return "/admin/userscaiwu_guanli/usersxiaofei_bianji.jsp";
	}
	
	@RequestMapping(params="p=xiaofeitijiao")
	public String xiaofeitijiao()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String num = request.getParameter("num");
		String money = request.getParameter("money");
		service.tijiao(id,phone,num,money);
		request.setAttribute("status", "success");
		return "/admin/userscaiwu_guanli/usersxiaofei_bianji.jsp";
	}
	
	@RequestMapping(params="p=storescaiwu_bianji")
	public String storescaiwu_bianji()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		Caipiaodian caipiaodian= service.storescaiwu_bianji(id);
		request.setAttribute("caipiaodian", caipiaodian);
		request.setAttribute("status", "tijiao");
		return "/admin/userscaiwu_guanli/storescaiwu_bianji.jsp";
	}
	
	@RequestMapping(params="p=storescaiwu")
	public String storescaiwu(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="10") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		Map map = service.storescaiwu(page,size);
		request.setAttribute("map", map);
		return "/admin/userscaiwu_guanli/storescaiwu.jsp";
	}
	
	@RequestMapping(params="p=storescaiwutijiao")
	public String storescaiwutijiao()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String ketixian = request.getParameter("ketixian");
		String dongji = request.getParameter("dongji");
		String yitixian = request.getParameter("yitixian");
		service.storescaiwutijiao(id,phone,ketixian,dongji,yitixian);
		request.setAttribute("status", "success");
		return "/admin/userscaiwu_guanli/storescaiwu_bianji.jsp";
	}
}
