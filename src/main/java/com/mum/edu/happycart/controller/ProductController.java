package com.mum.edu.happycart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.edu.happycart.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String displayProducts(Model model){
		System.out.println(productService.findAll());
		model.addAttribute("products", productService.findAll());
		return "products";
	}

}
