package com.mum.edu.happycart.service;

import java.util.List;

import com.mum.edu.happycart.domain.Cat;

public interface CatService  {
	public Cat addCategory(Cat cat);
	public Cat getCategoryById(int id);
	public void deleteCategoryById(int id);
	public List<Cat> getAllCategory();
	public List<Cat> getAllSubCategory();
	public List<Cat> getAllMainCategory();
	public Cat updateCategory(Cat updateCat);
	public void addSubCategory(Cat category, Cat subCategory);
}
