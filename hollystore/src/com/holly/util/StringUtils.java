package com.holly.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holly.domain.Users;


public class StringUtils {

	/**
	 * @Name: stringConvertDate
	 * @Description: 将字符串形式的类型转换成日期类型
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2011-12-22 （创建日期）
	 * @Parameters: String date 字符串类型的日期形式
	 * @Return: Date 日期类型
	 */
	public static Date stringConvertDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 
	 * @version: V1.0
	 * @author keer1
	 * @Description:判断验证码输入是否正确
	 * @returnType: boolean
	 * @createTime: 2016年6月13日
	 * @param request
	 * @return
	 */
	public static boolean isCheckNum(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 获取Session中缓存的验证码
		boolean flag = false;
		String check_number_key = (String) request.getSession().getAttribute("CHECK_NUMBER_KEY");
		// 获取输入的验证码
		String checkNum = request.getParameter("checkNum");
		if (checkNum != null && !checkNum.equalsIgnoreCase("") && check_number_key.equals(checkNum)) {
			flag = true;
		}

		return flag;
	}

	/**
	 * 
	 * @version: V1.0
	 * @author keer1
	 * @Description:使用Cookies的方式，添加记住我的功能
	 * @returnType: void
	 * @createTime: 2016年6月13日
	 * @param request
	 * @param response
	 * @param idCode 
	 * @throws UnsupportedEncodingException
	 */
	public static void addCookies(HttpServletRequest request, HttpServletResponse response, Users users)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		// 保存用户名和密码，创建两个cookie
		// 使用编码，解决中文存储cookie的乱码问题
		Cookie nameCookie = new Cookie("account", URLEncoder.encode(users.getAccount(), "utf-8"));
		Cookie passwordCookie = new Cookie("password", URLEncoder.encode(users.getPassword(), "utf-8"));
		
		// 获取是否点击了记住我

		String rememberMe = users.getRememberMe();
		// 如果点击了，则保存cookie,即为cookie设置生存时间
		if (rememberMe != null && !rememberMe.equals("")) {
			nameCookie.setMaxAge(7 * 24 * 60 * 60);
			passwordCookie.setMaxAge(7 * 24 * 60 * 60);
			
		} else {
			nameCookie.setMaxAge(0);
			passwordCookie.setMaxAge(0);
			
		}

		// 将cookie加入response对象中,即加入响应头
		response.addCookie(nameCookie);
		response.addCookie(passwordCookie);
		

	}

}