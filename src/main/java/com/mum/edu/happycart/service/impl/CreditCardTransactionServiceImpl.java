package com.mum.edu.happycart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.CreditCardTransaction;
import com.mum.edu.happycart.repository.CreditCardTransactionRepo;
import com.mum.edu.happycart.service.CreditCardTransactionService;

@Service
public class CreditCardTransactionServiceImpl implements CreditCardTransactionService {

	@Autowired 
	CreditCardTransactionRepo ccTransactionRepo;
	
	public void saveCreditCardTransaction(CreditCardTransaction ccTransaction) {
		ccTransactionRepo.save(ccTransaction);
	}

	

}
