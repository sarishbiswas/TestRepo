package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

@Controller
public class AppController {
	@Autowired
	private EmployeeService employeeService;
	
	//Hello Controller
	
	@RequestMapping(value="hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView("hello");
		Employee employee = new Employee();
		mv.addObject("employee", employee);
		return mv;
	}
	@RequestMapping(value="hello", method = RequestMethod.POST)
	public ModelAndView helloEmployee(@ModelAttribute("employee") Employee employee) {

		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("employee1",employee);
		System.out.println(employee);
		return mv;
	}

	//Insert Controller
	
	@RequestMapping(value="insert", method = RequestMethod.GET)
	public ModelAndView insert1() {
		ModelAndView mv = new ModelAndView("insert");
		Employee employee = new Employee();
		mv.addObject("employee", employee);
		return mv;
	}
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("employee") Employee employee) {
		ModelAndView mv = new ModelAndView("home-new");
		String res=employeeService.insert(employee);
		mv.addObject("res",res);
		System.out.println(employee);
		return mv;
	}
	
	
	//Update Controller
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public ModelAndView update1() {
		ModelAndView mv = new ModelAndView("update");
		Employee employee = new Employee();
		mv.addObject("employee", employee);
		return mv;
	}
	@RequestMapping(value="update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("employee") Employee employee) {
		ModelAndView mv = new ModelAndView("home-new");
		String res=employeeService.update(employee);
		mv.addObject("res",res);
		System.out.println(employee);
		return mv;
	}
	
	
	//Delete Controller
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public ModelAndView delete1() {
		ModelAndView mv = new ModelAndView("delete");
		Employee employee = new Employee();
		mv.addObject("employee", employee);
		return mv;
	}
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("employee") Employee employee) {
		ModelAndView mv = new ModelAndView("home-new");
		String res=employeeService.delete(employee);
		mv.addObject("res",res);
		System.out.println(employee);
		return mv;
	}
	
	//getAll Controller
	
	@RequestMapping(value="getAll", method = RequestMethod.GET)
	public ModelAndView getAll(@ModelAttribute("employee") Employee employee) {
		ModelAndView mv = new ModelAndView("getAll");
		List<Employee> list = employeeService.getAll();
		mv.addObject("list",list);
		System.out.println(employee);
		return mv;
	}
	
	//Getter And Setters of jdbc
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
