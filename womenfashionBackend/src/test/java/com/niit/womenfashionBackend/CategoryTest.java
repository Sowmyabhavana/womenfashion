package com.niit.womenfashionBackend;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.womenfashionBackend.Dao.CategoryDao;
import com.niit.womenfashionBackend.Model.Category;

public class CategoryTest {
public static void main(String args[])
{
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	//Category c=new Category();
	Category c=(Category)ctx.getBean("category");
	CategoryDao cDao=(CategoryDao)ctx.getBean("categoryDao");
	c.setCatId("c101");
	c.setCatName("Category1");
			System.out.println("CategoryId:"+c.getCatId());
			System.out.println("CategoryName:"+c.getCatName());
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("Category saved");
				
			}
			else
			{
				System.out.println("category not saved");
			}
			c=cDao.getCategory("c101");
			if(c==null)
			{
				System.out.println("category not found");
				
			}
			else
			{
				System.out.println("categoryId:"+c.getCatId());
				System.out.println(" categoryName:"+c.getCatName());
				
			}
			c=cDao.getCategory("c102");
			if(c==null)
			{
				System.out.println("category deleted");
				
			}
			else if(cDao.delete(c)==true)
				System.out.println("category deleted");
			else
				System.out.println("not deleted");
			List<Category> categorylist=cDao.categorylist();
			for(Category c1:categorylist)
			{
				System.out.println("categoryname:"+c1.getCatName());
			}
}
}
