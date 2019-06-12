package com.niit.womenfashionFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.womenfashionBackend.Dao.BillingDao;
import com.niit.womenfashionBackend.Dao.CartDao;
import com.niit.womenfashionBackend.Dao.UsersDao;
import com.niit.womenfashionBackend.Model.Authentication;
import com.niit.womenfashionBackend.Model.Billing;
import com.niit.womenfashionBackend.Model.Cart;
import com.niit.womenfashionBackend.Model.Users;
@Controller
public class UsersController {


@Autowired
Users users;
@Autowired
UsersDao usersDao;
@Autowired
Billing billing;
@Autowired
BillingDao billingDao;
@Autowired
Cart cart;
@Autowired
CartDao cartDao;
@Autowired
Authentication authentication;

@RequestMapping(value="/register",method=RequestMethod.GET)
public String users(Model model)
{
	System.out.println(1234455678);
	Users u=new Users();
	Billing b=new Billing();
	u.setBilling(b);
	model.addAttribute("register",u);
	return "registerform";
}


@RequestMapping(value="/addUsers",method=RequestMethod.POST)
public String addUsers(@ModelAttribute("register") Users users,Model model)
{
	  
	if (users.getCart()==null)
	{
		users.setCart(new Cart());
		Authentication a= new Authentication();
		a.setUserName(users.getUseEmailId());
		users.setAuthentication(a);
		if(usersDao.saveorupdate(users)==true)
		{
			Users u=new Users();
			model.addAttribute("login",u);
			List<Users> userss=usersDao.userslist();
		    model.addAttribute("login",userss);
			model.addAttribute("mess", "saved successful");
			return "login";   	
		}
		else {
			if(usersDao.saveorupdate(users)==true)
			{
			Users u=new Users();
			model.addAttribute("register",u);
			List<Users> userss=usersDao.userslist();
		    model.addAttribute("registers",userss);
			model.addAttribute("mess", "saved successful");
			return null;
			}
		}
	}
	
	else
	{
		model.addAttribute("mess", "Sorry");	
		Users u=new Users();
		model.addAttribute("register",u);
		return "register";
	}
	return "register";
}
}