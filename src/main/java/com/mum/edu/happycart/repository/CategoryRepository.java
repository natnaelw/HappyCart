package com.mum.edu.happycart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mum.edu.happycart.domain.Category;
/**
 * 
 * @author Ketia
 *
 */
public interface CategoryRepository extends CrudRepository<Category,Integer> {
	@Query("SELECT c FROM Category c WHERE c.category is not null")
	public List<Category> getAllSubCategory();
	
	@Query("SELECT c FROM Category c WHERE c.category is null")
	public List<Category> getAllMainCategory();
}
