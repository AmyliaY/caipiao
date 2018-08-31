package com.util;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.shcm.bean.BalanceResultBean;
import com.shcm.bean.SendResultBean;
import com.shcm.send.OpenApi;

public class SmsUtil {
	public static void main(String[] args) {

		boolean f = send("15873305757", "刘总，测试一下。");
		System.out.println(f);
		int count = getMessageCount();
		System.out.println(count);
	}

	public static String createCode(int n) {
		String str = "0123456789";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(10); // [0-9] 间随机数
			char ch = str.charAt(index);
			sb.append(ch + "");
		}
		return sb.toString();
	}

	private static String url = "http://sms.253.com/msg/send";

	private static String account = "N2271140"; // 发送短信的账号(非登录账号) (示例:N987654)
	private static String pswd = "PsGWRbXt1q5446";// 发送短信的密码(非登录密码)

	// 可用条数/
	public static int getMessageCount() {
		String url = "http://sms.253.com/msg/balance";// 应用地址(无特殊情况时无需修改)
		try {
			String returnString = HttpSender.query(url,account, pswd);
			
			return Integer.parseInt(returnString.split(",")[1].replaceAll("\\s", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean send(String mobile, String content) {

		try {
			String returnString2 = HttpSender.SendPost(url, account, pswd, content
					, mobile, "0", null);
			System.out.println(returnString2);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean send(final String[] tel, final String content) {
		
		return true;
	}

	public static boolean send(List<String> tel, String content) {
		return send((String[]) tel.toArray(), content);
	}

}
