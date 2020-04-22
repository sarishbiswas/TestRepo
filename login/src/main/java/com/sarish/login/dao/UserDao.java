package com.sarish.login.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sarish.login.model.User;
@Component
public interface UserDao {

	public List<User> selectAll();
	public boolean check(User user);
}
