package com.niit.womenfashionBackend.Dao;
import java.util.List;

import com.niit.womenfashionBackend.Model.CartItems;
public interface CartItemsDao {
	public boolean saveorupdate(CartItems cartitems);
	public boolean delete(CartItems cartitems);
	public CartItems getCartItems(String cariId);
	public List<CartItems> cartitemslist();
	public List<CartItems> cartitemslist(String id);	
}