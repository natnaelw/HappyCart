package com.mum.edu.happycart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mum.edu.happycart.service.AppSettingsService;
import com.mum.edu.happycart.service.CategoryService;
import com.mum.edu.happycart.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	AppSettingsService appSettingsService;

	@RequestMapping(value = { "/", "/welcome" })
	public String welcome(Model model) {

		model.addAttribute("greeting",
				appSettingsService.appSettings("HomeAdvert1").getParamValue()
						.toString());
		model.addAttribute("tagline",
				appSettingsService.appSettings("HomeAdvert2").getParamValue()
						.toString());
		return "welcome";
	}

	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
}
