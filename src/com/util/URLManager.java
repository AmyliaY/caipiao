package com.util;

import javax.servlet.http.HttpServletRequest;

public class URLManager {
	
	
	public  static  String getServerURL(HttpServletRequest request)
	{
		StringBuffer sb =new StringBuffer("http://");
		sb.append(request.getServerName());
		
		
		{
		if(request.getServerPort()!=80)
			sb.append(":").append(request.getServerPort());
		sb.append(request.getContextPath());
		//System.out.println(sb);
		return sb.toString();
		}
		
	}

}
