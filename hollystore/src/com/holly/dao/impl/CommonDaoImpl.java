package com.holly.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.holly.dao.BaseDao;
import com.holly.dao.ICommonDao;

public class CommonDaoImpl<T> extends BaseDao implements ICommonDao<T> {

	/**
	 * 保存操作
	 */
	@Override
	public void save(Object entity) {
		getSession().save(entity);
	}

	/**
	 * 更新操作
	 */
	@Override
	public void update(Object entity) {
		getSession().update(entity);

	}

	/**
	 * 删除操作
	 */
	@Override
	public void delete(Object entity) {
		getSession().delete(entity);
	}

	/**
	 * 查询操作（根据名称）
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findByName(String name) {
		// ParameterizedType
		// pType=(ParameterizedType)getClass().getGenericSuperclass();
		// Class<T> clazz =(Class<T>) pType.getActualTypeArguments()[0];
		return (T) getSession().createQuery("from Users u where u.name = '" + name + "'").uniqueResult();
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<T> findByPage(String start, String number, String hql) {
		// 当为缺省值的时候进行赋值
		int currentpage = Integer.parseInt((start == null || start == "0") ? "1" : start);// 第几页
		int pagesize = Integer.parseInt((number == null || number == "0") ? "10" : number);// 每页多少行

		List list =getSession().createQuery(hql)
				.setFirstResult((currentpage - 1) * pagesize).setMaxResults(pagesize).list();

		return list;
	}

}
