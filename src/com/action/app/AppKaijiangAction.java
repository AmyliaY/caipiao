package com.action.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.app.AppKaijiangService;

/**
* @author 全恒
*/
@Controller
@RequestMapping("/kaijiang.do")
public class AppKaijiangAction {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private AppKaijiangService kaijiangService;
	
	/**
	 * 进入开奖公告页面，查询出每种彩票的最新一条数据
	 */
	@RequestMapping(params="p=gotoKaijiang")
	@ResponseBody
	public String gotoKaijiang(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String json = kaijiangService.gotoKaijiang();
		return json;
	}
	
	/**
	 * 双色球开奖记录
	 * 分页查询，每次20条
	 */
	@RequestMapping(params="p=getShuangseqiuKjgg")
	@ResponseBody
	public String getShuangseqiuKjgg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		String json = kaijiangService.getShuangseqiuKjgg(10+"", 1+"");
		return json;
	}
	
	/**
	 * 福彩3D开奖记录
	 * 分页查询，每次20条
	 */
	@RequestMapping(params="p=getFucai3dKjgg")
	@ResponseBody
	public String getFucai3dKjgg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		String json = kaijiangService.getFucai3dKjgg(10+"", 1+"");
		return json;
	}
	
	/**
	 * 七乐彩开奖记录
	 * 分页查询，每次20条
	 */
	@RequestMapping(params="p=getQilecaiKjgg")
	@ResponseBody
	public String getQilecaiKjgg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		String json = kaijiangService.getQilecaiKjgg(10+"", 1+"");
		return json;
	}
	
	/**
	 * 大乐透开奖记录
	 * 分页查询，每次20条
	 */
	@RequestMapping(params="p=getDaletouKjgg")
	@ResponseBody
	public String getDaletouKjgg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		String json = kaijiangService.getDaletouKjgg(10+"", 1+"");
		return json;
	}
	
	/**
	 * 七星彩开奖记录
	 * 分页查询，每次20条
	 */
	@RequestMapping(params="p=getQixingcaiKjgg")
	@ResponseBody
	public String getQixingcaiKjgg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		String json = kaijiangService.getQixingcaiKjgg(10+"", 1+"");
		return json;
	}
	
	/**
	 * 足球胜负彩开奖记录
	 * 分页查询，每次20条
	 */
	@RequestMapping(params="p=getZuqiushengfuKjgg")
	@ResponseBody
	public String getZuqiushengfuKjgg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		String json = kaijiangService.getZuqiushengfuKjgg(10+"", 1+"");
		return json;
	}
	
	/**
	 * 排列三开奖记录
	 * 分页查询，每次20条
	 */
	@RequestMapping(params="p=getPailiesanKjgg")
	@ResponseBody
	public String getPailiesanKjgg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		String json = kaijiangService.getPailiesanKjgg(10+"", 1+"");
		return json;
	}
	
	/**
	 * 排列五开奖记录
	 * 分页查询，每次20条
	 */
	@RequestMapping(params="p=getPailiewuKjgg")
	@ResponseBody
	public String getPailiewuKjgg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		String json = kaijiangService.getPailiewuKjgg(10+"", 1+"");
		return json;
	}
	
	/**
	 * 11选5开奖记录
	 * 分页查询，每次20条
	 */
	@RequestMapping(params="p=getShiyixuanwuKjgg")
	@ResponseBody
	public String getShiyixuanwuKjgg(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String size = request.getParameter("size");
		String page = request.getParameter("page");
		String json = kaijiangService.getShiyixuanwuKjgg(10+"", 1+"");
		return json;
	}
}
