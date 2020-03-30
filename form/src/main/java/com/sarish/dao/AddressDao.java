package com.sarish.dao;

import java.util.List;

import com.sarish.model.Address;

public interface AddressDao {
	public int insert(Address address);
	public int update(Address address);
	public int delete(Address address);
	public List<Address> getAll();

}
