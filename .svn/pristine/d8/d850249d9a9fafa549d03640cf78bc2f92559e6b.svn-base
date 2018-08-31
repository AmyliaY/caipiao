package com.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * 
 * 自定义JSTL标签类
 *  处理：1.long类型时间转换字符串
 * 
 * @author HD
 *
 */
public class JSTLDateUtil extends TagSupport{

	

	private PageContext pageContext;
	
	private String value;
	private String partten;
	
	//设置PageContext对象
	public void setPageContext(PageContext pageContext) {
		
		//System.out.println("设置PageContext对象！");  
		this.pageContext = pageContext;
	}
	
	
	public void setValue(String value)
	{
		this.value = value;
	}
	public void setPartten(String partten)
	{
		this.partten = partten;
	}
	
	
	
	
	/**
	 * 标签开始处理..调用的方法
	 * 
	 */
	@Override
	public int doStartTag() throws JspException {
		String vv = String.valueOf(value);
		Long time = Long.valueOf(vv);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		if(partten == null || partten.trim().length() == 0)
			partten = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(partten);
		String str = simpleDateFormat.format(calendar.getTime());
		
		try {
			pageContext.getOut().write(str);
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
		long a = 123456789123l;
		long time = Long.valueOf(a);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(simpleDateFormat.format(calendar.getTime()));
	}
	
	
	
	
	
	
}
