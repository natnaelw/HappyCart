package com.mum.edu.happycart.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.edu.happycart.domain.Category;
import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.domain.User;
import com.mum.edu.happycart.service.CategoryService;
import com.mum.edu.happycart.service.ProductService;
import com.mum.edu.happycart.service.UserService;
/**
 * 
 * @author Ketia
 *
 */
@Controller
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"","/list"}, method = RequestMethod.GET)
	public String showProducts(Model model){
		model.addAttribute("products",this.productService.getProductsByUserId(this.getCurrentUserId()));
		return "vendorHome";
	}
	
	@RequestMapping(value = {"/upload"}, method = RequestMethod.GET)
	public String uploadProductsForm(Model model, Product product){
		model.addAttribute("product", product);
		return "vendorProduct";
	}
	
	@RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
	public String uploadProductsSave(@ModelAttribute("product") Product newProduct,
									HttpServletRequest request){
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		String imagePath = "";
		String[] subCategoryIds = request.getParameterValues("subCategoryId");
		if(subCategoryIds.length > 0) newProduct.setCategory(categoryService.getCategoryById(Integer.parseInt(subCategoryIds[0])));
		MultipartFile productImage = newProduct.getProductImage();
		System.out.println("%%%%%%%%%%"+rootDirectory);
		//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				imagePath =  rootDirectory+"\\resources\\images\\"+ newProduct.getId()+ ".png";
				productImage.transferTo(new File(imagePath));
				System.out.println("%%%%%%%%%%"+imagePath);
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed",e);
			}
		}
		newProduct.setUserId(this.getCurrentUserId());
		this.productService.addProduct(newProduct);
		
		return "redirect:/vendor/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteProducts(@RequestParam("id") int id){
		this.productService.deleteProductById(id);
		return "redirect:/vendor/";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String updateProducts(@RequestParam("id") int id, Model model){
		model.addAttribute("product", this.productService.getProductById(id));
		return "vendorProductEdit";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String updateProducts(@ModelAttribute("product") Product newProduct,
									@RequestParam("subCategoryId") int id,
									RedirectAttributes redirectAttribute,
									HttpServletRequest request){
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		String imagePath = "";
		if(id > 0) newProduct.setCategory(categoryService.getCategoryById(id));
		MultipartFile productImage = newProduct.getProductImage();
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				imagePath =  rootDirectory+"\\resources\\images\\"+ newProduct.getId()+ ".png";
				productImage.transferTo(new File(imagePath));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed",e);
			}
		}
		newProduct.setUserId(this.getCurrentUserId());
		productService.updateProduct(newProduct);
		redirectAttribute.addFlashAttribute("message", "Successfully updated item");
		return "redirect:/vendor/";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String postProduct(@RequestParam("id") long id,
							  @RequestParam("isPost") String isPost,
							  RedirectAttributes redirectAttributes){
		this.productService.postProductById(id, isPost.equals("Y") ? "N" : "Y");
		return "redirect:/vendor/";
	}
	
	private User getCurrentUser(){
		return this.userService.getLoggedInUser();
	}
	
	private long getCurrentUserId(){
		return this.getCurrentUser().getId();
	}
}
