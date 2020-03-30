package com.sarish.service;

import java.util.List;

import com.sarish.model.StudentDetails;

public interface StudentDetailsService {
	
	public String insert(StudentDetails sd);
	public String update(StudentDetails sd);
	public String delete(StudentDetails sd);
	public List<StudentDetails> getAll();

}
