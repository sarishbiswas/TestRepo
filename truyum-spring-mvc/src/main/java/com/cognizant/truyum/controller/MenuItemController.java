package com.cognizant.truyum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	MenuItem menuItem;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
		//binder.addValidators(menuItem);
	}
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "/")
	public String heyPage() {
		LOGGER.info("Start");
		System.out.println("deb");
		LOGGER.info("Stop");
		return "hey";
	}

	@GetMapping(value = "/menu-item-list-admin")
	public String showMenuItemListAdmin(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		List<MenuItem> adminList = menuItemService.getMenuItemListAdmin();
		model.addAttribute("adminList", adminList);
		LOGGER.info("Stop");
		return "menu-item-list-admin";
	}

	@GetMapping(value = "/menu-item-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		List<MenuItem> custList = menuItemService.getMenuItemListCustomer();
		model.addAttribute("custList", custList);
		LOGGER.info("Stop");
		return "menu-item-list-customer";
	}

	@GetMapping(value = "/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam long menuItemId, ModelMap model) {
		LOGGER.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		System.out.println("from show edit menu item : "+menuItem);
		Map<String,String> map=getMap();
		model.addAttribute("map", map);
		model.addAttribute("menuItem",menuItem);
		LOGGER.info("Stop");
		return "edit-menu-item";
	}
	@PostMapping("/edit-menu-item")
	public String editMenuItem(@Valid MenuItem menuItems, BindingResult bindingResult) {
		//System.out.println(menuItem);
		System.out.println(menuItems);
		if(bindingResult.hasErrors())
			return "edit-menu-item";
		boolean res = menuItemService.modifyMenuItem(menuItems);
		System.out.println(res);
		return "edit-menu-item-status";
	}
	
	
	
	public Map<String,String> getMap(){
		Map<String,String> map = new HashMap<>();
		map.put("Starters", "Starters");
		map.put("Main Course", "Main Course");
		map.put("Desserts","Desserts");
		map.put("Drinks", "Drinks");
		return map;
	}
}
