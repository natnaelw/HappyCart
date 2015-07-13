package com.mum.edu.happycart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.SubCategory;
import com.mum.edu.happycart.repository.SubCategoryRepository;
import com.mum.edu.happycart.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Override
	public SubCategory getSubCategoryById(Long id) {
		return this.subCategoryRepository.findOne(id);
	}

	@Override
	public List<SubCategory> getAllSubCategory() {
		return (List<SubCategory>)this.subCategoryRepository.findAll();
	}
	

	@Override
	public SubCategory save(SubCategory subcategory) {
		// TODO Auto-generated method stub
		return subCategoryRepository.save(subcategory);
	}


	
}
