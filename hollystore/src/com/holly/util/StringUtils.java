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
	 * @Description: ���ַ�����ʽ������ת������������
	 * @Version: V1.00 ���汾�ţ�
	 * @Create Date: 2011-12-22 ���������ڣ�
	 * @Parameters: String date �ַ������͵�������ʽ
	 * @Return: Date ��������
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
	 * @Description:�ж���֤�������Ƿ���ȷ
	 * @returnType: boolean
	 * @createTime: 2016��6��13��
	 * @param request
	 * @return
	 */
	public static boolean isCheckNum(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// ��ȡSession�л������֤��
		boolean flag = false;
		String check_number_key = (String) request.getSession().getAttribute("CHECK_NUMBER_KEY");
		// ��ȡ�������֤��
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
	 * @Description:ʹ��Cookies�ķ�ʽ����Ӽ�ס�ҵĹ���
	 * @returnType: void
	 * @createTime: 2016��6��13��
	 * @param request
	 * @param response
	 * @param idCode 
	 * @throws UnsupportedEncodingException
	 */
	public static void addCookies(HttpServletRequest request, HttpServletResponse response, Users users)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		// �����û��������룬��������cookie
		// ʹ�ñ��룬������Ĵ洢cookie����������
		Cookie nameCookie = new Cookie("account", URLEncoder.encode(users.getAccount(), "utf-8"));
		Cookie passwordCookie = new Cookie("password", URLEncoder.encode(users.getPassword(), "utf-8"));
		
		// ��ȡ�Ƿ����˼�ס��

		String rememberMe = users.getRememberMe();
		// �������ˣ��򱣴�cookie,��Ϊcookie��������ʱ��
		if (rememberMe != null && !rememberMe.equals("")) {
			nameCookie.setMaxAge(7 * 24 * 60 * 60);
			passwordCookie.setMaxAge(7 * 24 * 60 * 60);
			
		} else {
			nameCookie.setMaxAge(0);
			passwordCookie.setMaxAge(0);
			
		}

		// ��cookie����response������,��������Ӧͷ
		response.addCookie(nameCookie);
		response.addCookie(passwordCookie);
		

	}

}