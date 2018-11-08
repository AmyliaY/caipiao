package com.action.app;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Caipiaodian;
import com.service.app.AppEmployeeManagerService;
import com.util.MD5Util;

/**
* @author 全恒
* 彩票店的员工管理
* 
*/
@Controller
@RequestMapping("/employeeManager.do")
public class AppEmployeeManagerAction {
	@Autowired
	private AppEmployeeManagerService employeeManagerService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * 查询员工列表
	 */
	@RequestMapping(params="p=findEmployeeList")
	@ResponseBody
	public String findEmployeeList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String json = employeeManagerService.findEmployeeList(caipiaodian);
		return json;
	}
	
	/**
	 * 新增员工
	 * 所需参数：手机号,密码
	 * json=yes或no或no2，为no则表示该员工的手机号与某一个彩票店的手机号重复，为no2则表示该员工的手机号与另一个员工的手机号重复,请重新设置手机号
	 */
	@RequestMapping(params="p=addEmployee")
	@ResponseBody
	public String addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Caipiaodian caipiaodian = (Caipiaodian)request.getSession().getAttribute("caipiaodian");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String pwd = request.getParameter("pwd");
		String pwd2 = MD5Util.getMD5(MD5Util.getMD5(pwd + "shuitukeji") + "shuitukeji");
		String json = employeeManagerService.addEmployee(caipiaodian, tel, pwd2,name);
		return json;//json=yes或no，为no则表示该员工的手机号与某一个彩票店的手机号重复,为no2则表示该员工的手机号与另一个员工的手机号重复,
	}
	
	/**
	 * 修改员工状态：1在职，0离职
	 */
	@RequestMapping(params="p=changeStatus")
	@ResponseBody
	public String changeStatus(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		String json = employeeManagerService.changeStatus(empId);
		return json;//json=yes
	}
	
	/**
	 * 编辑员工
	 */
	@RequestMapping(params="p=editEmployee")
	@ResponseBody
	public String editEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		String tel = request.getParameter("tel");
		String pwd = request.getParameter("pwd");
		String pwd2 = MD5Util.getMD5(MD5Util.getMD5(pwd + "shuitukeji") + "shuitukeji");
		String json = employeeManagerService.editEmployee(empId, tel, pwd2);
		return json;//json=yes
	}
	
}
