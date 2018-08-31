package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;

public class IPUtil {

	public static void main(String[] args) {
		System.out.println(getCity("58.30.0.0"));
		System.err.println("123");
	}
	
	//http://ip.chinaz.com/?IP=61.187.98.4
	private static String getCityByChinz(String ip){
		// String ip = request.getParameter("ip");
		String url = "http://ip.chinaz.com/?IP=" + ip;
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		try {
			int ret = client.executeMethod(getMethod);
			if (ret == 200) {
				InputStream is = getMethod.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, "utf-8"));
				String line = br.readLine();
				while (line != null) {
					int index = line.indexOf("查询结果");
					if (index>-1)
					{
						int index2 = line.lastIndexOf("==>>");
						int index3 = line.lastIndexOf("</strong>");
						if (index2>-1 && index3>-1){
							return line.substring(index2+5,index3).trim();
						}
					}

					line = br.readLine();
				}
				br.close();
				is.close();
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}

		return null;
	}
	
	/**
	 * 获取客户端IP地址，此方法用在proxy环境中
	 * 
	 * @param req
	 * @return
	 */
	public static String getIp(HttpServletRequest req) {

		String ip_for = req.getHeader("x-forwarded-for");
		String ip_client = req.getHeader("http_client_ip");
		String un = "unknown";
		if (ip_for != null && !ip_for.equalsIgnoreCase(un)
				&& ip_for.trim().length() > 0) {
			return ip_for;
		} else if (ip_client != null && !ip_client.equalsIgnoreCase(un)
				&& ip_client.trim().length() > 0) {
			return ip_client;
		} else {
			return req.getRemoteAddr();
		}
	}

	

	public static String getCity(String ip) {
		// String ip = request.getParameter("ip");
		String url = "http://www.ip138.com/ips138.asp?ip=" + ip;
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		String cityName = null;
		try {
			int ret = client.executeMethod(getMethod);
			if (ret == 200) {
				InputStream is = getMethod.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, "gbk"));
				String line = br.readLine();
				while (line != null) {
					int index = line.indexOf("本站主数据");
					if (index > -1) {
						int end = line.indexOf("</li>", index);
						if (end > index) {
						    cityName = line.substring(index + 6, end);
							break;
						}
					}

					line = br.readLine();
				}
				br.close();
				is.close();
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
        if (cityName==null)
		  cityName = getCityByChinz(ip);
        
        //处理直辖市
        String cityString = cityName;
		String[] zhixiashi = new String[]{"北京市","天津市","上海市","重庆市"};
		for (int i = 0; i < zhixiashi.length; i++) {
			if (cityString.indexOf(zhixiashi[i])>-1)
				return zhixiashi[i];
		}
		
		//查找省市
		Pattern pattern= Pattern.compile("[省区]([^市]+市)");
		Matcher matcher = pattern.matcher(cityString);
		if (matcher.find())
			return matcher.group(1);
		
		return null;
		
		
	}

	public static boolean isIPAddr(String addr) {
		if (StringUtils.isEmpty(addr))
			return false;
		String[] ips = StringUtils.split(addr, '.');
		if (ips.length != 4)
			return false;
		try {
			int ipa = Integer.parseInt(ips[0]);
			int ipb = Integer.parseInt(ips[1]);
			int ipc = Integer.parseInt(ips[2]);
			int ipd = Integer.parseInt(ips[3]);
			return ipa >= 0 && ipa <= 255 && ipb >= 0 && ipb <= 255 && ipc >= 0
					&& ipc <= 255 && ipd >= 0 && ipd <= 255;
		} catch (Exception e) {
		}
		return false;
	}

	public static String getIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getHeader("Proxy-Client-IP");
		 }
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getHeader("WL-Proxy-Client-IP");
		 }
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getRemoteAddr();
		 }
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getHeader("http_client_ip");
		 }
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		 }
		 // 如果是多级代理，那么取第一个ip为客户ip
		 if (ip != null && ip.indexOf(",") != -1) {
		  ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		 }
		 return ip;
		

	}
	
	

}
