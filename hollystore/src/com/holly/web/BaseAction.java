package com.holly.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	private static final long serialVersionUID = 1L;
   

	public  HttpServletRequest request;
	public HttpServletResponse response;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;	
	}
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
	    this.response = response;
		
	}

}
