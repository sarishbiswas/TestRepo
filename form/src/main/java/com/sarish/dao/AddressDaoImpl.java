package com.sarish.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sarish.model.Address;
@Repository
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Address address) {
		String sql="insert into address values(?,?,?)";
		int res=jdbcTemplate.update(sql,address.getHouseNo(),address.getRoad(),address.getPincode());
		return res;
	}

	@Override
	public int update(Address address) {
		String sql="update address set road=?,pincode=? where houseNo=?";
		int res=jdbcTemplate.update(sql,address.getRoad(),address.getPincode(),address.getHouseNo());
		return res;	
	}

	@Override
	public int delete(Address address) {
		return jdbcTemplate.update("delete from address where houseNo=?",address.getHouseNo());
	}

	@Override
	public List<Address> getAll() {
		String sql="select * from address";
		return jdbcTemplate.query(sql, (rs,row)-> new Address(rs.getInt(1),rs.getString(2),rs.getString(3)));
	}
}