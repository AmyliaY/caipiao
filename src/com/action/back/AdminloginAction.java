package com.action.back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Admin;
import com.service.back.AdminloginService;

@Controller
@RequestMapping("/adminlogin.do")
public class AdminloginAction {
	
	@Autowired
	private AdminloginService loginService;
	
	@RequestMapping(params = "p=login")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String yzm = request.getParameter("yzm");
		String code = (String) request.getSession().getAttribute("code");
		String retString = null;
		if (yzm == null || yzm.equalsIgnoreCase(code) == false) {
			return "yzm";
		}
		Admin admin = loginService.login(username, password);
		request.getSession().setAttribute("admin", admin);
		if (admin != null) {
			return "true";
		} else
			return "false";
	}
	
	@RequestMapping(params="p=tomain")
	public String tomain(HttpServletRequest request, HttpServletResponse response)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		return "/admin/admin.jsp";
	}
}
