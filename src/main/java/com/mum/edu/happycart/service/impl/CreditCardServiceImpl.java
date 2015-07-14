package com.mum.edu.happycart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.CreditCard;
import com.mum.edu.happycart.repository.CreditCardRepository;
import com.mum.edu.happycart.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {


	@Autowired
	CreditCardRepository creditCardRepo;
	
	public CreditCard findCreditCard(String creditCardNumber) {
		
		return creditCardRepo.findByNumber(creditCardNumber);
	}


	public void saveCreditCard(CreditCard creditCard) {
       creditCardRepo.save(creditCard);
	}
	

}
