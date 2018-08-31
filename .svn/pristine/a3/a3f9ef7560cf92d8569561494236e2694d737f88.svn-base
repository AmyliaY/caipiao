package com.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;



/**
 * 
 * 自定义JSTL标签类
 *  处理：1.long类型时间转换当前时间差
 * 
 * @author HD
 *
 */
public class JSTLLongDateDiffUtil extends TagSupport{

	private PageContext pageContext;
	
	private String value;
	
	public void setValue(String value)
	{
		this.value = value;
	}

	//设置PageContext对象
	public void setPageContext(PageContext pageContext) {
		
		this.pageContext = pageContext;
	}
	
	
	/**
	 * 标签开始处理..调用的方法
	 * 
	 */
	@Override
	public int doStartTag() throws JspException {
		
		Long time = Long.valueOf(value);
		Date timeDate = new Date(time);
		Calendar timeDatCalendar = Calendar.getInstance();
		timeDatCalendar.setTime(timeDate);
		
		Date currentDate = new Date();
		Calendar currentDatCalendar = Calendar.getInstance();
		currentDatCalendar.setTime(currentDate);
		
		//时间差
		Long currentTime = currentDate.getTime();
		long timeDiff = currentTime - time;
		
		//今天结束的时间查
		Date d = java.sql.Date.valueOf("2011-01-01");
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.YEAR, currentDatCalendar.get(Calendar.YEAR));
		c.set(Calendar.MONTH, currentDatCalendar.get(Calendar.MONTH));
		c.set(Calendar.DAY_OF_MONTH, currentDatCalendar.get(Calendar.DAY_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		
		try {
			if(currentDate.getTime() - time < 180000 )
			{
				pageContext.getOut().write("刚刚");
			}else if(currentDate.getTime() - time < 3600000)
			{
				timeDiff = timeDiff%60000 == 0 ? timeDiff/60000 : timeDiff/60000;
				pageContext.getOut().write(timeDiff+"分钟前");
			}else if(timeDatCalendar.get(Calendar.DAY_OF_YEAR) == currentDatCalendar.get(Calendar.DAY_OF_YEAR))
			{
				SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
				pageContext.getOut().write("今天 " + sdf1.format(timeDate));
			}else if(time > c.getTimeInMillis())
			{
				SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
				pageContext.getOut().write("昨天 " + sdf2.format(timeDate));
			}else if(timeDatCalendar.get(Calendar.YEAR) == currentDatCalendar.get(Calendar.YEAR))
			{
				SimpleDateFormat sdf3 = new SimpleDateFormat("MM月dd日 HH:mm");
				pageContext.getOut().write(sdf3.format(timeDate));
			}else 
			{
				SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				pageContext.getOut().write(sdf3.format(timeDate));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return super.doStartTag();
	}
	
	
	
	/**
	 * 
	 * 标签处理结束的调用的方法
	 */
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}
	
	
	/**
	 * 
	 * 释放资源
	 */
	@Override
	public void release() {
		// TODO Auto-generated method stub
		super.release();
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 测试主方法
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "2014-01-29 15:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = sdf.parse(str);
			System.out.println(d.getTime());
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			System.out.println(c.get(Calendar.DATE));
			c.add(Calendar.DATE, 1);
			System.out.println(c.get(Calendar.DAY_OF_YEAR));
			System.out.println(c.getTimeInMillis());
			System.out.println(c.getTime().getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
