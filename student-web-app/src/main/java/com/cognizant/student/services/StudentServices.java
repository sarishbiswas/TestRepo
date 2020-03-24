package com.cognizant.student.services;

import java.util.List;

import com.cognizant.student.model.Student;

public interface StudentServices {
	
	public String insert(Student student);

	public String update(Student student);

	public String delete(Student student);

	public List<Student> getAll();

}
