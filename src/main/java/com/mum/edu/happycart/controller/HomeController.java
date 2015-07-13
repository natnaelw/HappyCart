package com.mum.edu.happycart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mum.edu.happycart.service.CategoryService;
import com.mum.edu.happycart.service.ProductService;
 
@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;

	
 	@RequestMapping(value={"/","/welcome"})
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Now Free Shipping on orders over $50!");
		model.addAttribute("tagline", "Check our BIG Summer sales!");
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
}
