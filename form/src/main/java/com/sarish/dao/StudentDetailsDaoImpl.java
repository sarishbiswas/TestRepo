package com.sarish.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sarish.model.Address;
import com.sarish.model.StudentDetails;
@Repository
public class StudentDetailsDaoImpl implements StudentDetailsDao {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	@Autowired
	public AddressDao addressDao;

	@Override
	public String insert(StudentDetails sd) {
		String sql="insert into studentDetails values(?,?,?)";
		int res1=jdbcTemplate.update(sql,sd.getId(),sd.getName(),sd.getAddress().getHouseNo());
		int res2=addressDao.insert(sd.getAddress());
		if(res1>0 && res2>0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public String update(StudentDetails sd) {
		String sql="update studentDetails set name=?, houseNo=? where id=?";
		int res1=jdbcTemplate.update(sql,sd.getName(),sd.getAddress().getHouseNo(),sd.getId());
		int res2=addressDao.update(sd.getAddress());
		if(res1>0 && res2>0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public String delete(StudentDetails sd) {
		String sql="delete from studentDetails where id=?";
		int res1=jdbcTemplate.update(sql,sd.getId());
		if(res1>0)
			return "SUCCESS";
		return "FAIL";
	}

	@Override
	public List<StudentDetails> getAll() {
		String sql="select * from studentDetails";
		return jdbcTemplate.query(sql, (rs,row)-> new StudentDetails(rs.getInt(1),rs.getString(2),new Address(rs.getInt(3))));
	}

}
