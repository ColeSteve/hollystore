package com.holly.dao;

import java.util.List;

import com.holly.domain.Products;
import com.holly.domain.UserProd;
import com.holly.domain.Users;

public interface IProductsDao extends ICommonDao<Products> {

	List<Products> showProductsByProdType(String prodType);
  // Products findProductsByName(String name);

	Products getProdInfo(int id);

	void saveUserProd(Products products, Users users);

	List<UserProd> getBuyCarInfo(String name);

	List<Products> showAllProducts();
}
