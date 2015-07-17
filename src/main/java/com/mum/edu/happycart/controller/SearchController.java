package com.mum.edu.happycart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.domain.SearchDto;
import com.mum.edu.happycart.service.CategoryService;
import com.mum.edu.happycart.service.ProductService;



/**
 * @author Na2
 *
 */



@Controller
public class SearchController {

	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;


	
	@RequestMapping("/search")
	public String search(Model model,@ModelAttribute Product product,@ModelAttribute("searchDto")SearchDto searchDto){
		return "search";
	}
	
	
	@RequestMapping(value = "/searchByCategory")
	public String getItemsByCategory(Model model,
			@RequestParam("categoryId") String categoryId) {

		model.addAttribute("items",
				productService.getProductsByCategory(Integer.parseInt(categoryId)));
		return "searchedItems";
	}

	@RequestMapping(value = "/search" , method = RequestMethod.POST)
	public String getItemsByCriteria(
			@ModelAttribute("searchDto") SearchDto searchDto,BindingResult result,
			Model model) {
		
		System.out.println("*--"+searchDto.getCategory()+"--"+searchDto.getPrice()+"--"+searchDto.getItemCondition());
		if(result.hasErrors()){
			return "search";
		}

		model.addAttribute("items",productService.findByFilter(searchDto));
		model.addAttribute("messageNoProductFound","The Search Criteria provided didn't return any Item.Try other comibination");

		return "search";
	}
	
//	// REST
//		@RequestMapping(value = "/get/categories", method = RequestMethod.GET, headers = "Accept=application/json", produces = { MediaType.APPLICATION_JSON_VALUE })
//		@ResponseStatus(HttpStatus.OK)
//		public @ResponseBody List<String> getManufacturer() {
//			List<String> categories = new ArrayList<String>();
//			categories.add("Google");
//			categories.add("IBM");
//			categories.add("Yahoo");
//		
//			return categories;
//			//	return categoryService.findAll();
//		}
//
//		@RequestMapping(value ="/get/items/{categoryId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = { MediaType.APPLICATION_JSON_VALUE })
//		@ResponseStatus(HttpStatus.OK)
//		public @ResponseBody List<String> getCategory(
//				@PathVariable("categoryId") String categoryId) {
//			
//			List<String> items = new ArrayList<String>();
//			items.add("glass");
//			items.add("text");
//			items.add("jamboo");
//			
//			return items;
//			
//			//return itemService.findItemsByCategory(Long.parseLong(categoryId));
//		}
//		
   
//	@ModelAttribute
//	public void init(Model model){
//		model.addAttribute("items",itemService.findAll());
//		model.addAttribute("categories",categoryService.findAll());
//	}
	
}
