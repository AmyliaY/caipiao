package com.util;

public class StringUtil {

	public static boolean isNull(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	/**
	 * 截取一键加群的href部分
	 * 
	 * @param str
	 * @return
	 * 
	 */
	public static String getLianjie(String str) {
		if (isNotNull(str)) {

			if (str.contains("href")) {
				int start = str.indexOf("href=");
				int end = str.indexOf("><img");
				String sString = str.substring(start, end);
				String[] newString = sString.split("\"");
				str = newString[1];
			}
		}
		return str;
	}
}
