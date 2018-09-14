package com.action.back;

import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pojo.Admin;
import com.pojo.CaipiaoLeixing;
import com.pojo.Caipiaobiao;
import com.pojo.CaipiaobiaoDesc;
import com.pojo.Caipiaodian;
import com.service.back.CaiPiaoDianShenHe;
import com.util.JsonFilter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@RequestMapping("/caipiaodian.do")
public class CaiPiaoDianAction {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private CaiPiaoDianShenHe service;
	
	@RequestMapping(params="p=shenhe")
	public String shenhe(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="5") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		Map map= service.shenhelisting(page,size);
		request.setAttribute("caipiaodianshenhemap", map);
		return "/admin/caipiaodian/caipiaodianshenhe.jsp";
	}
	
	@RequestMapping(params="p=shenhetongyi")
	public String shenhetongyi()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		String zhuangtai = request.getParameter("zhuangtai");
		String page = request.getParameter("page");
		service.shenheupdate(zhuangtai,id);
		request.setAttribute("page", page);
		return "/caipiaodian.do?p=shenhe";
	}
	
	@RequestMapping(params="p=shenhejvjue")
	public String shenhejvjue()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		String zhuangtai = request.getParameter("zhuangtai");
		String page = request.getParameter("page");
		String liyou = request.getParameter("liyou");
		service.shenhejvjue(zhuangtai,id,liyou);
		request.setAttribute("page", page);
		return "/caipiaodian.do?p=shenhe";
	}
	
	@RequestMapping(params="p=shenhejvjuelisting")
	public String shenheupdatejvjue(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="5") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		Map map= service.shenhelistingjvjue(page,size);
		request.setAttribute("caipiaodianshenhemap", map);
		return "/admin/caipiaodian/caipiaodianshenhejvjue.jsp";
	}
	
	@RequestMapping(params="p=shenhejvjueliyou")
	public String shenhejvjueliyou()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		String zhuangtai = request.getParameter("zhuangtai");
		String page = request.getParameter("page");
		request.setAttribute("id", id);
		request.setAttribute("zhuangtai", zhuangtai);
		request.setAttribute("page", page);
		return "/admin/caipiaodian/jvjueliyou.jsp";
	}
	
	@RequestMapping(params="p=caipiaodianlisting")
	@ResponseBody
	public String caipiaodianlisting(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="5") int size)
	{
		String xuanze = request.getParameter("xuanze");
		System.out.println(xuanze);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		if("0".equals(xuanze))
		{
			Map map = service.findcaipiaodianlisting1(page,size);
			List list = (List) map.get("list");
			String json = JSONArray.fromObject(list,config).toString();
			System.out.println(json);
			return json;
		}
		else if("1".equals(xuanze))
		{
			System.out.println("来了");
			Map map = service.findcaipiaodianlisting2(page,size);
			List list = (List) map.get("list");
			String json = JSONArray.fromObject(list,config).toString();
			System.out.println(json);
			return json;
		}
		else
		{
			Map map = service.findcaipiaodianlisting(page,size);
			List<Caipiaodian> list = (List) map.get("list");
			String json = JSONArray.fromObject(list,config).toString();
			System.out.println(json);
			return json;
		}
	}
	
	@RequestMapping(params="p=dianlistingid")
	public String dianlistingid()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		return "/admin/caipiaodian/dianlistingxiugai.jsp";
	}
	
	@RequestMapping(params="p=dianlisting")
	@ResponseBody
	public String dianlisting(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="5") int size)
	{
		String id = request.getParameter("id");
		Caipiaodian caipiaodian = service.dianlisting(id);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONObject.fromObject(caipiaodian,config).toString().replaceAll("  ", " ");
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(params="p=arealisting")
	@ResponseBody
	public String arealisting()
	{
		List list = service.arealisting();
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONArray.fromObject(list, config).toString();
		return json;
	}
	
	@RequestMapping(params="p=citylisting")
	@ResponseBody
	public String citylisting()
	{
		String id = request.getParameter("id");
		List list = service.citylisting(id);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONArray.fromObject(list, config).toString();
		return json;
	}
	
	@RequestMapping(params="p=qulisting")
	@ResponseBody
	public String qulisting()
	{
		String id = request.getParameter("id");
		System.out.println(id);
		List list = service.qulisting(id);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONArray.fromObject(list, config).toString();
		return json;
	}
	
	@RequestMapping(params="p=dianlistingupdate")
	@ResponseBody
	public String dianlistingupdate()
	{
		String id = request.getParameter("id");
		String shoujihao = request.getParameter("shoujihao");
		String password = request.getParameter("password");
		String stores = request.getParameter("stores");
		String qu = request.getParameter("qu");
		String address = request.getParameter("address");
		String jingdu = request.getParameter("jingdu");
		String weidu = request.getParameter("weidu");
		String isfucai = request.getParameter("isfucai");
		String isticai = request.getParameter("isticai");
		String tixian = request.getParameter("tixian");
		String begintime = request.getParameter("begintime");
		String endtime  = request.getParameter("endtime");
		String time = request.getParameter("time");
		service.dianlistingupdate(id,shoujihao,password,stores,qu,address,jingdu,weidu,isfucai,isticai,tixian,begintime,endtime,time);
		return "修改成功";
	}
	
	@RequestMapping(params="p=caipiaolisting")
	public String caipiaolisting(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		Map map = service.caipiaolisting(page,size);
		request.setAttribute("caipiaomap", map);
		return "/admin/caipiao/caipiao.jsp";
	}
	
	@RequestMapping(params="p=caipiao_leixinglisting")
	public String caipiao_leixinglisting(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int size)
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		Map map = service.caipiao_leixinglisting(page,size);
		request.setAttribute("caipiaomap", map);
		return "/admin/caipiao/caipiao_leixing.jsp";
	}
	
	@RequestMapping(params="p=caipiao_leixing_add")
	@ResponseBody
	public String caipiao_leixing_add()
	{
		String caipiao_leixing = request.getParameter("caipiao_leixing");
		String status = request.getParameter("status");
		service.caipiao_leixing_add(caipiao_leixing,status);
		return "添加成功";
	}
	
	@RequestMapping(params="p=caipiao_leixinglistingid")
	public String caipiao_leixinglistingid()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		return "/admin/caipiao/caipiao_leixing_biji.jsp";
	}
	
	/*
	 * 传入 id
	 * 跟据id查一列数据
	 * 返回json
	 */
	@RequestMapping(params="p=caipaio_leixinglistingjson")
	@ResponseBody
	public String caipiao_leixinglistingjson()
	{
		String id = request.getParameter("id");
		CaipiaoLeixing caipiaoLeixing = service.caipiaoleixinglistingjson(id);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONObject.fromObject(caipiaoLeixing,config).toString();
		return json;
	}
	
	/*新增彩票
	 * @param name,type,price,begintime,endtime,status,kaijiangtime,jiangchi
	 * return 新增成功
	 */
	@RequestMapping(params="p=addcaipiaolisting")
	@ResponseBody
	public String addcaipiaolisting()
	{
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		String begintime = request.getParameter("endtime");
		String endtime = request.getParameter("endtime");
		String status = request.getParameter("status");
		String kaijiangtime = request.getParameter("kaijiangtime");
		String jiangchi = request.getParameter("jiangchi");
		service.addcaipiaolisting(name,type,price,begintime,endtime,status,kaijiangtime,jiangchi);
		return "新增成功";
	}
	
	/* 作者：马日升
	 * 编辑
	 * @param caipiao_leixing,status
	 * return 编辑成功
	 */
	@RequestMapping(params="p=caipiao_leixing_bianji")
	@ResponseBody
	public String caipiao_leixing_bianji()
	{
		String id = request.getParameter("id");
		String caipiao_leixing = request.getParameter("caipiao_leixing");
		String status = request.getParameter("status");
		service.caipiao_leixing_bianji(id,caipiao_leixing,status);
		return "编辑成功";
	}
	
	/*作者：马日升
	 * 查所有彩票一级类型
	 * @param null
	 * return caipiaoleixing
	 */
	@RequestMapping(params="p=addcaipiaolisting_leixing")
	@ResponseBody
	public String addcaipiaolisting_leixing()
	{
		List list = service.caipiaobiaofindall();
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONArray.fromObject(list,config).toString();
		return json;
	}
	
	/*作者：马日升
	 * 查所有彩票二级类型
	 * @param null
	 * return caipiaoleixing
	 */
	@RequestMapping(params="p=addcaipiaolisting_leixing2")
	@ResponseBody
	public String addcaipiaolisting_leixing2()
	{
		List list = service.caipiaobiaofindall2();
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONArray.fromObject(list,config).toString();
		return json;
	}
	
	/*作者：马日升
	 *@param id
	 *把id传入编辑页
	 * return 地址：彩票编辑页
	 */
	@RequestMapping(params="p=caipiao_biji")
	public String caipiao_biji()
	{
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/admin/login.jsp";
		}
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		return "/admin/caipiao/caipiao_biji.jsp";
	}
	
	/*作者：马日升
	 *@param id 
	 * return 地址：彩票编辑页
	 */
	@RequestMapping(params="p=caipiao_biji_data")
	@ResponseBody
	public String caipiao_biji_data()
	{
		String id = request.getParameter("id");
		CaipiaobiaoDesc caipiaobiaodesc = service.caiopiao_biji_data(id);
		JsonConfig config = new JsonConfig();
		JsonFilter.ignoredSet(config);
		String json = JSONObject.fromObject(caipiaobiaodesc,config).toString().replaceAll("  " , " ");
		return json;
	}
	
	@RequestMapping(params="p=caipiao_biji_insert")
	@ResponseBody
	public String caipiao_biji_insert()
	{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String type2 = request.getParameter("type2");
		System.out.println(type2);
		String price = request.getParameter("price");
		String begintime = request.getParameter("endtime");
		String endtime = request.getParameter("endtime");
		String status = request.getParameter("status");
		String kaijiangtime = request.getParameter("kaijiangtime");
		String jiangchi = request.getParameter("jiangchi");
		service.caipiao_biji_insert(id,name,type,type2,price,begintime,endtime,status,kaijiangtime,jiangchi);
		return "编辑成功";
	}
	
}
