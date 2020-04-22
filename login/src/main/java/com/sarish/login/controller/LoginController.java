package com.sarish.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sarish.login.dao.UserDao;
import com.sarish.login.model.User;
import com.sarish.login.validator.LoginValidator;


@Controller
public class LoginController {
	
	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	UserDao userDao;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(loginValidator);
	}

	@GetMapping("/")
	public String renderLoginPage(ModelMap model) {
		model.addAttribute("user",new User());
		return "login";
	}
	@PostMapping("/validate")
	public String saveRecords(@ModelAttribute("user") @Validated User user,
			BindingResult result,
			Model model ) {
		if(result.hasErrors())
			return "login";
		else {
			System.out.println(user);
			if(userDao.check(user)) {
				model.addAttribute("user",user);
				return "welcome";
			}
			else {
				return "login";
			}
		}
	}
}