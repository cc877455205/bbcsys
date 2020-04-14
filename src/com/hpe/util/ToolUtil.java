package com.hpe.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公共类 工具类
 * 
 * @author 30601
 *
 */
public class ToolUtil {
	private ToolUtil() {
	}

	public static final String LOGINUSER = "LOGINUSER";

	/**
	 * yyyy-MM-dd hh:ss:mm 格式的字符串，转化成日期。
	 * 
	 * @param str
	 * @return
	 */
	public static Date getDate(String str) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		Date date = null;
		try {
			date = sf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static String getStrDate(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		return sf.format(date);
	}

	/**
	 * 转化为UNICODE编码。 // xxxServlet?method=show&name=张三&deptName=开发
	 * 
	 * @param value
	 * @return
	 */
	public static String encode(String value) {
		String newname = null;
		try {
			newname = URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newname;
	}

	public static String decode(String value) {
		String newName = null;
		try {
			newName = URLDecoder.decode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newName;
	}
}
