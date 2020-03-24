package com.cognizant.student.dao;

import java.util.List;

import com.cognizant.student.model.Student;

public interface StudentDao {
	public String insert(Student student);

	public String update(Student student);

	public String delete(Student student);

	public List<Student> getAll();
	
}
