package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public String insert(Student student) {
		// TODO Auto-generated method stub
		String sql="insert into student values(?,?,?)";
		int res = jdbcTemplate.update(sql, student.getId(),student.getName(),student.getAddress());
		if(res>0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public String update(Student student) {
		String sql="update student set name=?,address=? where id=?";
		int res = jdbcTemplate.update(sql, student.getName(),student.getAddress(),student.getId());
		if(res>0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public String delete(Student student) {
		String sql="delete from student where id=?";
		int res = jdbcTemplate.update(sql, student.getId());
		if(res>0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public List<Student> getAll() {
		String sql = "select * from student";
		return jdbcTemplate.query(sql, (rs,row)->new Student(rs.getInt(1),rs.getString(2),rs.getString(3)));
	}

	@Override
	public List<Student> getByName(Student student) {
		String sql = "select * from student where name=?";
		return jdbcTemplate.query(sql, new Object[] {student.getName()}, (rs,row)->new Student(rs.getInt(1),rs.getString(2),rs.getString(3)));
		//return jdbcTemplate.query(sql, (rs,row)->new Student(rs.getInt(1),rs.getString(2),rs.getString(3)));
	}

	@Override
	public int countStudents() {
		return getAll().size();
	}

}
