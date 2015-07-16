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
import com.mum.edu.happycart.mail.MailService;
import com.mum.edu.happycart.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String categoryList(Model model, Category category){
		model.addAttribute("category",category);
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categoryCreate";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String categorySave(@ModelAttribute("category") Category newCategory, 
							   RedirectAttributes redirectAttributes){
		this.categoryService.addCategory(newCategory);
		//this.mailService.sendMail("ketiakem@gmail.com", {"ketiakem@gmail.com"}, "test only", "test only");
		redirectAttributes.addFlashAttribute("message", "Category successfully created.");
		return "redirect:/admin/category/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteCategory(@RequestParam("id") int id,
								RedirectAttributes redirectAttributes){
		this.categoryService.deleteCategoryById(id);
		redirectAttributes.addFlashAttribute("message", "Category successfully deleted.");
		return "redirect:/admin/category/";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String updateCategory(@RequestParam("id") int id, Model model){
		model.addAttribute("category",this.categoryService.getCategoryById(id));
		return "categoryCreate";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String updateCategory(@ModelAttribute("category") Category newCategory,
								RedirectAttributes redirectAttributes){
		this.categoryService.updateCategory(newCategory);
		return "redirect:/admin/category/";
	}
	
	@RequestMapping(value = "/assign", method = RequestMethod.GET)
	public String categoryAssign(Model model, 
								Category category){
		model.addAttribute("category", category);
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categoryAssign";
	}
	
	@RequestMapping(value = "/assign", method = RequestMethod.POST)
	public String categoryAssign(@RequestParam("categoryId") int catId,
								@RequestParam("subCategoryId") int subCatid,
								RedirectAttributes redirectAttributes){

		if(catId > 0 && subCatid > 0  && (catId != subCatid)) {
			Category category = this.categoryService.getCategoryById(catId);
			Category subCategory = this.categoryService.getCategoryById(subCatid);
			
			if(category.getCategory() == null || (category.getCategory() != null && category.getCategory().getId() != subCategory.getId())){
				this.categoryService.addSubCategory(category, subCategory);
				redirectAttributes.addFlashAttribute("message","Successfully added.");
			}
			else
				redirectAttributes.addFlashAttribute("message","Invalid adding.");
		}
		else
			redirectAttributes.addFlashAttribute("message","Invalid adding.");
		return "redirect:/admin/category/assign";
	}
	
	@RequestMapping(value = "/detach", method = RequestMethod.GET)
	public String categoryDetach(@RequestParam("id") int subCatid,
								RedirectAttributes redirectAttributes){
		Category subCategory = this.categoryService.getCategoryById(subCatid);
		if(subCategory != null){
			Category category = subCategory.getCategory();
			this.categoryService.detach(category, subCategory);
			redirectAttributes.addFlashAttribute("message","Successfully added.");
		}
		else
			redirectAttributes.addFlashAttribute("message","Invalid detach.");
		return "redirect:/admin/category/assign";
	}
}
