package com.mum.edu.happycart.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Product> products;
    

//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
    
    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategory;

	public Category() {
    }
    	
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
