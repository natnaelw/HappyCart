package com.mum.edu.happycart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.edu.happycart.domain.Category;
//import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.service.CategoryService;


@Controller
@RequestMapping(value="/category")
public class CategoryController {
	@Autowired
	CategoryService catSer;
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String getAdminPage()
	{
		return "admin";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String GetAllCategory( Category category, Model model){
		model.addAttribute("category",catSer.GetAllCategory());
		return "listCategory";
	}
	@RequestMapping(value="/add", method=RequestMethod.GET)
	
		public String getProduct(Category category , Model model)
		{
		model.addAttribute("category",category);
		return "addProduct";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveCategory(@Valid Category category, BindingResult rt,BindingResult br, RedirectAttributes ra){
		 String view ="redirect:/category/list";
         if(!rt.hasErrors())
         {
        	 ra.addFlashAttribute("message", "Successfully Add new Category");
             catSer.save(category);
            return view; 
         }
         else {
            return  "welcome";
         }
	}

}
