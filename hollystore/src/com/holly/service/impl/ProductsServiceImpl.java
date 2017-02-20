package com.holly.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.holly.dao.IProductsDao;
import com.holly.domain.Products;
import com.holly.domain.UserProd;
import com.holly.domain.Users;
import com.holly.service.IProductsService;

@Service
@Transactional(readOnly=false)
public class ProductsServiceImpl implements IProductsService {
	private IProductsDao productsDao;
	String prodType=null;
	public void setProductsDao(IProductsDao productsDao) {
		this.productsDao = productsDao;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Products> showProductsWithConn() {
	    prodType="connection";
		List<Products> list=productsDao.showProductsByProdType(prodType);
		return list;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Products> showProductsWithSoft() {
		    prodType="software";
			List<Products> list=productsDao.showProductsByProdType(prodType);
			return list;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Products> showProductsWithLife() {
		prodType="life";
		List<Products> list=productsDao.showProductsByProdType(prodType);
		return list;
	}

	@Override
	public Products getProdInfo(int id) {
		Products products=  productsDao.getProdInfo(id);
		return products;
	}

	//购买产品，产品库存更新；并将该产品加入当前用户
	@Override
	public void updateProduct(String pid,Users users) {
		Products products=productsDao.getProdInfo(Integer.parseInt(pid));
		productsDao.saveUserProd(products,users);
		products.setProdStore(products.getProdStore()-1);
		productsDao.update(products);
	}

	@Override
	public List<UserProd> getBuyCarInfo(String name) {
		List<UserProd>list= productsDao.getBuyCarInfo(name);
		return list;
	}

	@Override
	public void saveProdInfo(Products products) {
		productsDao.save(products);
		
	}

	@Override
	public List<Products> showAllProducts() {
		List<Products> list= productsDao.showAllProducts();
		return list;
	}

	@Override
	public void deleteProduct(String pid) {
		Products products=productsDao.getProdInfo(Integer.parseInt(pid));
		productsDao.delete(products);	
	}
	


}
