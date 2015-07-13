package com.mum.edu.happycart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.edu.happycart.domain.Category;
import com.mum.edu.happycart.domain.SubCategory;
import com.mum.edu.happycart.service.CategoryService;
import com.mum.edu.happycart.service.impl.SubCategoryServiceImpl;
@Controller
@RequestMapping(value="/subcategory")
public class SubCategoryController {
 @Autowired
 private SubCategoryServiceImpl subCategoryServiceImpl;
 @Autowired
 private CategoryService CatSer;
 
 @ModelAttribute("category")
 public List<Category> getAllCategory(){
 return CatSer.GetAllCategory();
 
 }	
 @RequestMapping(value="/list", method=RequestMethod.GET)
	public String GetAllCategory( Model model){
		model.addAttribute("subcategory",subCategoryServiceImpl.getAllSubCategory());
		return "listsubcategory";
	}
 @RequestMapping(value="/add",method=RequestMethod.GET)
 public String getAllSubCat(SubCategory subcategory, Model model){
	model.addAttribute("subcategory",subcategory);
	 return "addsubcategory";
 }
 @RequestMapping(value="/add",method=RequestMethod.POST)
 public String addSubcategory(@ModelAttribute("subcategory")SubCategory subcategory, BindingResult rt,RedirectAttributes ra){
	 
	String view ="redirect:/subcategory/list";
	 
    if(!rt.hasErrors())
    {
    	ra.addFlashAttribute("message", "Successfully Added New Sub Category");
//         System.out.println("----------this page");
//        return "addsubcategory"; 
//     
     
    	subCategoryServiceImpl.save(subcategory);
	
	 System.out.println("----------this page-------");
	      return view;
 }
    else {
   	  
       return  "subcategory/add";
//     
//}
 }
 }
}
 
// @RequestMapping(value="/detail",method=RequestMethod.GET)
// public String detailof(@ModelAttribute("subcategory") SubCategory subcategory)
// {
//	 return "subdetails";
// }
// 
 

