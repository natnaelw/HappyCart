package com.mum.edu.happycart.service.impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.Category;
import com.mum.edu.happycart.repository.CategoryRepository;
import com.mum.edu.happycart.repository.ProductRepository;
import com.mum.edu.happycart.service.CategoryService;
/**
 * 
 * @author Ketia
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Category addCategory(Category cat) {
		this.categoryRepository.save(cat);
		return cat;
	}

	@Override
	public Category getCategoryById(int id) {
		return this.categoryRepository.findOne(id);
	}

	@Override
	public void deleteCategoryById(int id) {
		this.categoryRepository.delete(id);
		
	}

	@Override
	public List<Category> getAllCategory() {
		return (List<Category>)this.categoryRepository.findAll();
	}

	@Override
	public List<Category> getAllSubCategory() {
		return this.categoryRepository.getAllSubCategory();
	}

	@Override
	public Category updateCategory(Category updateCat) {
		Category currentCat = this.categoryRepository.findOne(updateCat.getId());
		currentCat.setName(updateCat.getName());
		this.categoryRepository.save(currentCat);
		return currentCat;
	}

	@Override
	public List<Category> getAllMainCategory() {
		return this.categoryRepository.getAllMainCategory();
	}

	@Override
	public void addSubCategory(Category category, Category subCategory) {
		category.AddSubCategory(subCategory);
		subCategory.setCategory(category);
		this.categoryRepository.save(category);
		this.categoryRepository.save(subCategory);
	}

	@Override
	public void detach(Category category, Category subCategory) {
		category.getSubCategory().remove(subCategory);
		subCategory.setCategory(null);
		this.categoryRepository.save(category);
		this.categoryRepository.save(subCategory);
	}
}
