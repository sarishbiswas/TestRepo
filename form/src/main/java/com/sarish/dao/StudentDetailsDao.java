package com.sarish.dao;

import java.util.List;

import com.sarish.model.StudentDetails;

public interface StudentDetailsDao {
	public String insert(StudentDetails sd);
	public String update(StudentDetails sd);
	public String delete(StudentDetails sd);
	public List<StudentDetails> getAll();

}
