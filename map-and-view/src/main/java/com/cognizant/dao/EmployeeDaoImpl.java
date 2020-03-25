package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String insert(Employee employee) {
		String sql = "insert into employee values(?,?)";
		int res = jdbcTemplate.update(sql, employee.getId(), employee.getName());
		if (res > 0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public String update(Employee employee) {
		String sql = "update employee set name=? where id=?";
		int res = jdbcTemplate.update(sql, employee.getName(), employee.getId());
		if (res > 0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public String delete(Employee employee) {
		String sql = "delete from employee where id=?";
		int res = jdbcTemplate.update(sql, employee.getId());
		if (res > 0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public List<Employee> getAll() {
		String sql = "select * from employee";
		List<Employee> list = jdbcTemplate.query(sql, (rs, rowNum) -> new Employee(rs.getString(1), rs.getString(2)));
		return list;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
