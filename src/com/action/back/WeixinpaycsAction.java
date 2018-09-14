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

import com.action.weixin.WeixinConfig;

@Controller
@RequestMapping("/weixinpaycs.do")
public class WeixinpaycsAction {
	
	/**
	 * 微信参数
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(params="p=weixinpaycs")
	public String weixinpaycs(HttpServletRequest request,HttpServletResponse response)
	{
		WeixinConfig wx=new WeixinConfig();
		Map map=new HashMap();
		map.put("appid", wx.getAPPID());
		map.put("token", wx.getTOKEN());
		map.put("appsecret", wx.getAPPSECRET());
		map.put("mchid", wx.getMCH_ID());
		map.put("paykey", wx.getPAY_KEY());
		map.put("status", wx.getStatus());
		request.setAttribute("wxmap", map);
		return "/admin/pay_param/weixinpaycs.jsp";
	}
	
	/**
	 * 编辑参数
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="p=editwinxinpay")
	public String editwinxinpay(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String appid=request.getParameter("appid");
		String token=request.getParameter("token");
		String appsecret=request.getParameter("appsecret");
		String mchid=request.getParameter("mchid");
		String paykey=request.getParameter("paykey");
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/classes/WeixinConfig.properties");
		Properties prop=new Properties();
		InputStream is = new FileInputStream(path);
		prop.load(is);
		prop.setProperty("APPID", appid.trim());
		prop.setProperty("TOKEN", token.trim());
		prop.setProperty("APPSECRET", appsecret.trim());
		prop.setProperty("MCH_ID", mchid.trim());
		prop.setProperty("PAY_KEY", paykey.trim());
		WeixinConfig.APPID=appid.trim();
		WeixinConfig.TOKEN=token.trim();
		WeixinConfig.APPSECRET=appsecret.trim();
		WeixinConfig.MCH_ID=mchid.trim();
		WeixinConfig.PAY_KEY=paykey.trim();
		OutputStream os=new FileOutputStream(path);
		prop.store(os, null);
		os.close();
		is.close();
		return "/weixinpaycs.do?p=weixinpaycs";
	}
	
	/**
	 * 修改 微信支付  状态  0:禁用 1：启用
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
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/classes/WeixinConfig.properties");
		Properties prop=new Properties();
		InputStream is = new FileInputStream(path);
		prop.load(is);
		prop.setProperty("status",status.trim());
		WeixinConfig.setStatus(status.trim());
		OutputStream os=new FileOutputStream(path);
		prop.store(os, null);
		is.close();
		os.close();
		return "ok";
	}
}
