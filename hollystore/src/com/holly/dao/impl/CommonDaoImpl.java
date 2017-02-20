package com.holly.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.holly.dao.BaseDao;
import com.holly.dao.ICommonDao;

public class CommonDaoImpl<T> extends BaseDao implements ICommonDao<T> {

	/**
	 * �������
	 */
	@Override
	public void save(Object entity) {
		getSession().save(entity);
	}

	/**
	 * ���²���
	 */
	@Override
	public void update(Object entity) {
		getSession().update(entity);

	}

	/**
	 * ɾ������
	 */
	@Override
	public void delete(Object entity) {
		getSession().delete(entity);
	}

	/**
	 * ��ѯ�������������ƣ�
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
	 * ��ҳ��ѯ
	 */
	@Override
	public List<T> findByPage(String start, String number, String hql) {
		// ��Ϊȱʡֵ��ʱ����и�ֵ
		int currentpage = Integer.parseInt((start == null || start == "0") ? "1" : start);// �ڼ�ҳ
		int pagesize = Integer.parseInt((number == null || number == "0") ? "10" : number);// ÿҳ������

		List list =getSession().createQuery(hql)
				.setFirstResult((currentpage - 1) * pagesize).setMaxResults(pagesize).list();

		return list;
	}

}
