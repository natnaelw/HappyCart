package com.mum.edu.happycart.service;

import java.util.List;

import com.mum.edu.happycart.domain.CreditCardTransaction;
import com.mum.edu.happycart.domain.MyFinance;

public interface MyFinanceService {

	public void transferToMyFinance(List<CreditCardTransaction> ccTransactionList);
	public List<MyFinance> getAllTransactions();
}
