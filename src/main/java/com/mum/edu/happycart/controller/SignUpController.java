package com.mum.edu.happycart.controller;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.edu.happycart.domain.CreditCard;
import com.mum.edu.happycart.domain.CreditCardTransaction;
import com.mum.edu.happycart.domain.User;
import com.mum.edu.happycart.service.CreditCardService;
import com.mum.edu.happycart.service.UserService;

@Controller
public class SignUpController {

	@Autowired
	UserService userService;

	 @Autowired
	 CreditCardService creditCardService;
	 
	 User tempUser = new User();

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(@ModelAttribute("newUser") User user) {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String processSignUp(@Valid @ModelAttribute("newUser") User user,
			@ModelAttribute("creditCard") CreditCard creditCard,
			BindingResult result, RedirectAttributes redirectAttribute,Model model) {
		if (result.hasErrors()) {
			return "registration";
		}

		tempUser = user;
		
		if (user.getUserType().equals("customer")) {
			userService.addNewUser(user);
			model.addAttribute("message","Customer Registration Successful!!!hank you for being a HappyCart Member!!!");
			return "messagePage";
		}

		redirectAttribute.addFlashAttribute(user);
		redirectAttribute.addFlashAttribute(creditCard);
		return "redirect:/payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String getCreditCard(Model model) {
		CreditCard creditCard = (CreditCard)( ((ModelMap) model).get("creditCard") );
		//User user = (User)( ((ModelMap) model).get("user") );
		model.addAttribute(creditCard);
		//model.addAttribute(user);
		return "payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String verifyCreditCard(@Valid @ModelAttribute("creditCard")CreditCard creditCard,
			BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "payment";
		}
		CreditCard creditCardFound = creditCardService.findCreditCard(creditCard.getNumber());
		
		if(creditCardFound == null){
			model.addAttribute("errorMessage", "Invalid Card / Card Not Found");
			return "payment";
		}
		
		if(creditCardFound.getCreditAvailable() < creditCard.getAmount() ){
			model.addAttribute("errorMessage", "Insuffcient Balance");
			return "payment";
		}
		
			     
	     tempUser.setUserType("vendor");
	     userService.addNewUser(tempUser);
	     creditCardFound.setAmount(creditCard.getAmount());
	     creditCardFound.setCreditAvailable(creditCardFound.getCreditAvailable() - creditCard.getAmount());
	     creditCardFound.setMoneyUsed(creditCardFound.getMoneyUsed() + creditCard.getAmount());
	     
	     CreditCardTransaction ccTransaction = new CreditCardTransaction();
	     List<CreditCardTransaction> ccTransactionsList = new ArrayList<CreditCardTransaction>();
	     Date date = new Date();	     

	     ccTransaction.setAmountSpent(creditCard.getAmount());
	     ccTransaction.setCreditCardNumber(creditCard.getNumber());
	     ccTransaction.setHappyCartAmount(0.95*creditCard.getAmount());
	     ccTransaction.setProduct("1");
	     ccTransaction.setPurchaseDate(date);
	     ccTransaction.setReceiptNumber(1);
	     ccTransaction.setTax(0.05*creditCard.getAmount());
	     ccTransaction.setVendorAmount(0);
	     ccTransactionsList.add(ccTransaction);
	     
	     creditCardFound.setCreditCardTransaction(ccTransactionsList);
	     creditCardService.saveCreditCard(creditCardFound);
	     
	     model.addAttribute("message","Vendor Registration Successful!!!Thank you for being a HappyCart Member!!!");
	     
		return "messagePage";
	}
	
	 @ModelAttribute
	 public void initializeModel(Model model) {

	 List<String> creditCardTypes = new ArrayList<String>();
	 creditCardTypes.add("Visa");
	 creditCardTypes.add("Master");
	 model.addAttribute("creditCardTypes", creditCardTypes);

	 List<String> months = new ArrayList<String>();
	 for (int i = 0; i < 12; i++) {
	 months.add(new DateFormatSymbols().getShortMonths()[i]);
	 }
	 model.addAttribute("months", months);
	 }

}
