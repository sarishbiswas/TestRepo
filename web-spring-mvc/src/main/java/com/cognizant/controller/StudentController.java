package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

@Controller
public class StudentController {
	@Autowired
	StudentDao student = new StudentDaoImpl();

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String sayHello() {
		return "insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String msg = student.insert(new Student(id, name));
		request.setAttribute("msg", msg);
		return "insert";
	}
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String sayHello1() {
		return "update";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String msg = student.update(id, name);
		request.setAttribute("msg", msg);
		return "update";
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete1() {
		return "delete";
	}
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String msg = student.delete(id);
		request.setAttribute("msg", msg);
		return "delete";
	}

	@RequestMapping(value = "getAll", method = {RequestMethod.POST,RequestMethod.GET})
	public String getAll(HttpServletRequest request) {
		List<Student> s = student.getAll();
		request.setAttribute("list", s);
		System.out.println(s);
		return "getAll";
	}

}
