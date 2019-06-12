package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.OrderItemsDao;
import com.niit.womenfashionBackend.Dao.OrdersDao;
import com.niit.womenfashionBackend.Model.OrderItems;
import com.niit.womenfashionBackend.Model.Orders;

public class OrderItemsTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	OrderItems c=(OrderItems)ctx.getBean("orderItems");
	OrderItemsDao cDao=(OrderItemsDao)ctx.getBean("orderitemsDao");
	
	Orders o=(Orders)ctx.getBean("orders");
	OrdersDao oDao=(OrdersDao)ctx.getBean("ordersDao");
	o=oDao.getOrders("O101");
	
	c.setOrdiId("O101");
	c.setProId("P101");
	c.setOrders(o);
	
	System.out.println("OrderItemsId: "+c.getOrdiId());
	System.out.println("ProductId: "+c.getProId());
	
	if(cDao.saveorupdate(c)==true)
	{
		System.out.println("Order Items saved");
	}
	else
	{
		System.out.println("Order Items not saved");
	}
	
	c=cDao.getOrderItems("O101");
	if(c==null)
	{
		System.out.println("Order Items not found");
	}
	else
	{
		System.out.println("OrderItemsId: "+c.getOrdiId());
		System.out.println("ProductId: "+c.getProId());
	}
	
	c=cDao.getOrderItems("O102");
	if(c==null)
	{
		System.out.println("Order Items not found");
	}
	else if(cDao.delete(c)==true)
	{
		System.out.println("Order Items deleted");
	}
	else
	{
		System.out.println("Not deleted");
	}
	List<OrderItems> orderitemslist = cDao.orderitemslist();
	for(OrderItems c1: orderitemslist)
	{
		System.out.println("OrderItemsId: "+c1.getOrdiId());
		System.out.println("ProductId: "+c1.getProId());
		
	}
}

}