package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.BillingDao;
import com.niit.womenfashionBackend.Model.Billing;



public class BillingTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	//Category c=new Category();
	Billing c=(Billing)ctx.getBean("billing");
	BillingDao cDao=(BillingDao)ctx.getBean("billingDao");
	c.setBilId("c101");
	c.setBilName("Billing1");
			System.out.println("BillingId:"+c.getBilId());
			System.out.println("BillingName:"+c.getBilName());
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("Billing saved");
				
			}
			else
			{
				System.out.println("Billing not saved");
			}
			c=cDao.getBilling("c101");
			if(c==null)
			{
				System.out.println("Billing not found");
				
			}
			else
			{
				System.out.println("billingId:"+c.getBilId());
				System.out.println(" billingName:"+c.getBilName());
				
			}
			c=cDao.getBilling("c102");
			if(c==null)
			{
				System.out.println("billing deleted");
				
			}
			else if(cDao.delete(c)==true)
				System.out.println("billing deleted");
			else
				System.out.println("not deleted");
			List<Billing> billinglist=cDao.billinglist();
			for(Billing c1:billinglist)
			{
				System.out.println("billingname:"+c1.getBilName());
			}
}
}
