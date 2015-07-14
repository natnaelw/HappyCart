package com.mum.edu.happycart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.Cart;
import com.mum.edu.happycart.repository.CartRepository;
import com.mum.edu.happycart.service.CartService;

/**
 * Cart Service
 * @author NatnaelW
 *
 */
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	/**
	 * Delegates create request to CartRepository, returns Cart object
	 */
	@Override
	public Cart create(Cart cart) {
		return cartRepository.create(cart);
	}

	/**
	 * Delegates read request to CartRepository, returns Cart object
	 */
	@Override
	public Cart read(String cartId) {
		return cartRepository.read(cartId);
	}
	
	/**
	 * Deletes update request to CartRepository, returns void
	 */
	@Override
	public void update(String cartId, Cart cart) {
		cartRepository.update(cartId, cart);
	}

	/**
	 * Delegates delete request to CartRepository, return void
	 */
	@Override
	public void delete(String cartId) {
		cartRepository.delete(cartId);
	}

}
