package com.action.back;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Admin;
import com.service.back.APPvesionService;
import com.util.FileUtil;
import com.util.StringUtil;

@Controller
@RequestMapping("/app.do")
public class APPvesionAction {
	@Autowired
	private APPvesionService pvesionService;
	/**
	 * 版本列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params="p=applisting")
	public String applisting(HttpServletRequest request,HttpServletResponse response)
	{
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		if(admin==null)
		{
			return "/admin/login.jsp";
		}
		int page =1;
		int size =10;
		String pageString=request.getParameter("page");
		if(StringUtil.isNotNull(pageString) && pageString.trim().length()>0)
			page=Integer.parseInt(pageString);
		String sizeString=request.getParameter("size");
		if(StringUtil.isNotNull(sizeString) && sizeString.trim().length()>0)
			size=Integer.parseInt(sizeString);
		Map appmap=pvesionService.applisting(size,page);
		request.setAttribute("appmap", appmap);
		return "/admin/app_upgrade/applisting.jsp";
	}
	
	/**
	 * 上传app更新包
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params="p=AppfileUpload")
	@ResponseBody
	public String AppfileUpload(HttpServletRequest request,HttpServletResponse response)
	{
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		if(admin==null)
		{
			return "/admin/login.jsp";
		}
		String appEdition=request.getParameter("appEdition"); //版本号
		String avtype=request.getParameter("app");	//app类型 0:android 1:ios
		String file=request.getParameter("file");	//路径
		if(StringUtil.isNotNull(avtype)){
			if("0".equals(avtype))
			{
				FileUtil.copy(request, "/tmp", file, "/appdownload/android");
			}else if("1".equals(avtype))
			{
				FileUtil.copy(request, "/tmp", file, "/appdownload/ios");
			}
		}else{
			return "上传失败";
		}
		pvesionService.AppfileUpload(appEdition,avtype,file);
		return "上传成功";
	}
	
	@RequestMapping(params="p=deleteapp")
	public String deleteapp(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		if(admin==null)
		{
			return "/admin/login.jsp";
		}
		int avid = Integer.parseInt(request.getParameter("avid"));
		boolean f = pvesionService.deleteapp(avid);
		if(f)
			response.getWriter().print(true);
		else
			response.getWriter().print(false);
		return null;
	}
}
