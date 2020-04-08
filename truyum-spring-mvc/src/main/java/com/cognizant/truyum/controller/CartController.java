package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired
	MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	@GetMapping(value = "/add-to-cart")
	public String addToCart(@RequestParam long menuItemId,ModelMap model) {
		LOGGER.info("Start");
		cartService.addToCart(1, menuItemId);
		model.addAttribute("addCartStatus",true);
		model.addAttribute("custList", menuItemService.getMenuItemListCustomer());
		LOGGER.info("Stop");
		return "menu-item-list-customer";
	}
	
	@GetMapping(value = "/show-cart")
	public String showCart(@RequestParam long userId,ModelMap model) {
		LOGGER.info("Start");
		List<MenuItem> cartItems=null;
		try {
			cartItems = cartService.getAllCartItems(userId);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double total=0.0;
		for (MenuItem menuItem : cartItems) {
			total+=menuItem.getPrice();
		}
		Cart cart = new Cart(cartItems,total);
		model.addAttribute("cart",cart);
		LOGGER.info("Stop");
		return "cart";
	}
	
	@GetMapping(value = "/remove-cart")
	public String Cart(@RequestParam long menuItemId,ModelMap model) {
		LOGGER.info("Start");
		cartService.removeCartItem(1,menuItemId);
		List<MenuItem> cartItems=null;
		try {
			cartItems = cartService.getAllCartItems(1);
			model.addAttribute("removeCartStatus",true);
			double total=0.0;
			for (MenuItem menuItem : cartItems) {
				total+=menuItem.getPrice();
			}
			if(total==0.0)
				return "cart-empty";
			Cart cart = new Cart(cartItems,total);
			model.addAttribute("cart",cart);
			LOGGER.info("Stop");
			return "cart";
		} catch (CartEmptyException e) {
			LOGGER.info("Stop");
			return "cart-empty";
		}
	}
}
