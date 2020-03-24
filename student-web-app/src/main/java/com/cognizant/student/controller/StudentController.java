package com.cognizant.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.student.model.Student;
import com.cognizant.student.services.StudentServicesImpl;
@Controller
public class StudentController {

	@Autowired
	private StudentServicesImpl studentServices;

	public void setStudentServices(StudentServicesImpl studentServices) {
		this.studentServices = studentServices;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert1() {
		return "insert";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Student s=new Student(id,firstName,lastName);
		System.out.println(s);
		request.setAttribute("msg",studentServices.insert(s));
		return "insert";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update1() {
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Student s=new Student(id,firstName,lastName);
		System.out.println(s);
		request.setAttribute("msg",studentServices.update(s));
		return "update";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete1() {
		return "delete";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		Student s=new Student(id,null,null);
		System.out.println(s);
		String res = studentServices.delete(s);
		System.out.println(res);
		request.setAttribute("msg",res);
		return "delete";
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public String getAll(HttpServletRequest request) {
		List<Student> list = studentServices.getAll();
		System.out.println(list);
		request.setAttribute("list",list);
		return "getAll";
	}


}
