package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateJsonValueProcessor implements JsonValueProcessor {
	private String format = "yyyy-MM-dd HH:mm:ss";

	public DateJsonValueProcessor() {
		super();
	}

	public DateJsonValueProcessor(String format) {
		super();
		this.format = format;
	}

	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		String[] obj = {};
		if (value instanceof Date[]) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			Date[] dates = (Date[]) value;
			obj = new String[dates.length];
			for (int i = 0; i < dates.length; i++) {
				obj[i] = sf.format(dates[i]);
			}
		}

		if (value instanceof float[]) {

			//String[] obj = {};

			float[] nums = (float[]) value;

			for (int i = 0; i < nums.length; i++) {
				obj[i] = roundHalfUp(nums[i], 3);
			}

			return obj;
		}
		
		if (value instanceof double[]) {

			//String[] obj = {};

			double[] nums = (double[]) value;

			for (int i = 0; i < nums.length; i++) {
				obj[i] = roundHalfUp(nums[i], 3);
			}

			return obj;
		}
		
		
		if (value instanceof Float[]) {

			//String[] obj = {};

			Float[] nums = (Float[]) value;

			for (int i = 0; i < nums.length; i++) {
				obj[i] = roundHalfUp(nums[i], 3);
			}

			return obj;
		}
		
		if (value instanceof Double[]) {

			//String[] obj = {};

			Double[] nums = (Double[]) value;

			for (int i = 0; i < nums.length; i++) {
				obj[i] = roundHalfUp(nums[i], 3);
			}

			return obj;
		}
		return obj;
	}

	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		if (value instanceof java.util.Date) {
			String str = new SimpleDateFormat(format).format((Date) value);
			return str;
		}

		if (value instanceof Float) {
			return roundHalfUp((Float) value, 3);
		}
		
		if (value instanceof Double) {
			return roundHalfUp((Double) value, 3);
		}
		
		if (value!=null && value.getClass()==float.class) {
			return roundHalfUp((Float) value, 3);
		}
		
		if (value!=null && value.getClass()== double.class) {
			return roundHalfUp((Double) value, 3);
		}
		return value;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * 四舍五入。
	 * 
	 * @param number
	 *            数值
	 * @return 舍入后的数值
	 * @see java.text.RoundingMode.HALF_UP
	 */
	public String roundHalfUp(double number, int frac) {
		return String.format("%.2f", number);
	}
}
