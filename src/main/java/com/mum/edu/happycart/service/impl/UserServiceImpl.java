package com.mum.edu.happycart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.User;
import com.mum.edu.happycart.repository.CredentialsRepository;
import com.mum.edu.happycart.repository.UserRepository;
import com.mum.edu.happycart.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	CredentialsRepository credentialRepository;
	
	@Autowired
	UserRepository userRepository;

	public void addNewUser(User user){
		
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println("-----"+user.getPassword());
//        user.setPassword(encoder.encode("123"));
//		user.getCredentials().setPassword(encoder.encode("123"));
//		user.getCredentials().setVerifyPassword(encoder.encode("123"));
		credentialRepository.save(user.getCredentials());
		userRepository.save(user);
	}


}
