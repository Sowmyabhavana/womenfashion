package com.niit.womenfashionFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.womenfashionBackend.Dao.CardDao;
import com.niit.womenfashionBackend.Dao.CartDao;
import com.niit.womenfashionBackend.Dao.CartItemsDao;
import com.niit.womenfashionBackend.Dao.OrderItemsDao;
import com.niit.womenfashionBackend.Dao.OrdersDao;
import com.niit.womenfashionBackend.Dao.PayDao;
import com.niit.womenfashionBackend.Dao.ProductsDao;
import com.niit.womenfashionBackend.Dao.ShippingDao;
import com.niit.womenfashionBackend.Dao.UsersDao;
import com.niit.womenfashionBackend.Model.Card;
import com.niit.womenfashionBackend.Model.Cart;
import com.niit.womenfashionBackend.Model.CartItems;
import com.niit.womenfashionBackend.Model.OrderItems;
import com.niit.womenfashionBackend.Model.Orders;
import com.niit.womenfashionBackend.Model.Pay;
import com.niit.womenfashionBackend.Model.Products;
import com.niit.womenfashionBackend.Model.Shipping;
import com.niit.womenfashionBackend.Model.Users;



//@Controller
public class CheckoutController
{
	@Autowired
	Shipping shipping;
	@Autowired
	ShippingDao shippingDao;
	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;
	@Autowired
	Users users;
	@Autowired
	UsersDao usersDao;
	@Autowired
	Products product;
	@Autowired
	ProductsDao productDao;
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	Card card;
	@Autowired
	CardDao cardDao;
	@Autowired
	Orders orders;
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;




	@RequestMapping(value="/checkout")
	public String checkOut(Model model)
	{
	Shipping s=new Shipping();
	model.addAttribute("shipping",s);
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
	String currentUserName=authentication.getName();
	users=usersDao.getUsersbyemail(currentUserName);
	if(users==null)
	return "redirect:/login";
	else
	{

	model.addAttribute("cart",users.getCart());
	}
	}
	return "checkout";

	}

	@RequestMapping(value="/placeorder")
	public String placeOrder(@RequestParam("payment-method")String payment,@ModelAttribute("shipping")Shipping shipping,Model model)
	{

	this.shipping=shipping;
	if(payment.equalsIgnoreCase("card"))
	{
	System.out.println(1111);
	Card c=new Card();
	Pay pay= new Pay();
	pay.setPaMethod("Card");
	pay.setPayStatus("paid");
	payDao.saveorupdate(pay);
	this.pay=pay;
	model.addAttribute("card",c);
	return "card";
	}
	else
	{
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
	String currentUserName=authentication.getName();
	users=usersDao.getUsersbyemail(currentUserName);
	if(users==null)
	return "redirect:/login";
	else
	{
	System.out.println(123456789);
	Pay pay= new Pay();
	pay.setPaMethod("cash");
	pay.setPayStatus("not paid");
	payDao.saveorupdate(pay);
	shipping.setUsers(users);
	shippingDao.saveorupdate(shipping);
	Orders o=new Orders();
	o.setShipping(shipping);
	o.setPay(pay);
	o.setBilling(users.getBilling());
	o.setGrandtotal(users.getCart().getGrandTotal());
	o.setUsers(users);
	ordersDao.saveorupdate(o);
	List<CartItems> CartItems =cartItemsDao.cartitemslist(users.getCart().getCarId()); 
	              for(CartItems c1:CartItems)
	              {
	              OrderItems oi=new OrderItems();
	              oi.setOrders(o);
	              oi.setProId(c1.getProducts().getProId());
	              orderItemsDao.saveorupdate(oi);
	              this.cart=users.getCart();
	              this.cart.setTotalItems(this.cart.getTotalItems()-1);
	              this.cart.setGrandTotal(this.cart.getGrandTotal()-c1.getPrice());
	              cartItemsDao.delete(c1);
	              cartDao.saveorupdate(this.cart);
	              }
	}
	}
	return "redirect:/confirm";
	}
	}

	@RequestMapping(value="/addCard")
	public String addCard(@ModelAttribute("pay")Pay pay,@ModelAttribute("card")Card card,Model model)
	{

	if(cardDao.saveorupdate(card)==true)
	{
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken))
	{
	String currentUserName=authentication.getName();
	users=usersDao.getUsersbyemail(currentUserName);
	if(users==null)
	return "redirect:/login";
	else
	{
	System.out.println(123456789);
	card.setUsers(users);
	cardDao.saveorupdate(card);
	Orders o=new Orders();
	this.shipping.setUsers(users);
	shippingDao.saveorupdate(this.shipping);
	o.setShipping(this.shipping);
	o.setPay(this.pay);
	o.setBilling(users.getBilling());
	o.setGrandtotal(users.getCart().getGrandTotal());
	o.setUsers(users);
	ordersDao.saveorupdate(o);
	List<CartItems> CartItems =cartItemsDao.cartitemslist(users.getCart().getCarId()); 
	              for(CartItems c1:CartItems)
	              {
	              System.out.println(c1.getCariId());
	              OrderItems oi=new OrderItems();
	              oi.setOrders(o);
	              oi.setProId(c1.getProducts().getProId());
	              System.out.println(c1.getProducts().getProId());
	              orderItemsDao.saveorupdate(oi);
	              this.cart=users.getCart();
	              this.cart.setTotalItems(this.cart.getTotalItems()-1);
	              this.cart.setGrandTotal(this.cart.getGrandTotal()-c1.getPrice());
	              cartItemsDao.delete(c1);
	              cartDao.saveorupdate(this.cart);
	              }             
	}
	}
	return "redirect:/confirm";
	}
	else
	{
	return "redirect:/checkout";
	}
	 }

	@RequestMapping(value="/confirm")
	public String confirm(Model model)
	{
//		List<OrderItems> oi=orderItemsDao.orderitemslist();
//		model.addAttribute("orderItems",oi);
//		Orders o=ordersDao.getOrders(oi);
//		model.addAttribute("orders",o);
	return "confirm";
	}
}

