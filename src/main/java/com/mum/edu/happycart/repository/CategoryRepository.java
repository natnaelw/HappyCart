package com.mum.edu.happycart.repository;

import org.springframework.data.repository.CrudRepository;

import com.mum.edu.happycart.domain.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {

}
