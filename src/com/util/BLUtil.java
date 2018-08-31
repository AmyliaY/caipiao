package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class BLUtil {
	/**
	 * 根据地址作为参数传入百度地图解析，然后返回经纬度
	 * @param addr 地址
	 * @return 经纬度
	 */
	public static String[] getCoordinate(String addr){ 
		String lng=null;//经度
		String lat=null;
		String address = null;
		try {
			address = java.net.URLEncoder.encode(addr,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String key = "f247cdb592eb43ebac6ccd27f796e2d2";
		String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s", address, key); 
		URL myURL = null;
		URLConnection httpsConn = null;
		try {
			myURL = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader insr = null;
		BufferedReader br = null;
		try {
			httpsConn = myURL.openConnection();//不使用代理
			if(httpsConn!=null){
				insr = new InputStreamReader(httpsConn.getInputStream(),"utf-8");
				br = new BufferedReader(insr);
				String data = null;
				int count = 1;
				while ((data=br.readLine())!=null) {
					if(count==5){
						lng = (String) data.subSequence(data.indexOf(":")+1, data.indexOf(","));//经度
						count++;
					}else if(count==6){
						lat = data.substring(data.indexOf(":")+1);//纬度
						count++;
					}else{
						count++;
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(insr!=null){
				try {
					insr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return new String[]{lng,lat};
	}
	/**
	 * 根据经纬度算出两地的距离
	 * @param lng1  经度
	 * @param lat1  纬度
	 * @param lng2
	 * @param lat2
	 * @return   距离
	 */
	public static double distanceByLngLat(double lng1,double lat1,double lng2,double lat2){
		//纬度
		double radLat1 = lat1*Math.PI/180;
		double radLat2 = lat2*Math.PI/180;
		
		double a = radLat1-radLat2;//纬度差	
		double p;//公里
		double b = lng1*Math.PI/180-lng2*Math.PI/180;//经度差
		double s = 2*Math.asin(Math.sqrt(Math.pow(Math.sin(a/2), 2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2), 2)));
		s = s*6378137.0;//地球长半径
		s = Math.round(s*10000)/10000;
		if(s>1000)
		{
			p=(s/1000)+(s%1000)/1000;
		}
		else
		{
			p=s;
		}
		return p;
	}
	
	public static void main(String[] args) throws Exception {
		BLUtil util = new BLUtil();
		String addr = "湖南工业大学一食堂";
		String sheng = "湖南省";
		String city = "株洲市";
		String qu = "天元区";
		StringBuffer sb = new StringBuffer();
		
		sb.append(sheng).append(city).append(qu).append(addr);

		String dizhi = sb.toString();
		System.out.println(sb+"sdfjfhsdjkgasdlkjfkjlshgjkfdhlgsdfhjk");
		Object[] o = util.getCoordinate(dizhi);
		String jingdu = (String) o[0];
		String weidu = (String) o[1];
		System.out.println(jingdu);//经度
		System.out.println(weidu);//纬度
		double lng = Double.parseDouble(jingdu);
		double lat = Double.parseDouble(weidu);
		
		Object[] o1 = util.getCoordinate("湖南省株洲市荷塘区");
		double lng2 =Double.parseDouble((String) o1[0]);
		double lat2 = Double.parseDouble((String) o1[1]);
		System.out.println(lng2);
		System.out.println(lat2);
		
		System.out.println(distanceByLngLat(lng, lat, lng2,lat2));
		
		
		/*调用下面的路径根据经纬度获取地址，返回json格式
		http://api.map.baidu.com/geocoder/v2/?ak=pmCgmADsAsD9rEXkqWNcTzjd&location=30.548,104.0470&output=json&pois=1
		*/
	}
}
