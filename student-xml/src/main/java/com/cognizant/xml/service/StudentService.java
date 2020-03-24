package com.cognizant.xml.service;

import java.util.List;

import com.cognizant.xml.model.Student;

public interface StudentService {
	public String insert(Student student);

	public String update(Student student);

	public String delete(Student student);

	public List<Student> getAll();
}
