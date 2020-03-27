package com.cognizant.service;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentService {

	public String insert(Student student);
	public String update(Student student);
	public String delete(Student student);
	public List<Student> getAll();
	public List<Student> getByName(Student student);
	public int countStudents();
}