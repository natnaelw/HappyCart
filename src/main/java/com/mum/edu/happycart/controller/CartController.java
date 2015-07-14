package com.mum.edu.happycart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mum.edu.happycart.domain.Cart;
import com.mum.edu.happycart.domain.CartItem;
import com.mum.edu.happycart.domain.Product;
import com.mum.edu.happycart.service.CartService;
import com.mum.edu.happycart.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {


	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;

	@RequestMapping
	public String show(HttpServletRequest request) {
		return "redirect:/cart/view/" + request.getSession(true).getId();
	}


	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String showCart(@PathVariable("id") String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		Cart cart = cartService.read(cartId);

		if (cart == null) {
			cart = new Cart(cartId);
			cartService.create(cart);
		}
		model.addAttribute("cart", cart);
		return "cart";
	}
	

	@RequestMapping(value = "/add/{productid}", method = RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addToCart(
			@PathVariable("productid") long productId,
			@RequestParam("quantity") int quantity,
			@RequestParam("mode") String mode, Model model,
			HttpServletRequest request) {
		
		System.out.println("---Request Reached Cart Controller---");


		String cartId = request.getSession(true).getId();
		Cart cart = cartService.read(cartId);
		if (cart == null) {
			cart = cartService.create(new Cart(cartId));
		}
		Product product = productService.getProductById(productId);
		if (product == null) {
			System.out.println("Product Not Found!");
		}
		CartItem item = new CartItem(product);
		//item.setQuantity(quantity);
		System.out.println("Controller item before" + item.getTotalPrice());
		cart.addCartItem(item, mode);
		System.out.println("Controller item" + item.getTotalPrice());
		cartService.update(cartId, cart);

	}


	@RequestMapping(value = "/remove/{productid}", method = RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeFromCart(
			@PathVariable("productid") int productId, Model model,
			HttpServletRequest request) {

		String cartId = request.getSession().getId();
		Cart cart = cartService.read(cartId);
		if (cart != null) {
			Product product = productService.getProductById(productId);
			if (product == null) {
				System.out.println("Product Not Found!");
			}

			cart.removeCartItem(new CartItem(product));
			cartService.update(cartId, cart);
		}

	}
}
