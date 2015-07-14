package com.mum.edu.happycart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mum.edu.happycart.domain.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard,Long> {

	//@Query("SELECT i FROM CreditCard i WHERE i.number = :crediCardNumber")
	public CreditCard findByNumber(String creditCardNumber);
	
}
