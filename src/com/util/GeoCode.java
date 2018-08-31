package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/***
 * 
 * 根据纬度 经度值获取用户的地理位置
 * */
public class GeoCode {
	public static void main(String[] args) {
		String addr = geocodeAddr("27.79635", "113.14788");//("27.798841", "113.161693");// 纬度 经度
		System.out.println("结果 "+addr);
	}

	/**
	 * 根据经纬度反向解析地址，有时需要多尝试几次
	 * 注意:(摘自：http://code.google.com/intl/zh-CN/apis/maps/faq.html
	 * 提交的地址解析请求次数是否有限制？) 如果在 24 小时时段内收到来自一个 IP 地址超过 15,000 个地址解析请求， 或从一个 IP
	 * 地址提交的地址解析请求速率过快，Google 地图 API 编码器将用 620 状态代码开始响应。 如果地址解析器的使用仍然过多，则从该 IP
	 * 地址对 Google 地图 API 地址解析器的访问可能被永久阻止。
	 * 
	 * @param latitude
	 *            纬度
	 * @param longitude
	 *            经度
	 * @return
	 */
	public static String geocodeAddr(String latitude, String longitude) {
		String addr = "";

		// 也可以是http://maps.google.cn/maps/geo?output=csv&key=abcdef&q=%s,%s，不过解析出来的是英文地址
		// 密钥可以随便写一个key=abc
		// output=csv,也可以是xml或json，不过使用csv返回的数据最简洁方便解析
		String url = String.format(
				//"http://maps.google.cn/maps/geo?output=csv&key=eVhIgeO5oppQ7KltSrayiojq&q=%s,%s",
				//"http://api.map.baidu.com/geocoder/v2/?ak=eVhIgeO5oppQ7KltSrayiojq&location=%s,%s&output=json&pois=1",
				"http://api.map.baidu.com/geocoder/v2/?ak=eVhIgeO5oppQ7KltSrayiojq&callback=renderReverse&location=%s,%s&output=json&pois=1",
				latitude, longitude);
		URL myURL = null;
		URLConnection httpsConn = null;
		try {
			myURL = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			httpsConn = (URLConnection) myURL.openConnection();
			if (httpsConn != null) {
				InputStreamReader insr = new InputStreamReader(
						httpsConn.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(insr);
				String data = null;
				if ((data = br.readLine()) != null) {
					String[] retList = data.split(",");
					if (retList.length > 2 && ("0".equals(retList[0]))) {
						addr = retList[2];
						addr = addr.replace("/", "");
					} else {
						int n = retList[3].indexOf(":");
						addr = retList[3].substring(n+2, retList[3].length()-1);
					}
				}
				insr.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return addr;
	}
}
