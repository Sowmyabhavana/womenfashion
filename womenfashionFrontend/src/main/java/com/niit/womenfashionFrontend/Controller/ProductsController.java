package com.niit.womenfashionFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.projname.FileInput.FileInput;
import com.niit.womenfashionBackend.Dao.CategoryDao;
import com.niit.womenfashionBackend.Dao.ProductsDao;
import com.niit.womenfashionBackend.Dao.SupplierDao;
import com.niit.womenfashionBackend.Model.Category;
import com.niit.womenfashionBackend.Model.Products;
import com.niit.womenfashionBackend.Model.Supplier;


@Controller
public class ProductsController
{
	@Autowired
	Products products;
	@Autowired
	ProductsDao productsDao; 
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Supplier supplier;
	@Autowired 
	SupplierDao supplierDao;
	
	String path="D:\\womenfashionFrontend\\src\\main\\webapp\\resources\\img\\product-img\\";
	
	@RequestMapping("/admin/products")
	public String products(Model model)
	{
		Products p=new Products();
	    
		model.addAttribute("products",p);
		Category c=new Category();
		model.addAttribute("category",c);
		Supplier s=new Supplier();
		model.addAttribute("supplier",s);
		List<Category> categories=categoryDao.categorylist();
	    model.addAttribute("categories",categories);
	    List<Supplier> suppliers=supplierDao.supplierlist();
	    model.addAttribute("suppliers",suppliers);


		
		return "productsform";
	}
	@RequestMapping(value="/admin/addProducts",method=RequestMethod.POST)
	public String addProducts(@ModelAttribute("products") Products products,Model model)
	{
		if(productsDao.saveorupdate(products)==true)
		{
			FileInput.upload(path, products.getPimg(), products.getProId()+".jpg");
			Products p=new Products();
			model.addAttribute("products",p);
			List<Products> productss=productsDao.productslist();
		    model.addAttribute("productss",productss);
			model.addAttribute("mess", "saved successful");
		    return "redirect:/admin/viewproducts";
		}
		else
		{
			model.addAttribute("mess", "Sorry");	
			Products p=new Products();
			model.addAttribute("products",p);
			return "productsform";
		}
		
	}
	@RequestMapping(value="/admin/productss",method=RequestMethod.GET)
	public String viewListProducts(@ModelAttribute("products") Products products,Model model)
	{
			List<Products> productss=productsDao.productslist();
		    model.addAttribute("productss",productss);
		    return "redirect:/admin/viewproducts";
		
	}
	
	@RequestMapping(value="/admin/viewproducts")
	public String viewproducts(Model model)
	{
		List<Products> productss=productsDao.productslist();
		model.addAttribute("productss",productss);
		return "viewproduct";
		
	}
	@RequestMapping(value = "/admin/deleteproducts/{id}")
	public String deleteproducts(@PathVariable("id") String id, Model model) {
		Products c = productsDao.getProducts(id);
		if (productsDao.delete(c) == true) {
			model.addAttribute("message", "Products is successfully deleted");
			return "redirect:/admin/viewproduct";
		} else
			return "redirect:/admin/viewproduct";

	}

	@RequestMapping(value = "/admin/editproduct/{id}")
	public String editcategory(@PathVariable("id") String id, Model model) {
		Category c = categoryDao.getCategory(id);
		model.addAttribute("category", c);
		return "categoryform";
	}
	
	@RequestMapping(value="/shop/{id}")
	public String getProductByCat(@PathVariable("id")String id,Model model)
	{
		System.out.println(123);
		List<Category> categories=categoryDao.categorylist();
		List<Products> productss=productsDao.getProductsById(id);
		model.addAttribute("categories", categories);
		model.addAttribute("products",productss);
		return "index";
		
	}
}
