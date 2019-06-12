package com.niit.womenfashionFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.womenfashionBackend.Dao.CategoryDao;
import com.niit.womenfashionBackend.Model.Category;

@Controller
public class CategoryController {
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;

	@RequestMapping("/admin/category")
	public String category(Model model) {
		Category c = new Category();

		model.addAttribute("category", c);

		return "categoryform";
	}

	@RequestMapping(value = "/admin/addCategory", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		if (categoryDao.saveorupdate(category) == true) {
			Category c = new Category();
			model.addAttribute("category", c);
			List<Category> categories = categoryDao.categorylist();
			model.addAttribute("categories", categories);
			model.addAttribute("mess", "saved successful");
			return "redirect:/admin/viewcategory";
		} else {
			model.addAttribute("mess", "Sorry");
			Category c = new Category();
			model.addAttribute("category", c);
			return "categoryform";
		}

	}

	@RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
	public String viewListCategory(@ModelAttribute("category") Category category, Model model) {
		List<Category> categories = categoryDao.categorylist();
		model.addAttribute("categories", categories);
		return "redirect:/admin/viewcategory";

	}

	@RequestMapping(value = "/admin/viewcategory")
	public String viewcategory(Model model) {
		List<Category> categories = categoryDao.categorylist();
		model.addAttribute("categories", categories);
		return "viewcategory";

	}

	@RequestMapping(value = "/admin/deletecategory/{id}")
	public String deletecategory(@PathVariable("id") String id, Model model) {
		Category c = categoryDao.getCategory(id);
		if (categoryDao.delete(c) == true) {
			model.addAttribute("message", "Category is successfully deleted");
			return "redirect:/admin/viewcategory";
		} else
			return "redirect:/admin/viewcategory";

	}

	@RequestMapping(value = "/admin/editcategory/{id}")
	public String editcategory(@PathVariable("id") String id, Model model) {
		Category c = categoryDao.getCategory(id);
		model.addAttribute("category", c);
		return "categoryform";
	}
}
