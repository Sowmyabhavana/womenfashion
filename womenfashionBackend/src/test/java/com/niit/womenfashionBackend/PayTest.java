package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.PayDao;
import com.niit.womenfashionBackend.Model.Pay;

public class PayTest {
	
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	
	Pay c=(Pay)ctx.getBean("pay");
	PayDao cDao=(PayDao)ctx.getBean("payDao");
	
	c.setPaId("c101");
	c.setPaMethod("Card");
	c.setPayStatus("paid");

			System.out.println("PayId:"+c.getPaId());
			System.out.println("PayMethod:"+c.getPaMethod());
			System.out.println("PayStatus:"+c.getPayStatus());
			
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("Pay saved");
				
			}
			else
			{
				System.out.println("pay not saved");
			}
			c=cDao.getPay("c101");
			if(c==null)
			{
				System.out.println("Pay not found");
				
			}
			else
			{
				System.out.println("PayId:"+c.getPaId());
				System.out.println("PayMethod:"+c.getPaMethod());
				System.out.println("PayStatus:"+c.getPayStatus());
				
			}
			c=cDao.getPay("c102");
			if(c==null)
			{
				System.out.println("pay deleted");
				
			}
			else if(cDao.delete(c)==true)
				System.out.println("pay deleted");
			else
				System.out.println("not deleted");
			List<Pay> paylist=cDao.paylist();
			for(Pay c1:paylist)
			{
				System.out.println("PayId:"+c1.getPaId());
				System.out.println("PayMethod:"+c1.getPaMethod());
				System.out.println("PayStatus:"+c1.getPayStatus());
			}
}
}
