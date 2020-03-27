package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentService;

@Controller
public class AppController {
	
	@Autowired
	StudentService studentService;
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mv =new ModelAndView("hello");
		return mv;
	}
	
	@RequestMapping(value="insert",method=RequestMethod.GET)
	public ModelAndView insert1() {
		ModelAndView mv =new ModelAndView("insert");
		Student student = new Student();
		mv.addObject("student",student);
		return mv;
	}
	@RequestMapping(value="insert",method=RequestMethod.POST)
	 public ModelAndView insert(@ModelAttribute("student") Student student ) {
	  System.out.println("Model Attribute:"+student);
	  String res=studentService.insert(student);
	  System.out.println(res);
	  List<Student> list = studentService.getAll();
	  ModelAndView mv = new ModelAndView("getAll");
	  mv.addObject("students",list);
	  mv.addObject("res",res+" Insert.");
	  return mv;
	 }
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public ModelAndView update1() {
		ModelAndView mv =new ModelAndView("update");
		Student student = new Student();
		mv.addObject("student",student);
		return mv;
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	 public ModelAndView update(@ModelAttribute("student") Student student ) {
	  System.out.println("Model Attribute:"+student);
	  //ModelAndView mv = new ModelAndView("update");
	  String res=studentService.update(student);
	  System.out.println(res);
	  List<Student> list = studentService.getAll();
	  ModelAndView mv = new ModelAndView("getAll");
	  mv.addObject("students",list);
	  mv.addObject("res",res+" Update");
	  return mv;
	 }
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public ModelAndView delete1() {
		ModelAndView mv =new ModelAndView("delete");
		Student student = new Student();
		mv.addObject("student",student);
		return mv;
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	 public ModelAndView delete(@ModelAttribute("student") Student student ) {
	  System.out.println("Model Attribute:"+student);
	 // ModelAndView mv = new ModelAndView("delete");
	  String res=studentService.delete(student);
	  System.out.println(res);
	  List<Student> list = studentService.getAll();
	  ModelAndView mv = new ModelAndView("getAll");
	  mv.addObject("students",list);
	  mv.addObject("res",res+" Delete");
	  return mv;
	 }
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView showall() {
		ModelAndView mv =new ModelAndView("getAll");
		List<Student> list = studentService.getAll();
		mv.addObject("students",list);
		mv.addObject("res","getAll Method Execution");
		return mv;
	}	
	
	@RequestMapping(value="countStudent",method=RequestMethod.GET)
	public ModelAndView countStudents() {
		ModelAndView mv =new ModelAndView("countStudent");
		int c=studentService.countStudents();
		mv.addObject("count",c);
		return mv;
	}
	
	@RequestMapping(value="getByName",method=RequestMethod.GET)
	public ModelAndView getByName1() {
		ModelAndView mv =new ModelAndView("getByName");
		Student student = new Student();
		mv.addObject("student",student);
		return mv;
	}
	@RequestMapping(value="getByName",method=RequestMethod.POST)
	 public ModelAndView getByName(@ModelAttribute("student") Student student ) {
	  System.out.println("Model Attribute:"+student);
	  //ModelAndView mv = new ModelAndView("getAll");
	  ModelAndView mv = new ModelAndView("getAll");
	  List<Student> students=studentService.getByName(student);
	  System.out.println(students);
	  mv.addObject("students",students);
	  return mv;
	 }
}
