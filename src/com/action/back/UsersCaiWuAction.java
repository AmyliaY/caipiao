package com.action.back;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		Map map = service.userscaiwu(page,size);
		request.setAttribute("map", map);
		return "/admin/userscaiwu_guanli/userscaiwu.jsp";
	}
	@RequestMapping(params="p=usercaiwu_bianji")
	public String usercaiwu_bianji()
	{
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
}
