package com.mum.edu.happycart.service.impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.Category;
import com.mum.edu.happycart.repository.CatRepository;
import com.mum.edu.happycart.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CatRepository catRepository;
	
	@Override
	public Category addCategory(Category cat) {
		this.catRepository.save(cat);
		return cat;
	}

	@Override
	public Category getCategoryById(int id) {
		return this.catRepository.findOne(id);
	}

	@Override
	public void deleteCategoryById(int id) {
		this.catRepository.delete(id);
		
	}

	@Override
	public List<Category> getAllCategory() {
		return (List<Category>)this.catRepository.findAll();
	}

	@Override
	public List<Category> getAllSubCategory() {
		List<Category> cats = (List<Category>)this.catRepository.findAll();
		Category cat = null;
		/*return cats.parallelStream()
				.filter(p -> (!p.isMainCat()))
					.collect(Collectors.toSet());*/
		Iterator<Category> iteratorCats = cats.iterator();
		while(iteratorCats.hasNext()){
			cat = iteratorCats.next();
			if(cat.isMainCat() && cat.getSubCategory().size() == 0) cats.remove(cat);
		}
		return cats;
	}

	@Override
	public Category updateCategory(Category updateCat) {
		Category currentCat = this.catRepository.findOne(updateCat.getId());
		currentCat.setName(updateCat.getName());
		this.catRepository.save(currentCat);
		return currentCat;
	}

	@Override
	public List<Category> getAllMainCategory() {
		List<Category> cats = (List<Category>)this.catRepository.findAll();
		Category cat = null;
		/*return cats.parallelStream()
				.filter(p -> (p.isMainCat()))
					.collect(Collectors.toSet());*/
		Iterator<Category> iteratorCats = cats.iterator();
		while(iteratorCats.hasNext()){
			cat = iteratorCats.next();
			if(!cat.isMainCat()) cats.remove(cat);
		}
		return cats;
	}

	@Override
	public void addSubCategory(Category category, Category subCategory) {
		category.AddSubCategory(subCategory);
		subCategory.setCategory(category);
		this.catRepository.save(category);
		this.catRepository.save(subCategory);
	}

	@Override
	public void detach(Category category, Category subCategory) {
		category.getSubCategory().remove(subCategory);
		subCategory.setCategory(null);
		this.catRepository.save(category);
		this.catRepository.save(subCategory);
	}
}
