package com.util;

import javax.servlet.http.HttpServletRequest;


public class RequestUtil {

	public static void main(String[] args) {
		 //String name = get(request, "username","");
	}
	
   public static String  get(HttpServletRequest request, String key, String defaul)
   {
	  String value = request.getParameter(key);
	  if (value==null || value.trim().length()<1)
		  return defaul;
	  else
		  return value;
   }
}
