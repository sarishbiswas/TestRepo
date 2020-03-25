package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String insert(Employee employee) {
		return employeeDao.insert(employee);
	}

	@Override
	public String update(Employee employee) {
		return employeeDao.update(employee);
	}

	@Override
	public String delete(Employee employee) {
		return employeeDao.delete(employee);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

}
