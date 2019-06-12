package com.niit.womenfashionBackend.Dao;
import java.util.List;

import com.niit.womenfashionBackend.Model.Cart;
public interface CartDao {
	public boolean saveorupdate(Cart cart);
	public boolean delete(Cart cart);
	public Cart getCart(String carId);
	public List<Cart> cartlist();
	
}