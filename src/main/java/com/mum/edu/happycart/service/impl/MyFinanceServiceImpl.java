package com.mum.edu.happycart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mum.edu.happycart.domain.CreditCardTransaction;
import com.mum.edu.happycart.domain.MyFinance;
import com.mum.edu.happycart.repository.MyFinanceRepository;
import com.mum.edu.happycart.service.MyFinanceService;
import com.mum.edu.happycart.service.ProductService;

@Service
@Transactional
public class MyFinanceServiceImpl implements MyFinanceService {

	@Autowired
	MyFinanceRepository myFinanceRepo;
	
	@Autowired
	ProductService productService;
	

	
	public void transferToMyFinance(List<CreditCardTransaction> ccTransactionList){
		
		for (CreditCardTransaction creditCardTransaction : ccTransactionList) {
			MyFinance myFinance = new MyFinance();
			myFinance.setAmountSpent(creditCardTransaction.getAmountSpent());
			myFinance.setCreditCardNumber(creditCardTransaction.getCreditCardNumber());
			myFinance.setHappyCartAmount(creditCardTransaction.getHappyCartAmount());
			myFinance.setProduct(creditCardTransaction.getProduct());
			myFinance.setPurchaseDate(creditCardTransaction.getPurchaseDate());
			myFinance.setReceiptNumber(creditCardTransaction.getReceiptNumber());
			myFinance.setTax(creditCardTransaction.getTax());
			myFinance.setVendorAmount(creditCardTransaction.getVendorAmount());
			myFinance.setProductname(productService.getProductById(Long.parseLong(creditCardTransaction.getProduct())).getName());
			myFinanceRepo.save(myFinance);
		}
	}



	@Override
	public List<MyFinance> getAllTransactions() {
	 
		return (List<MyFinance>)myFinanceRepo.findAll();
		
	}
	
}
