package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.ProductsDao;
import com.niit.womenfashionBackend.Model.Products;

public class ProductsTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	//Category c=new Category();
	Products c=(Products)ctx.getBean("products");
	ProductsDao cDao=(ProductsDao)ctx.getBean("ProductsDao");
	c.setProId("c101");
	c.setProName("Products1");
			System.out.println("ProductsId:"+c.getProId());
			System.out.println("ProductsName:"+c.getProName());
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("Products saved");
				
			}
			else
			{
				System.out.println("Products not saved");
			}
			c=cDao.getProducts("c101");
			if(c==null)
			{
				System.out.println("Products not found");
				
			}
			else
			{
				System.out.println("products:"+c.getProId());
				System.out.println("products:"+c.getProName());
				
			}
			c=cDao.getProducts("c102");
			if(c==null)
			{
				System.out.println("products deleted");
				
			}
			else if(cDao.delete(c)==true)
				System.out.println("products deleted");
			else
				System.out.println("not deleted");
			List<Products> productslist=cDao.productslist();
			
			for(Products c1:productslist)
			{
				System.out.println("Productsname:"+c1.getProName());
			}
}
}
