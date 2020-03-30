package com.sarish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sarish.model.StudentDetails;
import com.sarish.service.StudentDetailsService;

@Controller
public class AppController {
	
	@Autowired
	public StudentDetailsService studentDetailsService;
	
	@RequestMapping(value="hello", method=RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView("hello");
		return mv;
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public ModelAndView insertPage() {
		ModelAndView mv = new ModelAndView("insert");
		StudentDetails sd=new StudentDetails();
		mv.addObject("sd",sd);
		return mv;
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("sd") StudentDetails sd) {
		System.out.println(sd);
		String res=studentDetailsService.insert(sd);
		System.out.println(res);
		ModelAndView mv = new ModelAndView("getAll");
		List<StudentDetails> students = studentDetailsService.getAll();
		mv.addObject("students",students);
		mv.addObject("res",res);
		return mv;
	}
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView updatePage() {
		ModelAndView mv = new ModelAndView("update");
		StudentDetails sd=new StudentDetails();
		mv.addObject("sd",sd);
		return mv;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("sd") StudentDetails sd) {
		System.out.println(sd);
		String res=studentDetailsService.update(sd);
		System.out.println(res);
		ModelAndView mv = new ModelAndView("getAll");
		List<StudentDetails> students = studentDetailsService.getAll();
		mv.addObject("students",students);
		mv.addObject("res",res);
		return mv;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView deletePage() {
		ModelAndView mv = new ModelAndView("delete");
		StudentDetails sd = new StudentDetails();
		mv.addObject("sd",sd);
		return mv;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("sd") StudentDetails sd) {
		System.out.println("this is: "+sd);
		String res=studentDetailsService.delete(sd);
		//StudentDetails sd = new StudentDetails();
		ModelAndView mv = new ModelAndView("getAll");
		List<StudentDetails> students = studentDetailsService.getAll();
		mv.addObject("students",students);
		mv.addObject("res",res);
		return mv;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getAllPage() {
		ModelAndView mv = new ModelAndView("getAll");
		List<StudentDetails> sd=studentDetailsService.getAll();
		mv.addObject("students",sd);
		return mv;
	}
	

}
