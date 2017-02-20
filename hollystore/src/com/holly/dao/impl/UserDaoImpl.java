package com.holly.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.holly.dao.IUserDao;
import com.holly.domain.Users;

public class UserDaoImpl extends CommonDaoImpl<Users> implements IUserDao {

	@Override
	public List<Users> findAllUsers() {

		@SuppressWarnings("unchecked")
		List<Users> list = getSession().createQuery("from Users").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> searchUserByName(String value) {
		return getSession().createQuery("from Users u where u.name like '%" + value + "%'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> searchUserByAddress(String value) {
		return getSession().createQuery("from Users u where u.address like '%" + value + "%'").list();
	}

	// 根据用户名和密码进行判断
	@Override
	public Users checkUser(Users users, String account, String password) {
		// SQLQuery query = getSession().createSQLQuery("select name,account
		// from sys_users u where u.account='"+account+"' and
		// u.password='"+password+"'");
		Query query = getSession()
				.createQuery("from Users u where u.account='" + account + "' and u.password='" + password + "'");
		Users users2 = (Users) query.uniqueResult();

		if (users2 != null && !users2.getName().equals("")) {
			return users2;
		} else {
			return users2;
		}

	}

	//统计总数
	@Override
	public Long getCount() {
		return (Long) getSession().createQuery("select count(u.id) from Users u").list().get(0);
	}

}
