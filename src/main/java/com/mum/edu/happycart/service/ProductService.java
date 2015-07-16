package com.mum.edu.happycart.service;

import java.util.List;

import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.domain.SearchDto;




public interface ProductService {
	
	public Product getProductById(long id);
	
	public void deleteProductById(long id);
		
	public void save(Product product);
	
	public List<Product> findAll();
	
	public List<Product> getAllProducts();
	
	public Product findOne(long productid);
			
//	public List<Product> getProductBySubCategory(SubCategory subcategory);
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Product product);
	
	
	public List<Product> findByFilter(SearchDto searchDto);
	

}
