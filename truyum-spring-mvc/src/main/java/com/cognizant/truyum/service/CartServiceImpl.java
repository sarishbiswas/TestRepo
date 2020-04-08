package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao cartDao;
	
	@Override
	public void addToCart(long userId,long menuItemId) {
		cartDao.addCartItem(userId, menuItemId);
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		return cartDao.getAllCartItems(userId);
	}

	@Override
	public void removeCartItem(int i, long menuItemId) {
		System.out.println("Inside service");
		cartDao.removeCartItem(i, menuItemId);
	}

}
