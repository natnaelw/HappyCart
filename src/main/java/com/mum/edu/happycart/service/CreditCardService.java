package com.mum.edu.happycart.service;

import com.mum.edu.happycart.domain.CreditCard;

public interface CreditCardService {
  
	public CreditCard findCreditCard(String creditCardNumber);
	public void saveCreditCard(CreditCard creditCard);
}
