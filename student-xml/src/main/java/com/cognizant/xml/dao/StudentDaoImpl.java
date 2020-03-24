package com.cognizant.xml.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.xml.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	public List<Student> list = new ArrayList<Student>();
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String insert(Student student) {
		// TODO Auto-generated method stub
		int s = jdbcTemplate.update("insert into student values(?,?)", student.getId(), student.getName());
		if (s > 0)
			return "SUCCESS";
		return "FAIL";
	}

	public String update(Student student) {
		// TODO Auto-generated method stub
		int res = jdbcTemplate.update("update student set name=? where id=?", student.getName(), student.getId());
		if (res> 0)
			return "SUCCESS";
		return "FAIL";
	}

	public String delete(Student student) {
		// TODO Auto-generated method stub
		int res = jdbcTemplate.update("delete from student where id=?",student.getId());
		if (res> 0)
			return "SUCCESS";
		return "FAIL";
	}

	public List<Student> getAll() {
		return jdbcTemplate.query("select * from student", (rs, row) -> new Student(rs.getString(1), rs.getString(2)));
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
