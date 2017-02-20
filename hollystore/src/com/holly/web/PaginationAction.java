package com.holly.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.holly.domain.Users;
import com.holly.service.IUserService;
import com.holly.util.JSONParser;

import net.sf.json.JSONObject;

public class PaginationAction {
	static Logger log = Logger.getLogger(PaginationAction.class);
	private JSONObject jsonObj;
	private String rows;// 每页显示的记录数
	private String page;// 当前第几页
	private IUserService userService;// String依赖注入
	private String username;
	private String address;
	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// 查询出所有学生信息
	public String listUser() throws Exception {
		log.info("查询出所有学生信息");
		List<Users> list=new ArrayList<>();
        if (username!=null&&!username.equals("")) {
			Users users = userService.findUserByName(username);
			list.add(users);
		}else if (address!=null&&!address.equals("")) {
			list=userService.findUserByAddress(address);
		}else {
			 list = userService.findByPage(page, rows);
		}
		this.toBeJson(list, userService.getCountUsers());
		return null;
	}

	public String findUsersByCondition() {
		
		//userService.searchUserByCondition(condition, value);
		return null;
	}
	

	// 转化为Json格式
	public void toBeJson(List<Users> list, Long total) {

        Map<String, Object> map=new HashMap<>();
        map.put("total", total);
		map.put("rows", list);
        
        JSONParser.writeJson(map);
		
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public void setPage(String page) {
		this.page = page;
	}

}
