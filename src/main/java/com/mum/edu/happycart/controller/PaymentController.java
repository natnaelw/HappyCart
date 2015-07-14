package com.mum.edu.happycart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.edu.happycart.domain.CreditCard;

@Controller
public class PaymentController {

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String getCreditCard(Model model) {
		CreditCard creditCard = (CreditCard)( ((ModelMap) model).get("creditCard") );
		model.addAttribute(creditCard);
		return "payment";
	}
	
}
