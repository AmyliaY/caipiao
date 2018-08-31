package com.util;

import java.util.Date;

public class DateChaUtil {
	
	/**
	 * 类型为long
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static String TimeCha(long beginTime ,long endTime){
		long nd = 1000 * 24 * 60 * 60;	//24小时一天
	    long nh = 1000 * 60 * 60;		//60分钟一小时
	    long nm = 1000 * 60;			//60秒一分钟
	    long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endTime - beginTime;
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    long sec = diff % nd % nh % nm / ns;

	    //补 0
	    String day1 = DateChaUtil.pad(day+"", 2);
	    String hour1 = DateChaUtil.pad(hour+"", 2);
	    String min1 = DateChaUtil.pad(min+"", 2);
	    String sec1 = DateChaUtil.pad(sec+"", 2);
	    
	    return day1 + "天" + hour1 + "小时" + min1 + "分钟"+ sec1 + "秒";
	}
	
	/**
	 * 类型为date
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static String TimeCha(Date beginDate ,Date endDate){
		long nd = 1000 * 24 * 60 * 60;	//24小时一天
	    long nh = 1000 * 60 * 60;		//60分钟一小时
	    long nm = 1000 * 60;			//60秒一分钟
	    long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endDate.getTime() - beginDate.getTime();
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    long sec = diff % nd % nh % nm / ns;
	    
	    //补 0
	    String day1 = DateChaUtil.pad(day+"", 2);
	    String hour1 = DateChaUtil.pad(hour+"", 2);
	    String min1 = DateChaUtil.pad(min+"", 2);
	    String sec1 = DateChaUtil.pad(sec+"", 2);
	    
	    return day1 + "天" + hour1 + "小时" + min1 + "分钟"+ sec1 + "秒";
	}
	
	/**
	 * 补 0 的方法
	 * @param num
	 * @param n
	 * @return
	 */
	public static String pad(String num ,int n){
		String num2 = num+"";
		int i = num2.length();
		if(i>n)
		{
			num = num2.substring(i-2, 2);
		}
		while(i++<n){
			num = "0"+num2;
		}
		return num;
	}
}
