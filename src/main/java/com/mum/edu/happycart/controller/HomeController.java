package com.mum.edu.happycart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HomeController {

	
 	@RequestMapping(value={"/","/welcome"})
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Welcome to HappyCart!");
		model.addAttribute("tagline", "A classified advertisements and shopping website with sections devoted to branded items");

		
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
}
