package com.mum.edu.happycart.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cat {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cat cat;
	
	@OneToMany(mappedBy="cat" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Cat> subCat;
	
	@OneToMany(mappedBy="cat", orphanRemoval = false )
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
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	public List<Cat> getSubCat() {
		return subCat;
	}
	public void setSubCat(List<Cat> subCat) {
		this.subCat = subCat;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public boolean isMainCat() {
		if(this.cat == null) return true;
		return false;
	}
	
	public void AddSubCategory(Cat category){
		if(category != null) this.subCat.add(category);
	}
}
