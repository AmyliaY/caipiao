package com.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class MyCommonsMultipartResolver extends CommonsMultipartResolver{
	
	/**
	 * 要包含的url
	 */
	private List<String>  includeUrls = new ArrayList<String>();
	
	@Override
	public boolean isMultipart(HttpServletRequest request) {
		String requestURI = request.getServletPath();
		String queryString = request.getQueryString();
		if (queryString!=null && queryString.trim().length()>0)
			requestURI = requestURI +"?"+queryString;	
		//System.out.println("requestURI:"+requestURI);
		for (String url: includeUrls)
		{
			if (requestURI.startsWith(url))
			{
				return super.isMultipart(request);
			}
		}
		return false;
		
	}

	public void setIncludeUrls(List<String> includeUrls) {
		this.includeUrls = includeUrls;
	}

}
