package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PropertiesManager {
	//查询properties
	public  JSONArray getProperties(String filename,String[] key) throws IOException {
		Properties properties = new Properties();
		URL fileAddress = PropertiesManager.class.getClassLoader().getResource(filename+".properties");
		FileInputStream fls = new FileInputStream(fileAddress.toString().replace("file:/", ""));
		properties.load(fls);
		fls.close();
		JSONObject jsons = new JSONObject();
		for (String string : key) {
			jsons.put(string, properties.getProperty(string));
		}
		JSONArray json = new JSONArray();
		json.add(jsons);
		return json;
	}
	//添加properties
	
	public  void setProperties(String filename,Map<String, String> map) throws IOException {
		Properties properties = new Properties();
		URL fileAddress = PropertiesManager.class.getClassLoader().getResource(filename+".properties");
		FileInputStream fls = new FileInputStream(fileAddress.toString().replace("file:/", ""));
		properties.load(fls);
		for (String key : map.keySet()) {
			
			properties.setProperty(key, map.get(key));
		}
		FileOutputStream fos = new FileOutputStream(fileAddress.toString().replace("file:/", ""));
		properties.store(fos, "buzhungan");
		fls.close();
		fos.close();
	}


}
