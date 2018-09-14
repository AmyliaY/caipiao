package com.action.weixin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 微信参数
 * 
 * @author lgh
 * 
 */
public class WeixinConfig {
    
	public static String TOKEN = null;//"a1314520";
	public  static  String APPID = null;//"wx225617f3db0beec0";
	public  static  String APPSECRET = null;//"189b9553df89662f10d0568d5019396f";
	public  static  String MCH_ID = null; //商户号
	public  static  String PAY_KEY = null;
	public  static  String zhanghao = null;
	public  static  String url = null;
	public  static  String weixinurl = null;
	public  static  String status= null;
	
	public static String getStatus() {
		return status;
	}

	public static void setStatus(String status) {
		WeixinConfig.status = status;
	}

	public static String getTOKEN() {
		return TOKEN;
	}

	public static void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}

	public static String getAPPID() {
		return APPID;
	}

	public static void setAPPID(String aPPID) {
		APPID = aPPID;
	}

	public static String getAPPSECRET() {
		return APPSECRET;
	}

	public static void setAPPSECRET(String aPPSECRET) {
		APPSECRET = aPPSECRET;
	}

	public static String getMCH_ID() {
		return MCH_ID;
	}

	public static void setMCH_ID(String mCHID) {
		MCH_ID = mCHID;
	}

	public static String getPAY_KEY() {
		return PAY_KEY;
	}

	public static void setPAY_KEY(String pAYKEY) {
		PAY_KEY = pAYKEY;
	}

	static{
        String result=null;  
		Properties prop = new Properties();
		InputStream fis = WeixinConfig.class.getResourceAsStream("/WeixinConfig.properties");
        try {
			 prop.load(fis);
			 TOKEN = prop.getProperty("TOKEN").trim();
		     APPID = prop.getProperty("APPID").trim();
		     APPSECRET = prop.getProperty("APPSECRET").trim();
		     MCH_ID = prop.getProperty("MCH_ID").trim();
		     PAY_KEY = prop.getProperty("PAY_KEY").trim();
		     zhanghao = prop.getProperty("zhanghao");
		     url = prop.getProperty("url");	
		     weixinurl = prop.getProperty("weixinurl");	
		     status = prop.getProperty("status");
			 fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

