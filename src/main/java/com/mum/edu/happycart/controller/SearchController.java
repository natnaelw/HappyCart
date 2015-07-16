//package com.mum.edu.happycart.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//
///**
// * @author Na2
// *
// */
//
//
//@Controller
//public class SearchController {
//
//	
//	@Autowired
//	CategoryService categoryService;
//	
//	@Autowired
//	ProductService itemService;
//
//	
//	@RequestMapping("/search")
//	public String search(Model model,@ModelAttribute Item item){
//		model.addAttribute("items", itemService.findItemsByCategory(Long.parseLong("1")));
//		model.addAttribute("categories", categoryService.findAll());
//		return "search";
//	}
//	
//	
//	@RequestMapping(value = "/searchByCategory")
//	public String getItemsByCategory(Model model,
//			@RequestParam("categoryId") String categoryId) {
//
//		model.addAttribute("items",
//				itemService.findItemsByCategory(Long.parseLong(categoryId)));
//		return "items";
//	}
//
//	@RequestMapping(value = "/searchCriteria", method = RequestMethod.POST)
//	public String getItemsByCriteria(
//			@ModelAttribute("searchDto") SearchDto searchDto,BindingResult result,
//			Model model) {
//		
//		if(result.hasErrors()){
//			return "search";
//		}
//
//		System.out.println("*--"+searchDto.getCategory()+"--"+searchDto.getPrice()+"--"+searchDto.getItemCondition());
//		model.addAttribute("items",itemService.findByFilter(searchDto));
//
//		return "search";
//	}
//	
////	// REST
////		@RequestMapping(value = "/get/categories", method = RequestMethod.GET, headers = "Accept=application/json", produces = { MediaType.APPLICATION_JSON_VALUE })
////		@ResponseStatus(HttpStatus.OK)
////		public @ResponseBody List<String> getManufacturer() {
////			List<String> categories = new ArrayList<String>();
////			categories.add("Google");
////			categories.add("IBM");
////			categories.add("Yahoo");
////		
////			return categories;
////			//	return categoryService.findAll();
////		}
////
////		@RequestMapping(value ="/get/items/{categoryId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = { MediaType.APPLICATION_JSON_VALUE })
////		@ResponseStatus(HttpStatus.OK)
////		public @ResponseBody List<String> getCategory(
////				@PathVariable("categoryId") String categoryId) {
////			
////			List<String> items = new ArrayList<String>();
////			items.add("glass");
////			items.add("text");
////			items.add("jamboo");
////			
////			return items;
////			
////			//return itemService.findItemsByCategory(Long.parseLong(categoryId));
////		}
////		
//   
//	@ModelAttribute
//	public void init(Model model){
//		model.addAttribute("items",itemService.findAll());
//		model.addAttribute("categories",categoryService.findAll());
//	}
//}
