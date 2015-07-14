package com.mum.edu.happycart.service;

import java.util.List;

import com.mum.edu.happycart.domain.SubCategory;

public interface SubCategoryService {
	public SubCategory getSubCategoryById(int id);
	public List<SubCategory> getAllSubCategory();
	public SubCategory save(SubCategory subcategory);
}
