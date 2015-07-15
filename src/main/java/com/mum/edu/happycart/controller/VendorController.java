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

import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.service.CategoryService;
import com.mum.edu.happycart.service.ProductService;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService catService;
	
	@RequestMapping(value = {"/","/list"}, method = RequestMethod.GET)
	public String showProducts(Model model){
		model.addAttribute("products",this.productService.getAllProducts());
		return "vendorHome";
	}
	
	@RequestMapping(value = {"/upload"}, method = RequestMethod.GET)
	public String uploadProductsForm(Model model, Product product){
		model.addAttribute("product", product);
		model.addAttribute("subCategories",catService.getAllCategory());
		return "vendorProduct";
	}
	
	@RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
	public String uploadProductsSave(@ModelAttribute("product") Product newProduct,
									HttpServletRequest request){
		
		String rootDirectory = request.getSession().getServletContext()
				.getRealPath("/");
		System.out.println("TC Root Directory-" + rootDirectory);
		
		String imagePath = "";
		String[] subCategoryIds = request.getParameterValues("subCategoryId");
		if(subCategoryIds.length > 0) newProduct.setCategory(catService.getCategoryById(Integer.parseInt(subCategoryIds[0])));
		MultipartFile productImage = newProduct.getProductImage();
		 
		//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				imagePath =  rootDirectory+"\\resources\\images\\"+ newProduct.getName() + ".png";
				productImage.transferTo(new File(imagePath));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed",e);
			}
		}
		productService.addProduct(newProduct);
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
		model.addAttribute("subCategories",catService.getAllCategory());
		return "vendorProductEdit";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String updateProducts(@ModelAttribute("product") Product newProduct,
									@RequestParam("subCategoryId") int id,
									RedirectAttributes redirectAttribute){
		String imagePath = "";
		if(id > 0) newProduct.setCategory(catService.getCategoryById(id));
		MultipartFile productImage = newProduct.getProductImage();
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				imagePath =  "C:\\Users\\Ketia\\Documents\\MUM\\pm\\HappyCart\\WebContent\\resources\\images\\"+ newProduct.getId() + ".png";
				productImage.transferTo(new File(imagePath));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed",e);
			}
		}
		productService.updateProduct(newProduct);
		redirectAttribute.addFlashAttribute("message", "Successfully updated item");
		return "redirect:/vendor/";
	}
}
