package com.action.back;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Admin;
import com.pojo.ShuangseqiuKjgg;
import com.service.back.CaiPiaoService;
import com.util.StringUtil;

/*作者：马日升
 * 功能：完成对彩票的操作
 */

@Controller
@RequestMapping("/caipiao.do")
public class CaiPiaoAction {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private CaiPiaoService caipiaoservice;
	@RequestMapping(params="p=xuangseqiulisting")
	public String xuangseqiulisting()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		int page = 1;
		int size = 1;
		String pageString = request.getParameter("page");
		String sizeString = request.getParameter("size");
		String kjQishu = request.getParameter("kjQishu");
		String mindate = request.getParameter("mintime");
		Timestamp mintime = null;
		if (StringUtil.isNotNull(mindate) && mindate.trim().length() > 0)
			mintime = Timestamp.valueOf(mindate + " 00:00:00");
		String maxdate = request.getParameter("maxtime");
		Timestamp maxtime = null;
		if (StringUtil.isNotNull(maxdate) && maxdate.trim().length() > 0)
			maxtime = Timestamp.valueOf(maxdate + " 23:59:59");
		if (pageString != null && pageString.trim().length() > 0)
			page = Integer.parseInt(pageString);
		if (sizeString != null && sizeString.trim().length() > 0)
			size = Integer.parseInt(sizeString);
		Map kaijiangmap = caipiaoservice.getAllkaijiang(kjQishu, mintime,
				maxtime);
		request.setAttribute("kaijiangmap", kaijiangmap);
		//redirect
		return "/admin/caipiao/shuangseqiu.jsp";
	}
	
	@RequestMapping(params = "p=getMaxQishu")
	public String getMaxQishu(HttpServletRequest request,
			HttpServletResponse response) {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		List maxqishulist = caipiaoservice.getMaxQishu();
		request.setAttribute("maxqishulist", maxqishulist);
		return "/admin/caipiao/addqiuhao.jsp";
	}
	
	@RequestMapping(params = "p=addQiuhao")
	@ResponseBody
	public String addQiuhao(HttpServletRequest request){
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		System.out.println("laile2");
		
		String kjId = request.getParameter("id");
		String qishu = request.getParameter("Qishu");
		String oneRed = request.getParameter("oneRed");
		String twoRed = request.getParameter("twoRed");
		String threeRed = request.getParameter("threeRed");
		String fourRed = request.getParameter("fourRed");
		String fiveRed = request.getParameter("fiveRed");
		String sixRed = request.getParameter("sixRed");
		String blue = request.getParameter("Blue");
		String time = request.getParameter("commentdatemin");
		caipiaoservice.updateKaiJiang(blue,oneRed,twoRed,threeRed,fourRed,fiveRed,sixRed,qishu);
		return "success";
	}
	
	@RequestMapping(params="p=delete")
	@ResponseBody
	public String delete()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String kjId = request.getParameter("kjId");
		caipiaoservice.delete(kjId);
		return "success";
	}
	
	@RequestMapping(params = "p=getKaiJiangById")
	public String getKaiJiangById(HttpServletRequest request){
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String mykjid = request.getParameter("id");
		List list = caipiaoservice.getKaiJiangById(Integer.parseInt(mykjid));
		request.setAttribute("list", list);
		System.out.println("laile");
		return "/admin/caipiao/updatekaijiang.jsp";
	}
	
	@RequestMapping(params = "p=updatekaijiang")
	@ResponseBody
	public String updateKaiJiang(HttpServletRequest request){
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		System.out.println("laile2");
		
		String kjId = request.getParameter("id");
		String qishu = request.getParameter("Qishu");
		String oneRed = request.getParameter("oneRed");
		String twoRed = request.getParameter("twoRed");
		String threeRed = request.getParameter("threeRed");
		String fourRed = request.getParameter("fourRed");
		String fiveRed = request.getParameter("fiveRed");
		String sixRed = request.getParameter("sixRed");
		String blue = request.getParameter("Blue");
		String time = request.getParameter("commentdatemin");
		ShuangseqiuKjgg shuangseqiuqishu = new ShuangseqiuKjgg();
		Timestamp mytime = Timestamp.valueOf(time);
		shuangseqiuqishu.setId(new Integer(kjId));
		shuangseqiuqishu.setHongqiu1(oneRed);
		shuangseqiuqishu.setHongqiu2(twoRed);
		shuangseqiuqishu.setHongqiu3(threeRed);
		shuangseqiuqishu.setHongqiu4(fourRed);
		shuangseqiuqishu.setHongqiu5(fiveRed);
		shuangseqiuqishu.setHongqiu6(sixRed);
		shuangseqiuqishu.setLanqiu(blue);
		shuangseqiuqishu.setQihao(qishu);
		shuangseqiuqishu.setKaijiangTime(Timestamp.valueOf(time));
		caipiaoservice.updateKaiJiang1(shuangseqiuqishu);
		return "success";
	}
}
