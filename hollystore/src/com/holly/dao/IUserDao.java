package com.holly.dao;

import java.util.List;

import com.holly.domain.Users;

public interface IUserDao extends ICommonDao<Users>{

	List<Users> findAllUsers();
   // Users findUserByName(String name);

	List<Users> searchUserByName(String value);

	List<Users> searchUserByAddress(String value);

	Users checkUser(Users users, String account, String password);

	Long getCount();

}
