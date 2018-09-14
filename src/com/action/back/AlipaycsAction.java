package com.action.back;

import java.io.FileInputStream;
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

import com.alipay.config.AlipayConfig;

@Controller
@RequestMapping("/alipaycs.do")
public class AlipaycsAction {
	
	/**
	 * 支付宝参数
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params="p=alipaycs")
	public String alipaycs(HttpServletRequest request,HttpServletResponse response)
	{
		AlipayConfig alipay=new AlipayConfig();
		Map map=new HashMap();
		map.put("partner", alipay.getPartner());
		map.put("private_key", alipay.getPrivate_key());
		map.put("alipay_public_key", alipay.getAlipay_public_key());
		map.put("md5_key", alipay.getMD5_KEY());
		map.put("seller_id", alipay.getSELLER_ID());
		map.put("status", alipay.getStatus());
		request.setAttribute("alipay", map);
		return "/admin/pay_param/alipaycs.jsp";
	}
	
	/**
	 * 编辑参数
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="p=editalipay")
	public String editalipay(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String partner=request.getParameter("partner");
		String seller_id=request.getParameter("seller_id");
		String private_key=request.getParameter("private_key");
		String alipay_public_key=request.getParameter("alipay_public_key");
		String md5_key=request.getParameter("md5_key");
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/classes/AlipayConfig.properties");
		Properties prop=new Properties();
		InputStream is = new FileInputStream(path);
		prop.load(is);
		prop.setProperty("PARTNER", partner.trim());
		prop.setProperty("PRIVATE_KEY", private_key.trim());
		prop.setProperty("ALIPAY_PUBLIC_KEY",  alipay_public_key.trim());
		prop.setProperty("MD5_KEY",md5_key.trim());
		prop.setProperty("SELLER_ID", seller_id.trim());
		//也要写进 alipayconfig里面
		AlipayConfig.setPartner(partner.trim());
		AlipayConfig.setPrivate_key(private_key.trim());
		AlipayConfig.setAlipay_public_key(alipay_public_key.trim());
		AlipayConfig.setMD5_KEY(md5_key.trim());
		AlipayConfig.setSELLER_ID(seller_id.trim());
		OutputStream os=new FileOutputStream(path);
		prop.store(os, null);
		os.close();
		is.close();
		return null;
	}
	
	/**
	 * 修改 支付宝支付 状态  0 : 禁用 1：启用
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(params="p=editStatus")
	public String editStatus(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		int ss=Integer.parseInt(request.getParameter("status"));
		int s=1-ss;
		String status=String.valueOf(s);
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/classes/AlipayConfig.properties");
		Properties prop=new Properties();
		InputStream is = new FileInputStream(path);
		prop.load(is);
		prop.setProperty("status", status.trim());
		AlipayConfig.setStatus(status.trim());
		OutputStream os = new FileOutputStream(path);
		prop.store(os, null);
		is.close();
		os.close();
		return "ok";
	}
}
