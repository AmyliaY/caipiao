package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static void main(String[] args) throws ParseException {
		Date from = java.sql.Timestamp.valueOf("2014-12-04 00:59:00");
	     Date to   = new Date();
		System.out.println(dateDiff(from, to));
		
		
		
	}
	
	//�ַ�ת����
	public static Date string2Date(String strDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = null;
		try {
			d = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	//}������֮��,�������
	public static int dateDiff(Date from, Date to)
			 {
		int days = 0;
		
		Calendar c = Calendar.getInstance();
		c.setTime(from);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);


		days = (int)( Math.abs((to.getTime() - c.getTimeInMillis())
				/ (1.0*24 * 60 * 60 * 1000)));
		return days;
	}
	
	//}������֮��,�������
	public static int monthDiff(Date from, Date to)
			 {
		int days = 0;
		Calendar c = Calendar.getInstance();
		c.setTime(from);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		days = (int)( Math.abs((to.getTime() - c.getTimeInMillis())
				/ (1.0*24 * 60 * 60 * 1000*30))) ;
		return days;
	}
	
	//�ж�}�������Ƿ�l�� 2014-11-1  2014-11-01
	public static boolean   checkdate(Date date1,Date date2)
	{
	  Calendar c=Calendar.getInstance();
	  c.setTime(date1);
	  c.add(Calendar.DAY_OF_MONTH, 1);
	int year=  c.get(Calendar.YEAR);
	int month=  c.get(Calendar.MONTH);
	int day=c.get(Calendar.DAY_OF_MONTH);
	
	 Calendar c2=Calendar.getInstance();
	  c2.setTime(date2);
	 
	  int year2=  c2.get(Calendar.YEAR);
		int month2=  c2.get(Calendar.MONTH);
		int day2=c2.get(Calendar.DAY_OF_MONTH);
		if(year==year2&&month==month2&&day==day2)
		{
			return true;
		}
		
		
		return false;
	}
	
	public static boolean isTOday(Date date)
	{
		
		  Calendar c=Calendar.getInstance();
		  c.setTime(date);
		
		int year=  c.get(Calendar.YEAR);
		int month=  c.get(Calendar.MONTH);
		int day=c.get(Calendar.DAY_OF_MONTH);
		
		 Calendar c2=Calendar.getInstance();
		  c2.setTime(new Date());
		 
		  int year2=  c2.get(Calendar.YEAR);
			int month2=  c2.get(Calendar.MONTH);
			int day2=c2.get(Calendar.DAY_OF_MONTH);
			if(year==year2&&month==month2&&day==day2)
			{
				return true;
			}
			
			
		return false;
	}
	
	
	
}
