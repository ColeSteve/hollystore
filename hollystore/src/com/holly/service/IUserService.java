package com.holly.service;

import java.util.List;

import com.holly.domain.Users;


public interface IUserService {

	List<Users> findAllUsers();

	List<Users> searchUserByCondition(String condition, String value);

	Users findUserByName(String name);

	void updateUsers(Users users);

	void deleteUser(Users users);

	Users allowLogin(Users users);

	void saveUser(Users users);

	List<Users> findByPage(String start, String number);

	Long getCountUsers();

	List<Users> findUserByAddress(String address);

	void export() throws Exception;

}
