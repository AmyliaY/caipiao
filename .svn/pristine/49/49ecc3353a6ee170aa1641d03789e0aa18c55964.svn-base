package com.listener;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import weixin.popular.api.TicketAPI;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.Ticket;
import weixin.popular.bean.Token;

import com.action.weixin.WeixinConfig;

public class WeixinGetAccessTokenListen implements ServletContextListener{

	public static String access_token = null;
	public static String jsTicket  = null;
	
	public static String  SERVER_REAL_PATH=null; //真实路径
	public static ApplicationContext applicationContext;
	public static ServletContext  	application = null;
	
	/**
	 * tomcat服务关闭
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("tomcat关闭了");
	}

	/**
	 * tomcat服务开启
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("tomcat开启了");
		application = sce.getServletContext();
		SERVER_REAL_PATH =  sce.getServletContext().getRealPath("/");
		
		
		
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		new Timer().schedule(new TimerTask(){
			@Override
			public void run() {
				String appid = WeixinConfig.APPID;
				String secret = WeixinConfig.APPSECRET;
				Token token = new TokenAPI().token(appid, secret);
				access_token = token.getAccess_token();
		        //System.out.println("监听器中定时取access_token --------------"+access_token);
				Ticket ticket = new TicketAPI().getTicket(access_token);
				
				jsTicket = ticket.getTicket(); //jssdk中要用到
				
			}}, 0, 600*1000);
		
	}

}
