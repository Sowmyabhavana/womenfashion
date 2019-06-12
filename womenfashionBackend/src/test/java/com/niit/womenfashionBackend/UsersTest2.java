package com.niit.womenfashionBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.UsersDao;
import com.niit.womenfashionBackend.Model.Users;

public class UsersTest2 {

public static void main(String args[])
{
AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
ctx.scan("com.niit.*");
ctx.refresh();

Users c=(Users)ctx.getBean("users");
UsersDao cDao=(UsersDao)ctx.getBean("usersDao");
c.setUseEmailId("sowmyanagendra.k@gmail.com");
c.setUsePassword("Sowmya@1998");

System.out.println("UseEmailid: "+c.getUseEmailId());
System.out.println("UsePassword: "+c.getUsePassword());

c=cDao.isValidate("sowmyanagendra.k@gmail.com","Sowmya@1998");
if(c==null)
{
	System.out.println("Users not found");
}
else
{
	System.out.println("UseEmailid: "+c.getUseId());
	System.out.println("UsePassword: "+c.getUsePassword());
}


c=cDao.isValidate("sowmyanagendra.k@gmail.com","Sowmya@1998");
if(c==null)
{
	System.out.println("Users not found");
}
else
{
	System.out.println("UsersEmailid: "+c.getUseId());
	System.out.println("UsersPassword: "+c.getUsePassword());
}
}
}

