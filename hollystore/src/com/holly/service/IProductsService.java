package com.holly.service;

import java.util.List;

import com.holly.domain.Products;
import com.holly.domain.UserProd;
import com.holly.domain.Users;

public interface IProductsService {

	List<Products> showProductsWithConn();

	List<Products> showProductsWithSoft();

	List<Products> showProductsWithLife();

	Products getProdInfo(int id);

	void updateProduct(String pid, Users users2);

	List<UserProd> getBuyCarInfo(String name);

	void saveProdInfo(Products products);

	List<Products> showAllProducts();

	void deleteProduct(String pid);


}
