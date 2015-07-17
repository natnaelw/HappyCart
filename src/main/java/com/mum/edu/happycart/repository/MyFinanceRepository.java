package com.mum.edu.happycart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mum.edu.happycart.domain.MyFinance;
import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.domain.ReportPrdouctFinance;

@Repository
public interface MyFinanceRepository extends CrudRepository<MyFinance, Long> {
	
	
	
	@Query("SELECT i FROM Product i WHERE i.category.id = :categoryId and i.unitPrice <= :price")
	public List<Product> findByFilter(
			@Param(value = "categoryId") Integer categoryId,
			@Param(value = "price") double price);

//	@Query("SELECT DISTINCT  p.name, m.amountSpent,m.happyCartAmount , m.vendorAmount,m.tax FROM myfinance m  JOIN p ON m.product = product")
//	public List<ReportPrdouctFinance> getProductTansaction();
}
