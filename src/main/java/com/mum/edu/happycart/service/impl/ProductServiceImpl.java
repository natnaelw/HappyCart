package com.mum.edu.happycart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.domain.SubCategory;
import com.mum.edu.happycart.repository.ProductRepository;
import com.mum.edu.happycart.service.ProductService;

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
		currentProduct.setSubcategory(updateProduct.getSubcategory());
		currentProduct.setUnitInStock(updateProduct.getUnitInStock());
		currentProduct.setUnitPrice(updateProduct.getUnitPrice());
		this.productRepository.save(currentProduct);
		return null;
	}


//	@Override
	//public List<Product> getProductBySubCategory(SubCategory subcategory) {
		// TODO Auto-generated method stub
	//	return productRepository.getProductBySubCategory(subcategory);
	//}
		
	
}
