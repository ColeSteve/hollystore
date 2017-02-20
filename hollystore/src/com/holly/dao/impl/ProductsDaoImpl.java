package com.holly.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.holly.dao.IProductsDao;
import com.holly.domain.Products;
import com.holly.domain.UserProd;
import com.holly.domain.Users;

public class ProductsDaoImpl extends CommonDaoImpl<Products> implements IProductsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> showProductsByProdType(String prodType) {
		return getSession().createQuery("from Products p where p.prodType='" + prodType + "'").list();
	}

	@Override
	public Products getProdInfo(int id) {
		return (Products) getSession().createQuery("from Products p where p.id=?").setInteger(0, id).uniqueResult();
	}

	// ������Ĳ�Ʒ��Ϣ���뵱ǰ�û�
	@Override
	public void saveUserProd(Products products, Users users) {
		Set<Products> set = new HashSet<>();
		set.add(products);
		users.setProducts(set);
		users.setBuyCar(products.getProdDesc());
		users.setProdCount(users.getProdCount() + 1);

		saveUserProdInfo(products, users);

		getSession().update(users);
	}

	/**
	 * 
	 * @param products
	 * @param users
	 *            ��ȡ�����������Ʒ�û���ϵ�����Ϣ
	 */
	private void saveUserProdInfo(Products products, Users users) {

		UserProd userProd = (UserProd) getSession().createQuery("from UserProd u where u.prodName='"
				+ products.getProdName() + "' and u.name='" + users.getName() + "'").uniqueResult();
		// �����ھͱ����¼�¼
		if (userProd == null) {
			userProd = new UserProd();
			userProd.setName(users.getName());
			userProd.setProdName(products.getProdName());
			userProd.setProdDesc(products.getProdDesc());
			userProd.setProdImg(products.getProdImg());
			userProd.setProdStore(1);
			// userProd.setId(products.getId());// ���ƷID����һ��,���²�ͬ�û����ܴ�ͬһ����Ʒ
			getSession().save(userProd);
		} else {// ���ھ͸�������
			userProd.setProdStore(userProd.getProdStore() + 1);
			getSession().update(userProd);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserProd> getBuyCarInfo(String name) {
		return getSession().createQuery("from UserProd u where u.name=?").setParameter(0, name).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> showAllProducts() {
		return getSession().createQuery("from Products").list();
	}

}
