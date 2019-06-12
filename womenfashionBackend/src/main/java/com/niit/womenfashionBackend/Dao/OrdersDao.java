package com.niit.womenfashionBackend.Dao;
import java.util.List;

import com.niit.womenfashionBackend.Model.Orders;
public interface OrdersDao {
	public boolean saveorupdate(Orders orders);
	public boolean delete(Orders orders);
	public Orders getOrders(String ordId);
	public List<Orders> orderslist();
	
}