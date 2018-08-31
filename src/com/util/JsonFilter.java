package com.util;

import java.sql.Timestamp;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class JsonFilter {
	
	/**
	 * 解除死循环   : 项目中请修改com.pojo包的路径
	 * @param jsonConfig
	 */
	public static void ignoredSet(final JsonConfig jsonConfig)
	{
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonConfigDateUtil("yyyy-MM-dd HH:mm:ss"));
		jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonConfigDateUtil("yyyy-MM-dd  HH:mm:ss"));
		
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {

			public boolean apply(Object obj, String name, Object value) {
				String packageName = obj.getClass().getPackage().getName();
				if (value instanceof java.util.Set) 
				{
					return true;
				}
				
				if (packageName.equals("com.pojo")==false && packageName.equals("net.sf.json")==false)
				{
					return true;
				}
				return false;
			}
			
		});
	}
	
	public static void setFilter(JsonConfig config, final String[] fields, final  boolean excludeSet)
	{
		config.setJsonPropertyFilter(new PropertyFilter() {
			

			public boolean apply(Object obj, String name, Object value) {
				
				if (excludeSet)
				{
					
					try {
						//net.sf.json
						String packageName = obj.getClass().getPackage().getName();
						if (value instanceof java.util.Set || packageName.equals("com.pojo")==false && packageName.equals("net.sf.json")==false)
						{
							System.out.println("name:"+name);
							System.out.println("package:"+obj.getClass().getPackage().getName());
							return true;
						}
					} catch (Exception e) {
                          e.printStackTrace();
					}
				}
				
				if (fields!=null)
					for (String f: fields)
					{
						
						if (name.equals(f))
						{
							
							System.out.println("来了");
							return true;
						}
					}
				return false;
			}
		});
	}
    
}
