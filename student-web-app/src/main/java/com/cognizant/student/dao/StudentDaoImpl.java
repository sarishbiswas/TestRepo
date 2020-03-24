package com.cognizant.student.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.student.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public String insert(Student student) {
		String sql = "insert into student values(?,?,?)";
		int res=jdbcTemplate.update(sql,new Object[] {student.getId(),student.getFirstName(),student.getLastName()});
		if(res>0)
			return "SUCCESS";
		return "FAIL";
	}
	public String update(Student student) {
		String query = "update student set firstName=?,lastName=? where id=?";
		int res= jdbcTemplate.update(query,student.getFirstName(),student.getLastName(),student.getId());
		if(res>0)
			return "SUCCESS";
		return "FAIL";
	}
	public String delete(Student student) {
		String query = "delete from student where id=?";
		int res= jdbcTemplate.update(query,student.getId());
		if(res>0)
			return "SUCCESS";
		return "FAIL";
	}
	public List<Student> getAll() {
		String query = "select * from student";
		return jdbcTemplate.query(query,
				(rs, rowNum) -> new Student(rs.getString(1), rs.getString(2), rs.getString(3)));
	}
	@Autowired
	public void setJdbcTemplate(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

}
