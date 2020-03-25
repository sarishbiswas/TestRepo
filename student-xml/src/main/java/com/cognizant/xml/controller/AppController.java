package com.cognizant.xml.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.xml.model.Student;
import com.cognizant.xml.service.StudentService;

@Controller
public class AppController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="hello",method=RequestMethod.GET)
	public ModelAndView sayHello() {
		ModelAndView mv = new ModelAndView("hello");
		return mv;
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert1() {
		return "insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Student s = new Student(id, name);
		String res = studentService.insert(s);
		System.out.println(s);
		request.setAttribute("res", res);
		return "insert";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update1() {
		return "update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Student s = new Student(id, name);
		String res = studentService.update(s);
		System.out.println(s);
		request.setAttribute("res", res);
		return "update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete1() {
		return "delete";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		Student s = new Student(id, null);
		String res = studentService.delete(s);
		System.out.println(s);
		request.setAttribute("res", res);
		return "delete";
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public String getAll(HttpServletRequest request) {
		List<Student> students = studentService.getAll();
		System.out.println(students);
		request.setAttribute("students", students);
		return "getAll";
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
