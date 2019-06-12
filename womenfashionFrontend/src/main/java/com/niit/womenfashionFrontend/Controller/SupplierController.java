package com.niit.womenfashionFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.womenfashionBackend.Dao.SupplierDao;
import com.niit.womenfashionBackend.Model.Category;
import com.niit.womenfashionBackend.Model.Supplier;


@Controller
public class SupplierController
{
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao; 
	
	@RequestMapping(value="/admin/supplier",method=RequestMethod.GET)
	public String supplier(Model model)
	{
		Supplier c=new Supplier();
	    
		model.addAttribute("supplier",c);
		
		return "supplierform";
	}
	@RequestMapping(value="/admin/addSupplier",method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier,Model model)
	{
		if(supplierDao.saveorupdate(supplier)==true)
		{
			Supplier c=new Supplier();
			model.addAttribute("supplier",c);
			List<Supplier> suppliers=supplierDao.supplierlist();
		    model.addAttribute("suppliers",suppliers);
			model.addAttribute("mess", "saved successful");
		    return "redirect:/admin/viewsupplier";
		}
		else
		{
			model.addAttribute("mess", "Sorry");	
			Supplier c=new Supplier();
			model.addAttribute("supplier",c);
			return "supplierform";
		}
		
	}
//	@RequestMapping(value="/admin/viewsupplier",method=RequestMethod.GET)
//	public String viewListSupplier(Model model)
//	{
//			List<Supplier> suppliers=supplierDao.supplierlist();
//		    model.addAttribute("suppliers",suppliers);
//		    return "redirect:/admin/viewsuppliers";
//		
//	}
	
	@RequestMapping(value="/admin/viewsupplier")
	public String viewsupplier(Model model)
	{
		List<Supplier> suppliers=supplierDao.supplierlist();
		model.addAttribute("suppliers",suppliers);
		return "viewsupplier";
		
	}
	@RequestMapping(value = "/admin/deletesupplier/{id}")
	public String deletesupplier(@PathVariable("id") String id, Model model) {
		Supplier c =supplierDao.getSupplier(id);
		if (supplierDao.delete(c) == true) {
			model.addAttribute("message", "Category is successfully deleted");
			return "redirect:/admin/viewsupplier";
		} else
			return "redirect:/admin/viewsupplier";

	}

	@RequestMapping(value = "/admin/editsupplier/{id}")
	public String editsupplier(@PathVariable("id") String id, Model model) {
		Supplier c = supplierDao.getSupplier(id);
		model.addAttribute("supplier", c);
		return "supplierform";
	}
}
