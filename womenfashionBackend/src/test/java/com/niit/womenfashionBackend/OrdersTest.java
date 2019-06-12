package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.OrdersDao;
import com.niit.womenfashionBackend.Model.Orders;

public class OrdersTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	
	Orders c=(Orders)ctx.getBean("orders");
	OrdersDao cDao=(OrdersDao)ctx.getBean("OrdersDao");
  
	c.setOrdId("c101");
	c.setGrandtotal((double)100.00000);
	
			System.out.println("OrdersId:"+c.getOrdId());
			System.out.println("Grandtotal:"+c.getGrandtotal());
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("Orders saved");
				
			}
			else
			{
				System.out.println("Orders not saved");
			}
			c=cDao.getOrders("c101");
			if(c==null)
			{
				System.out.println("Orders not found");
				
			}
			else
			{
				System.out.println("ordersId:"+c.getOrdId());
				System.out.println("Grandtotal:"+c.getGrandtotal());
				
			}
			c=cDao.getOrders("c102");
			if(c==null)
			{
				System.out.println("orders deleted");
				
			}
			else if(cDao.delete(c)==true)
				System.out.println("orders deleted");
			else
				System.out.println("not deleted");
			List<Orders> orderslist=cDao.orderslist();
			for(Orders c1:orderslist)
			{
				System.out.println("ordersId:"+c1.getOrdId());
				System.out.println("Grandtotal:"+c1.getGrandtotal());
							}
}
}
