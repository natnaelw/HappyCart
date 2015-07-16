package com.mum.edu.happycart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mum.edu.happycart.domain.Category;
import com.mum.edu.happycart.domain.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	public Product getProductById(long id);
	
	
	
	
//	@Query("SELECT i FROM Product i WHERE i.category.id = :categoryId and i.itemCondition = :condition and i.unitPrice <= :price")
//	public List<Product> findByFilter(
//			@Param(value = "categoryId") Long categoryId,
//			@Param(value = "condition") String condition,
//			@Param(value = "price") double price);

}
