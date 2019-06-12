package com.niit.womenfashionFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.womenfashionBackend.Dao.CartDao;
import com.niit.womenfashionBackend.Dao.CartItemsDao;
import com.niit.womenfashionBackend.Dao.CategoryDao;
import com.niit.womenfashionBackend.Dao.ProductsDao;
import com.niit.womenfashionBackend.Dao.UsersDao;
import com.niit.womenfashionBackend.Model.Cart;
import com.niit.womenfashionBackend.Model.CartItems;
import com.niit.womenfashionBackend.Model.Category;
import com.niit.womenfashionBackend.Model.Products;
import com.niit.womenfashionBackend.Model.Users;

@Controller
public class CartController {

	@Autowired
	Users user;
	@Autowired
	UsersDao userDao;
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
	Category category;
	@Autowired
	CategoryDao categoryDao;

	@RequestMapping(value = "/cart")
	public String getCartItems(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUsername = authentication.getName();
			System.out.println(currentUsername);
			user = userDao.getUsersbyemail(currentUsername);
			if (user == null)
				return "redirect:/login";
			else {
				List<CartItems> ci = cartItemsDao.cartitemslist(user.getCart().getCarId());
				if (ci == null || ci.isEmpty()) {
					model.addAttribute("mess", "No items addded to cart");
					return "cart";
				}
				model.addAttribute("CartItems", ci);
				model.addAttribute("cart", user.getCart());
			}
		}
		return "cart";
	}

	@RequestMapping(value = "/viewproducts")
	public String getProductByCat(@PathVariable("id") String id, Model model) {
		List<Category> categories = categoryDao.categorylist();
		model.addAttribute("categories", categories);
		List<Products> products = productDao.productslist();
		model.addAttribute("products", products);
		System.out.println(products);
		return "viewproducts";

	}

	@RequestMapping(value = "/addTocart/{ProductId}")
	public String addToCart(@PathVariable("ProductId") String id, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUsername = authentication.getName();
			System.out.println(currentUsername);
			user = userDao.getUsersbyemail(currentUsername);
			if (user == null)
				return "redirect:/login";
			else {
				Cart c = user.getCart();
				System.out.println(c.getCarId());
				product = productDao.getProducts(id);
				CartItems cartItems = new CartItems();
				cartItems.setProducts(product);
				cartItems.setCart(c);
				System.out.println(675543);
				cartItems.setPrice(product.getPrice());
				if (cartItemsDao.saveorupdate(cartItems)) {
					int t = c.getTotalItems() + 1;
					double p = c.getGrandTotal() + product.getPrice();
					c.setGrandTotal(p);
					c.setTotalItems(t);
					cartDao.saveorupdate(c);
				}
				System.out.println(86875);

				return "redirect:/cart";
			}
		}
		return "redirect:/cart";
	}

	@RequestMapping(value = "/remove/cartitems/{cartitemsid}")
	public String removeCartItems(@PathVariable("cartitemsid") String cartitemsid, Model model) {
		CartItems c = cartItemsDao.getCartItems(cartitemsid);
		Cart c1 = c.getCart();
		c1.setGrandTotal(c1.getGrandTotal() - c.getPrice());
		c1.setTotalItems(c1.getTotalItems() - 1);
		cartDao.saveorupdate(c1);
		cartItemsDao.delete(c);
		return "redirect:/cart";
	}

}
