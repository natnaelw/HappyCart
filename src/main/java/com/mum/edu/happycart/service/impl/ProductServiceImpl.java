package com.mum.edu.happycart.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.domain.SearchDto;
import com.mum.edu.happycart.repository.ProductRepository;
import com.mum.edu.happycart.repository.UserRepository;
import com.mum.edu.happycart.service.ProductService;
import com.mum.edu.happycart.service.UserService;

/**
 * Product Service
 * @author NatnaelW
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Delegates getProductById to ProductRepository, returns Product object
	 */
	@Override
	public Product getProductById(long id) {
		return productRepository.getProductById(id);
	}


	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	
	@Override
	public List<Product> findAll() {
		return (List<Product>)productRepository.findAll();
	}

	
	@Override
	public Product findOne(long productid) {
		return productRepository.findOne(productid);
	}


	@Override
	public void deleteProductById(long id) {
		this.productRepository.delete(id);
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return (List<Product>)this.productRepository.findAll();
	}


	@Override
	public Product addProduct(Product product) {
		this.productRepository.save(product);
		return product;
	}


	@Override
	public Product updateProduct(Product updateProduct) {
		Product currentProduct = this.productRepository.getProductById(updateProduct.getId());
		currentProduct.setConditions(updateProduct.getConditions());
		currentProduct.setDescription(updateProduct.getDescription());
		currentProduct.setManufacturer(updateProduct.getManufacturer());
		currentProduct.setName(updateProduct.getName());
		currentProduct.setProductImage(updateProduct.getProductImage());
		currentProduct.setCategory(updateProduct.getCategory());
		currentProduct.setUnitInStock(updateProduct.getUnitInStock());
		currentProduct.setUnitPrice(updateProduct.getUnitPrice());
		this.productRepository.save(currentProduct);
		return null;
	}


	@Override
	public void postProductById(long productId, String isPost) {
		Product product = this.productRepository.getProductById(productId);
		product.setPost(isPost);
		this.productRepository.save(product);
	}
//	@Override
	//public List<Product> getProductBySubCategory(SubCategory subcategory) {
		// TODO Auto-generated method stub
	//	return productRepository.getProductBySubCategory(subcategory);
	//}
		
	
	public List<Product> findByFilter(SearchDto filterElements) {
		
		
		return productRepository.findByFilter(
				Integer.parseInt(filterElements.getCategory()),
				Double.parseDouble(filterElements.getPrice()));
	}



  public List<Product> getProductsByCategory(Integer categoryID) {
	
	return productRepository.findItemsByCategory(categoryID);
   }
	
  @Override
	public List<Product> getProductsByUserId(long userId) {
		return this.productRepository.getProductsByUserId(userId);
	}


	@Override
	public List<Product> getProductsByCategoryId(int categoryId) {
		return this.productRepository.getProductsByCategoryId(categoryId);
	}
	
}
