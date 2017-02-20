package com.holly.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.holly.dao.IUserDao;
import com.holly.domain.Users;
import com.holly.service.IUserService;
import com.holly.util.ExcelFileGenerator;

import oracle.net.aso.l;

@Service
@Transactional(readOnly=false)
public class UserServiceImpl implements IUserService{
    
	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Users> findAllUsers() {
		List<Users> list=userDao.findAllUsers();
		return list;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Users> searchUserByCondition(String condition,String value) {
		List<Users> list=null;
		if (condition.equals("name")) {
			 list=userDao.searchUserByName(value);
		}
		if (condition.equals("address")) {
			list=userDao.searchUserByAddress(value);
		}
		
		return list;
	}

	@Transactional(readOnly=true)
	@Override
	public Users findUserByName(String name) {
		Users users = userDao.findByName(name);
		return users;
	}

	@Override
	public void updateUsers(Users users) {
		userDao.update(users);
	}

	@Override
	public void deleteUser(Users users) {
		
		userDao.delete(users);
	}

	//验证用户信息
	@Override
	public Users allowLogin(Users users) {
		String account=users.getAccount();
		String password=users.getPassword();
		Users users2=userDao.checkUser(users,account,password);
		return users2;
	}

	@Override
	public void saveUser(Users users) {
	  userDao.save(users);
		
	}



	@Override
	public List<Users> findByPage(String start, String number) {
		String hql="from Users";
        List<Users> list=userDao.findByPage(start, number, hql);
        return list;  
	}

	@Override
	public Long getCountUsers() {
		Long count = userDao.getCount();
		return count;
	}

	@Override
	public List<Users> findUserByAddress(String address) {
		List<Users> list = userDao.searchUserByAddress(address);
		return list;
	}

	@Override
	public void export() throws Exception {
		List<Users> users = userDao.findAllUsers();
		
		ArrayList fieldData=this.userToString(users);
		
		
		ArrayList fieldName=this.getFieldName();
		
		ExcelFileGenerator fileGenerator=new ExcelFileGenerator(fieldName, fieldData);
		OutputStream os=new FileOutputStream(new File("D:/test/usersList.xls"));
		fileGenerator.expordExcel(os);
		
	}

	private ArrayList userToString(List<Users> users) {
	    ArrayList list=new ArrayList<>();
	    List uList=null;
		for (int i = 0; i < users.size(); i++) {
			uList=new ArrayList<>();
			uList.add(users.get(i).getName());
			uList.add(users.get(i).getAccount());
			uList.add(users.get(i).getAddress());
			uList.add(users.get(i).getEmail());
			uList.add(users.get(i).getCompany());
			list.add(uList);
		}
		
		return list;
	}

	private ArrayList getFieldName() {
		String[] head= {"姓名","账户","地址","邮箱","单位"};
		ArrayList fieldName=new ArrayList<>();
		
		for (int i = 0; i < head.length; i++) {
			fieldName.add(head[i]);
		}
		return fieldName;
	}
	
}
