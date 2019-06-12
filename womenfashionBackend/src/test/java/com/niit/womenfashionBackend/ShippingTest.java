package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.ShippingDao;
import com.niit.womenfashionBackend.Model.Shipping;

public class ShippingTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	//Category c=new Category();
	Shipping c=(Shipping)ctx.getBean("shipping");
	ShippingDao cDao=(ShippingDao)ctx.getBean("ShippingDao");
	c.setShipId("c101");
	c.setShipId("Shipping1");
			System.out.println("ShippingId:"+c.getShipId());
			System.out.println("ShippingName:"+c.getShipName());
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("Shipping saved");
				
			}
			else
			{
				System.out.println("Shipping not saved");
			}
			c=cDao.getShipping("c101");
			if(c==null)
			{
				System.out.println("shipping not found");
				
			}
			else
			{
				System.out.println("shippingId:"+c.getShipId());
				System.out.println("shippingName:"+c.getShipName());
				
			}
			c=cDao.getShipping("c102");
			if(c==null)
			{
				System.out.println("shipping deleted");
				
			}
			else if(cDao.delete(c)==true)
				System.out.println("shipping deleted");
			else
				System.out.println("shipping not deleted");
			List<Shipping> shippinglist=cDao.shippinglist();
			for(Shipping c1:shippinglist)
			{
				System.out.println("shippingname:"+c1.getShipName());
			}
}
}
