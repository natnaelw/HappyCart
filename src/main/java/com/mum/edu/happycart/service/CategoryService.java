package com.mum.edu.happycart.service;

import java.util.List;

import com.mum.edu.happycart.domain.Category;

public interface CategoryService {

	public List<Category> findAllCategories();
	public List<Category> GetAllCategory();
	public Category save (Category category);
    public Category findCategory(long id);
    
}
