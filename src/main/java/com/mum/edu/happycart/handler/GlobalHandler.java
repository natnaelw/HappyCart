package com.mum.edu.happycart.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mum.edu.happycart.domain.Category;
import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.service.CategoryService;
import com.mum.edu.happycart.service.ProductService;

/**
 * Contains Exception Handler methods
 * @author NatnaelW
 *
 */
@ControllerAdvice
public class GlobalHandler {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;

	@ModelAttribute("categories")
	public List<Category> intializeModel(Model model){
		return categoryService.findAllCategories();
	}

	@ModelAttribute("products")
	public List<Product> intializeModelProduct(Model model){
		return productService.findAll();
	}
	
}
