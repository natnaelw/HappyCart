package com.mum.edu.happycart.repository;

import com.mum.edu.happycart.domain.Cart;

public interface CartRepository {

	Cart create(Cart cart);
	
	Cart read(String cartId);
	
	void update(String cartId, Cart cart);
	
	void delete(String cartId);

}
