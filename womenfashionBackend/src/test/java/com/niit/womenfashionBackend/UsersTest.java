package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.BillingDao;
import com.niit.womenfashionBackend.Dao.CartDao;
import com.niit.womenfashionBackend.Dao.UsersDao;
import com.niit.womenfashionBackend.Model.Billing;
import com.niit.womenfashionBackend.Model.Cart;
import com.niit.womenfashionBackend.Model.Users;

public class UsersTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	
	Users c=(Users)ctx.getBean("users");
	UsersDao cDao=(UsersDao)ctx.getBean("usersDao");
	
	Billing b=(Billing)ctx.getBean("billing");
	BillingDao bDao=(BillingDao)ctx.getBean("billingDao");
	b=bDao.getBilling("B101");
	
	Cart cat=(Cart)ctx.getBean("cart");
	CartDao catDao=(CartDao)ctx.getBean("cartDao");
	cat=catDao.getCart("C101");
	
	c.setUseId("U101");
	c.setUseName("sowmya");
	c.setUseEmailId("sowmyanagendra.k@gmail.com");
	c.setUsePhoneNo("7996886232");
	c.setUseAddress("bangalore");
	c.setUsePassword("Sowmya@1998");
	c.setBilling(b);
	c.setCart(cat);
	
	
	System.out.println("UsersId: "+c.getUseId());
	System.out.println("UsersName: "+c.getUseName());
	System.out.println("UsersPhoneNo: "+c.getUsePhoneNo());
	System.out.println("Usersemailid: "+c.getUseEmailId());
	System.out.println("UsersAddress: "+c.getUseAddress());
	System.out.println("UsersPasword: "+c.getUsePassword());
	
	if(cDao.saveorupdate(c)==true)
	{
		System.out.println("Users saved");
	}
	else
	{
		System.out.println("Users not saved");
	}
	
	c=cDao.getUsers("U101");
	if(c==null)
	{
		System.out.println("Users not found");
	}
	else
	{
		System.out.println("UsersId: "+c.getUseId());
		System.out.println("UsersName: "+c.getUseName());
		System.out.println("UsersPhoneNo: "+c.getUsePhoneNo());
		System.out.println("Usersemailid: "+c.getUseEmailId());
		System.out.println("UsersAddress: "+c.getUseAddress());
		System.out.println("UsersPasword: "+c.getUsePassword());
		
	}
	
	c=cDao.getUsers("U102");
	if(c==null)
	{
		System.out.println("Users not found");
	}
	else if(cDao.delete(c)==true)
	{
		System.out.println("Users deleted");
	}
	else
	{
		System.out.println("Not deleted");
	}
	List<Users> userslist = cDao.userslist();
	for(Users c1: userslist)
	{
		System.out.println("UsersId: "+c1.getUseId());
		System.out.println("UsersName: "+c1.getUseName());
		System.out.println("UsersPhoneNo: "+c1.getUsePhoneNo());
		System.out.println("Usersemailid: "+c1.getUseEmailId());
		System.out.println("UsersAddress: "+c1.getUseAddress());
		System.out.println("UsersPasword: "+c1.getUsePassword());
		
		
	}
}
}

