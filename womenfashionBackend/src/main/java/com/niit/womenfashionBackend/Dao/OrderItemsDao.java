package com.niit.womenfashionBackend.Dao;
import java.util.List;

import com.niit.womenfashionBackend.Model.OrderItems;
public interface OrderItemsDao {
	public boolean saveorupdate(OrderItems orderitems);
	public boolean delete(OrderItems orderitems);
	public OrderItems getOrderItems(String ordiId);
	public List<OrderItems> orderitemslist();
	
}