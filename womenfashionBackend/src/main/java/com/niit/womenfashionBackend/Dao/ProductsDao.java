package com.niit.womenfashionBackend.Dao;
import java.util.List;

import com.niit.womenfashionBackend.Model.Products;
public interface ProductsDao {
	public boolean saveorupdate(Products products);
	public boolean delete(Products products);
	public Products getProducts(String proId);
	public List<Products> productslist();
	public List<Products> getProductsById(String catId);
	
}