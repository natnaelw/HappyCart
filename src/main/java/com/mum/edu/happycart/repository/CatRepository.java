package com.mum.edu.happycart.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mum.edu.happycart.domain.Category;

@Repository
public interface CatRepository extends CrudRepository<Category, Integer> {

}
