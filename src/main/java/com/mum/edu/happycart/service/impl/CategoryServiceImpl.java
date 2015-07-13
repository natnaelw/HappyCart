package com.mum.edu.happycart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.Category;
import com.mum.edu.happycart.repository.CategoryRepository;
import com.mum.edu.happycart.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> findAllCategories() {
		return (List<Category>)categoryRepository.findAll();
	}

	@Override
	public List<Category> GetAllCategory() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category findCategory(long id) {
		return categoryRepository.findOne(id);
	}


}
