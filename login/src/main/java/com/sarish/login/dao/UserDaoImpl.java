package com.sarish.login.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sarish.login.model.User;
@Service
public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<User> selectAll() {
		String sql = "select * from login_table";
		return jdbcTemplate.query(sql,(rs,row)->new User(rs.getString(1),rs.getString(2),rs.getString(3)));
	}
	@Override
	public boolean check(User user) {
		List<User> list = selectAll();
		for(User u:list) {
			if(u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword()))
				return true;
		}
		return false;
	}

}
