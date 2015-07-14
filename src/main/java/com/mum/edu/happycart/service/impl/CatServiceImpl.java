package com.mum.edu.happycart.service.impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.Cat;
import com.mum.edu.happycart.repository.CatRepository;
import com.mum.edu.happycart.service.CatService;

@Service
public class CatServiceImpl implements CatService {

	@Autowired
	private CatRepository catRepository;
	
	@Override
	public Cat addCategory(Cat cat) {
		this.catRepository.save(cat);
		return cat;
	}

	@Override
	public Cat getCategoryById(int id) {
		return this.catRepository.findOne(id);
	}

	@Override
	public void deleteCategoryById(int id) {
		this.catRepository.delete(id);
		
	}

	@Override
	public List<Cat> getAllCategory() {
		return (List<Cat>)this.catRepository.findAll();
	}

	@Override
	public List<Cat> getAllSubCategory() {
		List<Cat> cats = (List<Cat>)this.catRepository.findAll();
		Cat cat = null;
		/*return cats.parallelStream()
				.filter(p -> (!p.isMainCat()))
					.collect(Collectors.toSet());*/
		Iterator<Cat> iteratorCats = cats.iterator();
		while(iteratorCats.hasNext()){
			cat = iteratorCats.next();
			if(cat.isMainCat()) cats.remove(cat);
		}
		return cats;
	}

	@Override
	public Cat updateCategory(Cat updateCat) {
		Cat currentCat = this.catRepository.findOne(updateCat.getId());
		currentCat.setName(updateCat.getName());
		this.catRepository.save(currentCat);
		return currentCat;
	}

	@Override
	public List<Cat> getAllMainCategory() {
		List<Cat> cats = (List<Cat>)this.catRepository.findAll();
		Cat cat = null;
		/*return cats.parallelStream()
				.filter(p -> (p.isMainCat()))
					.collect(Collectors.toSet());*/
		Iterator<Cat> iteratorCats = cats.iterator();
		while(iteratorCats.hasNext()){
			cat = iteratorCats.next();
			if(!cat.isMainCat()) cats.remove(cat);
		}
		return cats;
	}

	@Override
	public void addSubCategory(Cat category, Cat subCategory) {
		category.AddSubCategory(subCategory);
		subCategory.setCat(category);
		this.catRepository.save(category);
		this.catRepository.save(subCategory);
	}
}
