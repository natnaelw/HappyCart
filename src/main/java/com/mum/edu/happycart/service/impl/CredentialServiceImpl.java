package com.mum.edu.happycart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.Credentials;
import com.mum.edu.happycart.repository.CredentialsRepository;
import com.mum.edu.happycart.service.CredentialService;


@Service
public class CredentialServiceImpl implements CredentialService {
	
	
	@Autowired 
	CredentialsRepository credentialRepository;
	
	public Credentials getCredentials(String username) {
		
		return credentialRepository.getCredentialByUsername(username);
	}

}
