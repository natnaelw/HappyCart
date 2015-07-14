package com.mum.edu.happycart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mum.edu.happycart.domain.Category;
import com.mum.edu.happycart.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	public Product getProductById(long id);
//	
//	@Query("SELECT p FROM product p where p.category = :category")
//	
	
	//public List<Product> getProductBySubCategory(SubCategory subcategory);
}
