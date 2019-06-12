package com.niit.womenfashionFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.womenfashionBackend.Dao.CategoryDao;
import com.niit.womenfashionBackend.Dao.ProductsDao;
import com.niit.womenfashionBackend.Model.Category;
import com.niit.womenfashionBackend.Model.Products;

@Controller
public class HomeController {
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Products products;
	@Autowired
	ProductsDao productsDao;
	
	@RequestMapping(value="/")
	public String index(Model model)
	{
		List<Category> categories=categoryDao.categorylist();
		List<Products> products=productsDao.productslist();
		model.addAttribute("categories", categories);
		model.addAttribute("products",products);
		return "index";
	}

}
