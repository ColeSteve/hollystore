package com.holly.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONParser {
	
	final static ObjectMapper om = new ObjectMapper();
	public static void writeJson(Object obj) {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			om.writeValue(response.getWriter(), obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
