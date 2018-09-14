package com.action.back;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Admin;

@Controller
@RequestMapping("/jccs.do")
public class JCCSAction {
	/**
	 * 基础参数
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params="p=jccs")
	public String jccs(HttpServletRequest request,HttpServletResponse response)
	{
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		if(admin==null)
		{
			return "/admin/login.jsp";
		}
		int type= Integer.parseInt(request.getParameter("type"));
		JccsVO jccs=new JccsVO();
		String price=null;
		String jifen=null;
		if(type==1){
			price=jccs.getPrice();
			jifen=jccs.getJifen();
		}
		if(type==2)
		{
			price=jccs.getXxprice();
			jifen=jccs.getXxjifen();
		}
		if(type==3)
		{
			price=jccs.getDkprice();
			jifen=jccs.getDkjifen();
		}
		Map map=new HashMap();
		map.put("price", price);
		map.put("jifen", jifen);
		map.put("type", type);
		request.setAttribute("map", map);
		return "/admin/jccs/jccs.jsp";
	}
	
	/**
	 * 编辑参数
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(params="p=editjccs")
	public String editjccs(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		Admin admin=(Admin) request.getSession().getAttribute("admin");
		if(admin==null)
		{
			return "/admin/login.jsp";
		}
		int type=Integer.parseInt(request.getParameter("type"));
		String price=request.getParameter("price");
		String jifen=request.getParameter("jifen");
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/classes/jccs.properties");	//路径
		Properties pro=new Properties();
		InputStream is=JccsVO.class.getResourceAsStream("/jccs.properties");	//读
		pro.load(is);
		if(type==1){
			pro.setProperty("price", price.trim());
			pro.setProperty("jifen", jifen.trim());
			JccsVO.price=price.trim();
			JccsVO.jifen=jifen.trim();
		}
		if(type==2)
		{
			pro.setProperty("xxprice", price.trim());
			pro.setProperty("xxjifen", jifen.trim());
			JccsVO.xxprice=price.trim();
			JccsVO.xxjifen=jifen.trim();
		}
		if(type==3)
		{
			pro.setProperty("dkprice", price.trim());
			pro.setProperty("dkjifen", jifen.trim());
			JccsVO.dkprice=price.trim();
			JccsVO.dkjifen=jifen.trim();
		}
		OutputStream out=new FileOutputStream(path);	//写
		pro.store(out, null);
		out.close();
		is.close();
		return null;
	}
}
