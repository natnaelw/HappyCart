package com.mum.edu.happycart.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 * 
 * @author Ketia
 *
 */
@Entity
public class Category {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	@OneToMany(mappedBy="category" , fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Category> subCategory;
	
	@OneToMany(mappedBy="category", orphanRemoval = false, fetch = FetchType.EAGER)
	private List<Product> products;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(List<Category> subCategory) {
		this.subCategory = subCategory;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public boolean isMainCat() {
		if(this.category == null) return true;
		return false;
	}
	
	public void AddSubCategory(Category category){
		if(category != null) this.subCategory.add(category);
	}
}
