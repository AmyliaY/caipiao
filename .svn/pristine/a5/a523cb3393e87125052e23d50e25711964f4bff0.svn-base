package com.util;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonUtil {

	/**
	 * POJO转json字符串
	 * 
	 * @param pojo
	 *            要转的对象
	 * @param excludeParam
	 *            要排除的属性
	 * @return
	 */
	public static String toJsonString(Object pojo, String... excludeParam) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludeParam);
		String json = JSONObject.fromObject(pojo, jsonConfig).toString();
		return json;
	}

	/**
	 * POJO集合或数组转json字符串
	 * 
	 * @param pojo
	 *            要转的对象
	 * @param excludeParam
	 *            要排除的属性
	 * @return
	 */
	public static String toJsonArrayString(Object list, String... excludeParam) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludeParam);
		String json = JSONArray.fromObject(list, jsonConfig).toString();
		return json;
	}

	/**
	 * json字符串转json对象
	 * 
	 * @param json
	 * @param pojo
	 */
	public static <T> T toBean(String json, Class pojo) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		Iterator<String> keys = jsonObject.keys();
		Object obj = null;
		try {
			obj = pojo.newInstance();

			while (keys.hasNext()) {
				String key = keys.next();
				Object value = jsonObject.get(key);
				Field field = pojo.getDeclaredField(key);
				field.setAccessible(true);
				field.set(obj, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) obj;
	}
	
	
	/**
	 * json字符串转List
	 * 
	 * @param json
	 * @param pojo
	 */
	public static List toList(String jsonArray, Class pojo) {
		JSONArray array = JSONArray.fromObject(jsonArray);
		List list =new ArrayList();
		for (int i=0;i<array.size();i++)
		{
			JSONObject jsonObject = array.getJSONObject(i);
			Iterator<String> keys = jsonObject.keys();
			Object obj = null;
			try {
				obj = pojo.newInstance();

				while (keys.hasNext()) {
					String key = keys.next();
					Object value = jsonObject.get(key);
					Field field = pojo.getDeclaredField(key);
					field.setAccessible(true);
					if (value.getClass()==field.getType())
					   field.set(obj, value);
					else
					{
						if (value!=null && value.toString().length()>0)
						{
						   if (field.getType()==Integer.class)
							   value = Integer.parseInt(value.toString());
						   else if (field.getType()==Double.class)
							   value = Double.parseDouble(value.toString());
						   else if (field.getType()==Float.class)
							   value = Float.parseFloat(value.toString());
						   else if (field.getType()==Long.class)
							   value  = Long.parseLong(value.toString());
						   else if (field.getType()==BigDecimal.class)
							   value = BigDecimal.valueOf(Double.parseDouble(value.toString()));
						  
						   field.set(obj, value);   
						}
					}
				}
				list.add(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
