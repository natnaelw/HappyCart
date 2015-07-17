package com.mum.edu.happycart.service;

import java.util.List;

import com.mum.edu.happycart.domain.Credentials;
import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.domain.User;

public interface UserService {
 
	void addNewUser(User user);
	public User getUserBycredentials(Credentials userCredentials);
	public User getLoggedInUser();
	public User getUserByID(Long id);
	
}
