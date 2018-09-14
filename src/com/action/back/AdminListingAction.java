package com.action.back;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Admin;
import com.service.back.AdminListingService;

@Controller
@RequestMapping("/admin.do")
public class AdminListingAction {
	
	@Autowired
	private AdminListingService service;
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(params="p=adminlisting")
	public String adminlisting(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="5") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin!=null)
		{
			
		}
		else 
		{
			return "redirect:/admin/login.jsp";
		}
		System.out.println(111);
		Map adminmap = service.adminlisting(page, size);
		request.setAttribute("adminmap",adminmap);
		System.out.println(adminmap);
		return "/admin/adminlisting/adminlisting.jsp";
	}
	
	@RequestMapping(params="p=addAdmin")
	@ResponseBody
	public String addAdmin()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		service.addadmin(name,username,password);
		return "success";
	}
	
	@RequestMapping(params="p=editpwd")
	@ResponseBody
	public String editpwd()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		service.editpwd(id);
		
		return "true";
	}
	
	@RequestMapping(params="p=tuichu")
	public String tuichu() 
	{
		request.getSession().removeAttribute("admin");
		return "/admin/login.jsp";
	}
}
