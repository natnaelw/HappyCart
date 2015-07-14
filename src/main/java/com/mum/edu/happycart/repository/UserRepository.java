package com.mum.edu.happycart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.edu.happycart.domain.Credentials;
import com.mum.edu.happycart.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public User getUserBycredentials(Credentials userCredntials);
	
}
