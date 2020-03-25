package com.cognizant.service;

import java.util.List;

import com.cognizant.model.Employee;

public interface EmployeeService {
	public String insert(Employee employee);
	public String update(Employee employee);
	public String delete(Employee employee);
	public List<Employee> getAll();

}
