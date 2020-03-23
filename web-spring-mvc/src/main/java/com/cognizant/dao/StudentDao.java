package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentDao {
	//public String insert(int id,String name);
	//public String update();
	//public String delete();
	public List<Student> getAll();
	public String insert(Student student);
	public String update(int id, String name);
	public String delete(int id);

}
