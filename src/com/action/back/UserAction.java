package com.action.back;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Admin;
import com.pojo.Users;
import com.service.app.AppRegisterService;
import com.service.back.UserService;
import com.util.MD5Util;
import com.util.JsonFilter;
import com.util.SmsUtil;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;

@Controller
@RequestMapping("/users.do")
public class UserAction {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UserService service;
	@Autowired
	private AppRegisterService appregisterservice;

	@RequestMapping(params = "p=huiyuanzhuce")
	private void doTest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("到了验证码1");
		String mobile = request.getParameter("iphone");
		System.out.println(mobile);
		String code = SmsUtil.createCode(4);
		String content = "您的验证码为:" + code;
		appregisterservice.saveCode(code, mobile);
		// request.getSession().setAttribute("code", code);
		System.out.println("到了验证码2");
		SmsUtil.send(mobile, content);
	}

	// 注册
	@RequestMapping(params = "p=zhuce")
	@ResponseBody
	public String zhuce() {
		String mobile = request.getParameter("userName");
		System.out.println("啥子：" + mobile);
		String pwd = request.getParameter("pwd");
		String password = MD5Util.getMD5(MD5Util.getMD5(pwd + "sunjob")
				+ "sunjob");
		String usersReferrer = request.getParameter("phone");
		System.out.print(usersReferrer);
		String name = request.getParameter("username");
		System.out.println("昵称：" + name);
		String clientId = request.getParameter("clientId");
		service.save(mobile, password, name, clientId);
		return "true";
	}

	/*
	 * 作者：马日升 功能：得到所有用户数据 参数 ： page，size 返回：转发到用户页
	 */
	@RequestMapping(params = "p=userlisting")
	public String userlisting(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "5") int size) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		Map map = service.findall(page, size);
		request.setAttribute("map", map);
		return "/admin/userlisting/userlisting.jsp";
	}

	@RequestMapping(params = "p=userlisting_biji")
	public String userlisting_biji() {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		return "/admin/userlisting/userlisting_biji.jsp";
	}

	/*
	 * 作者：马日升 功能：根据id查用户 参数：id 返回：某用户的数据
	 */
	@RequestMapping(params = "p=userlisting_biji_json")
	@ResponseBody
	public String userlisting_biji_json() {
		String id = request.getParameter("id");
		Users users = service.findbyid(id);
		JsonConfig config = new JsonConfig();
		config.registerDefaultValueProcessor(Integer.class,new DefaultValueProcessor()
		{
			@Override
			public Object getDefaultValue(Class arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		JsonFilter.ignoredSet(config);
		String json = JSONObject.fromObject(users, config).toString();
		System.out.println(json);
		return json;
	}

	@RequestMapping(params = "p=userlisting_biji_tijiao")
	@ResponseBody
	public String userlisting_biji_tijiao() {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String touxiang = request.getParameter("touxiang");
		String jifen = request.getParameter("jifen");
		System.out.println(jifen);
		String dongjie = request.getParameter("dongjie");
		String yitixian = request.getParameter("yitixian");
		String bank = request.getParameter("bank");
		String zhanghao = request.getParameter("zhanghao");
		String kaihuren = request.getParameter("kaihuren");
		String tuijian = request.getParameter("tuijian");
		String shoucang = request.getParameter("shoucang");
		String time = request.getParameter("time");
		Users users = service.update(id, username, phone, pwd, touxiang, jifen,
				dongjie, yitixian, bank, zhanghao, kaihuren, tuijian, shoucang,
				time);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONObject.fromObject(users, config).toString()
				.replaceAll("  ", " ");
		System.out.println(json);
		return json;
	}
}
