package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public interface CartService {

	public void addToCart(long userId, long menuItemId);

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;

	public void removeCartItem(int i, long menuItemId);

}
