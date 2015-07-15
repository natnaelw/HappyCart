package com.mum.edu.happycart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.edu.happycart.domain.Category;
import com.mum.edu.happycart.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String categoryList(Model model, Category category){
		model.addAttribute("category",category);
		model.addAttribute("categories", catService.getAllCategory());
		return "categoryCreate";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String categorySave(@ModelAttribute("category") Category newCategory, 
							   RedirectAttributes redirectAttributes){
		this.catService.addCategory(newCategory);
		redirectAttributes.addFlashAttribute("message", "Category successfully created.");
		return "redirect:/admin/category/";
	}
	
	@RequestMapping(value = "/assign", method = RequestMethod.GET)
	public String categoryAssign(Model model, 
								Category category){
		model.addAttribute("category", category);
		model.addAttribute("categories", catService.getAllCategory());
		return "categoryAssign";
	}
	
	@RequestMapping(value = "/assign", method = RequestMethod.POST)
	public String categoryAssign(@RequestParam("categoryId") int catId,
								@RequestParam("subCategoryId") int subCatid,
								RedirectAttributes redirectAttributes){
		if(catId > 0 && subCatid >0  && (catId != subCatid)) {
			Category category = this.catService.getCategoryById(catId);
			Category subCategory = this.catService.getCategoryById(subCatid);
			this.catService.addSubCategory(category, subCategory);
			redirectAttributes.addFlashAttribute("message","Successfully adding.");
		}
		else
			redirectAttributes.addFlashAttribute("message","Adding failed.");
		return "redirect:/admin/category/assign";
	}
}
