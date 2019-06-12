package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.AuthenticationDao;
import com.niit.womenfashionBackend.Model.Authentication;


public class AuthenticationTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	
	Authentication c=(Authentication)ctx.getBean("authentication");
	AuthenticationDao cDao=(AuthenticationDao)ctx.getBean("authenticationDao");
	c.setAuthId("c101");
	c.setAuthName("Authentication1");
			System.out.println("AuthenticationId:"+c.getAuthId());
			System.out.println("AuthenticationName:"+c.getAuthName());
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("Authentication saved");
				
			}
			else
			{
				System.out.println("authentication not saved");
			}
			c=cDao.getAuthentication("c101");
			if(c==null)
			{
				System.out.println("authentication not found");
				
			}
			else
			{
				System.out.println("authenticationId:"+c.getAuthId());
				System.out.println("authenticationName:"+c.getAuthName());
				
			}
			c=cDao.getAuthentication("c102");
			if(c==null)
			{
				System.out.println("authentiction deleted");
				
			}
			else if(cDao.delete(c)==true)
				System.out.println("authentication deleted");
			else
				System.out.println("not deleted");
			List<Authentication> authenticationlist=cDao.authenticationlist();
			for(Authentication c1:authenticationlist)
			{
				System.out.println("authenticationname:"+c1.getAuthName());
			}
}
}
