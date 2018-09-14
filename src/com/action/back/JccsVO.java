package com.action.back;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 基础参数
 * @author ldz
 */
public class JccsVO {
	
	public static String price=null;	//会员购物金额
	public static String jifen=null;	//会员购物赠送积分
	public static String xxprice=null;	//下线购物金额
	public static String xxjifen=null;	//下线购物赠送多少积分
	public static String dkprice=null;	//每积分抵扣多少金额
	public static String dkjifen=null;	//抵扣积分
	public static String getXxprice() {
		return xxprice;
	}
	public static void setXxprice(String xxprice) {
		JccsVO.xxprice = xxprice;
	}
	public static String getXxjifen() {
		return xxjifen;
	}
	public static void setXxjifen(String xxjifen) {
		JccsVO.xxjifen = xxjifen;
	}
	public static String getDkprice() {
		return dkprice;
	}
	public static void setDkprice(String dkprice) {
		JccsVO.dkprice = dkprice;
	}
	public static String getDkjifen() {
		return dkjifen;
	}
	public static void setDkjifen(String dkjifen) {
		JccsVO.dkjifen = dkjifen;
	}
	public static String getPrice() {
		return price;
	}
	public static String getJifen() {
		return jifen;
	}
	public static void setPrice(String price) {
		JccsVO.price = price;
	}
	public static void setJifen(String jifen) {
		JccsVO.jifen = jifen;
	}
	static{
		Properties properties=new Properties();
		InputStream is=JccsVO.class.getResourceAsStream("/jccs.properties");
		try {
			properties.load(is);
			price=properties.getProperty("price").trim();
			jifen=properties.getProperty("jifen").trim();
			xxprice=properties.getProperty("xxprice").trim();
			xxjifen=properties.getProperty("xxjifen").trim();
			dkprice=properties.getProperty("dkprice").trim();
			dkjifen=properties.getProperty("dkjifen").trim();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
