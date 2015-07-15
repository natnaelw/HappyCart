package com.mum.edu.happycart.service;

import java.util.List;

import com.mum.edu.happycart.domain.Category;

public interface CategoryService  {
	public Category addCategory(Category cat);
	public Category getCategoryById(int id);
	public void deleteCategoryById(int id);
	public List<Category> getAllCategory();
	public List<Category> getAllSubCategory();
	public List<Category> getAllMainCategory();
	public Category updateCategory(Category updateCat);
	public void addSubCategory(Category category, Category subCategory);
}
