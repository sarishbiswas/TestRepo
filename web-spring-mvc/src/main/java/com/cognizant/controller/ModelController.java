package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class ModelController {

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String sayHelloGet(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		System.out.println(id);
		return "hello";
	}

}
