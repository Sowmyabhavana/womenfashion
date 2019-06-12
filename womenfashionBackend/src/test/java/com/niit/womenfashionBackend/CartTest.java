package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.CartDao;

import com.niit.womenfashionBackend.Model.Cart;


public class CartTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	
	Cart c=(Cart)ctx.getBean("cart");
	CartDao cDao=(CartDao)ctx.getBean("cartDao");
	c.setCarId("c101");
	c.setGrandTotal(10.0);
	c.setTotalItems(5);
	
			System.out.println("CartId:"+c.getCarId());
			System.out.println("GrandTotal:"+c.getGrandTotal());
			System.out.println("Totaltems:"+c.getTotalItems());
			
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("Cart saved");
				
			}
			else
			{
				System.out.println("cart not saved");
			}
			c=cDao.getCart("c101");
			if(c==null)
			{
				System.out.println("cart not found");
				
			}
			else
			{
				System.out.println("cartId:"+c.getCarId());
				System.out.println("GrandTotal:"+c.getGrandTotal());
				System.out.println("Totaltems:"+c.getTotalItems());
				
				
			}
			c=cDao.getCart("c102");
			if(c==null)
			{
				System.out.println("cart not found");
				
			}
			else if(cDao.delete(c)==true)
				System.out.println("cart deleted");
			else
				System.out.println("not deleted");
			List<Cart> cartlist=cDao.cartlist();
			for(Cart c1:cartlist)
			{
				System.out.println("cartId:"+c.getCarId());
				System.out.println("GrandTotal:"+c.getGrandTotal());
				System.out.println("Totaltems:"+c.getTotalItems());
			}
}
}
