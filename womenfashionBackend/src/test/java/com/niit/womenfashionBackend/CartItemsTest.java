package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.CartDao;
import com.niit.womenfashionBackend.Dao.CartItemsDao;
import com.niit.womenfashionBackend.Model.Cart;
import com.niit.womenfashionBackend.Model.CartItems;



public class CartItemsTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	
	CartItems c=(CartItems)ctx.getBean("cartitems");
	CartItemsDao cDao=(CartItemsDao)ctx.getBean("cartitemsDao");
	
	Cart cat=(Cart)ctx.getBean("cart");
	CartDao catDao=(CartDao)ctx.getBean("cartDao");
	cat=catDao.getCart("c101");
	
	c.setCariId("c101");
	c.setPrice((float) 10.0);
	c.setCart(cat);
			System.out.println("CartItemsId:"+c.getCariId());
			System.out.println("Price:"+c.getPrice());
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("CartItems saved");
				
			}
			else
			{
				System.out.println("CartItems not saved");
			}
			c=cDao.getCartItems("c101");
			if(c==null)
			{
				System.out.println("cartitems not found");
				
			}
			else
			{
				System.out.println("cartitemsId:"+c.getCariId());
				System.out.println(" Price:"+c.getPrice());
				
			}
			c=cDao.getCartItems("c102");
			if(c==null)
			{
				System.out.println("cartitems not found");
				
			}
			else if(cDao.delete(c)==true)
				System.out.println("cartitems deleted");
			else
				System.out.println("not deleted");
			List<CartItems> cartitemslist=cDao.cartitemslist();
			for(CartItems c1:cartitemslist)
			{
				System.out.println("cartitemsId:"+c.getCariId());
				System.out.println("Price:"+c1.getPrice());
			}
}
}
