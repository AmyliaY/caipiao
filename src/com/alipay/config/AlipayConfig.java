package com.alipay.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：1.0
 *日期：2016-06-06
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息  请勿修改↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	

	//合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088721312663050";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOfw6RzFDHolNEBgeQmxr6m7qvBr6lM3PQ5pdch/0xZmy3+bLSe0pHkNrFDQV/3WPqS6kDhjrrERjn+YgHbMf5QpdBamEINg1s+3CIhE/JDlrpzg2eIbLgEERIaC1c/0yDXMnGDrf57g2/oeNcwSCvFM0atoiQctNjWMmLRVCbDdAgMBAAECgYEAosimExcJBsENxxDuYitfClU4R7y1nOnr5C2ICMwNrm8+67RRIMjblkpOYfmXiAPRu3NkvO7ZMFUOGedCYh5seo32y3Dy5EtSMYOyD+2WXa+yAjeUo3MKEqL5XCu3ks7kkgBGgppuHKwlzY92QQwSYUUj844asJuXgy4rGhijugECQQD3vt7xo8800L0EJltEJ4J/t3VIXr4RljJizefWt652mQq9u9sv/gVE+ARwKyGeQGtrWkY8pwRmae1dypzl3149AkEA76s8bQl+atAxQU0Pxi3jjZ4A9fgKXsjGp6FTGzuXvTxo2t5Hs/o5k68ZKOOMGFxnVr1zzxQ4e+e9JGr53uRnIQJAB2H/wNGx3hAOYe5Gr/xBbk7oRtTT8zA3piweqY5lu5EJ+ed8O6zlOU3uy+ztHosq6FMTXsFXZznm4fGkxVDnvQJBAJZ9QAj7QBzTs0ncmH4JDGw8/T91SxWvHkXdn3BnH+VcDD75+a4B/atE9BhfoPUe+GhXt2McwEbVAUffwBv78OECQFRPvdMp9ruCg/64Yd85zpjDWQpNAVtKd6cjrklOl5AhAmH/jp60Tzm+jzWLvz/y9CevOHxxmtxJR/Fi/6+bhOk=";
	
	//支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDn8OkcxQx6JTRAYHkJsa+pu6rwa+pTNz0OaXXIf9MWZst/my0ntKR5DaxQ0Ff91j6kupA4Y66xEY5/mIB2zH+UKXQWphCDYNbPtwiIRPyQ5a6c4NniGy4BBESGgtXP9Mg1zJxg63+e4Nv6HjXMEgrxTNGraIkHLTY1jJi0VQmw3QIDAQAB";
	
	//PC支付MD5
	public static String MD5_KEY="kmyjwg3tgh4mspqb2nzoxhptzjm7uxd7";
	
	// 签名方式
	public static String sign_type = "RSA";     //app签名
	public static String pc_sign_type = "MD5";  //电脑端 签名
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path ="C://";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";
	
	
	public static String SELLER_ID = "xinxiangguoye888@163.com";
	
	public static String status = "1";
//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
	public static String getStatus() {
		return status;
	}

	public static void setStatus(String status) {
		AlipayConfig.status = status;
	}

	public static String getPartner() {
		return partner;
	}

	public static void setPartner(String partner) {
		AlipayConfig.partner = partner;
	}

	public static String getPrivate_key() {
		return private_key;
	}

	public static void setPrivate_key(String privateKey) {
		private_key = privateKey;
	}

	public static String getAlipay_public_key() {
		return alipay_public_key;
	}

	public static void setAlipay_public_key(String alipayPublicKey) {
		alipay_public_key = alipayPublicKey;
	}

	public static String getMD5_KEY() {
		return MD5_KEY;
	}

	public static void setMD5_KEY(String mD5KEY) {
		MD5_KEY = mD5KEY;
	}

	public static String getSELLER_ID() {
		return SELLER_ID;
	}

	public static void setSELLER_ID(String sELLERID) {
		SELLER_ID = sELLERID;
	}
	static{
		Properties prop=new Properties();
		InputStream is = AlipayConfig.class.getResourceAsStream("/AlipayConfig.properties");
		try {
			prop.load(is);
			partner=prop.getProperty("PARTNER").trim();
			private_key=prop.getProperty("PRIVATE_KEY").trim();
			alipay_public_key=prop.getProperty("ALIPAY_PUBLIC_KEY").trim();
			MD5_KEY=prop.getProperty("MD5_KEY").trim();
			SELLER_ID=prop.getProperty("SELLER_ID").trim();
			status=prop.getProperty("status").trim();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

