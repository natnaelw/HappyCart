package com.mum.edu.happycart.controller;

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
import com.mum.edu.happycart.service.AppSettingsService;
import com.mum.edu.happycart.service.CreditCardService;
import com.mum.edu.happycart.service.CreditCardTransactionService;
import com.mum.edu.happycart.service.UserService;

@Controller
public class SignUpController {

	@Autowired
	UserService userService;

	@Autowired
	CreditCardService creditCardService;

	@Autowired
	AppSettingsService appSettingsService;
	
	@Autowired
	CreditCardTransactionService ccTransactionService;

	User tempUser = new User();

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(@ModelAttribute("newUser") User user) {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String processSignUp(@Valid @ModelAttribute("newUser") User user,
			@ModelAttribute("creditCard") CreditCard creditCard,
			BindingResult result, RedirectAttributes redirectAttribute,
			Model model) {
		if (result.hasErrors()) {
			return "registration";
		}

		tempUser = user;

		if (user.getUserType().equals("customer")) {
			userService.addNewUser(user);
			model.addAttribute("message",
					appSettingsService
					.appSettings("RegistrationSuccess").getParamValue().toString());
			return "messagePage";
		}

		redirectAttribute.addFlashAttribute(user);
		redirectAttribute.addFlashAttribute(creditCard);
		return "redirect:/payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String getCreditCard(Model model) {
		CreditCard creditCard = (CreditCard) (((ModelMap) model)
				.get("creditCard"));
		model.addAttribute("amountDue", appSettingsService
				.appSettings("RegFee").getParamValue().toString());
		model.addAttribute(creditCard);
		return "payment";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String verifyCreditCard(
			@Valid @ModelAttribute("creditCard") CreditCard creditCard,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "payment";
		}
		CreditCard creditCardFound = creditCardService
				.findCreditCard(creditCard.getNumber());

		if (creditCardFound == null) {
			model.addAttribute("errorMessage", appSettingsService
					.appSettings("ErrorCard").getParamValue().toString());
			return "payment";
		}

		if (creditCardFound.getCreditAvailable() < creditCard.getAmount()) {
			model.addAttribute("errorMessage", appSettingsService
					.appSettings("ErrorBalance").getParamValue().toString());
			return "payment";
		}

		processCreditCardTransaction(creditCard, creditCardFound);

		model.addAttribute("message",
				 appSettingsService
					.appSettings("RegistrationSuccess").getParamValue().toString());

		return "messagePage";
	}

	public void processCreditCardTransaction(CreditCard creditCard,
			CreditCard creditCardFound) {

		tempUser.setUserType("vendor");
		userService.addNewUser(tempUser);
		creditCardFound.setAmount(creditCard.getAmount());
		creditCardFound.setCreditAvailable(creditCardFound.getCreditAvailable()
				- creditCard.getAmount());
		creditCardFound.setMoneyUsed(creditCardFound.getMoneyUsed()
				+ creditCard.getAmount());

		CreditCardTransaction ccTransaction = new CreditCardTransaction();
		List<CreditCardTransaction> ccTransactionsList = new ArrayList<CreditCardTransaction>();
		Date date = new Date();

		ccTransaction.setAmountSpent(creditCard.getAmount());
		ccTransaction.setCreditCardNumber(creditCard.getNumber());
		ccTransaction.setHappyCartAmount(Double.parseDouble(appSettingsService
				.appSettings("HappyCartPercentRegistration").getParamValue()
				.toString())
				* creditCard.getAmount());
		ccTransaction.setProduct("0"); //dummy product id 
		ccTransaction.setPurchaseDate(date);
		ccTransaction.setReceiptNumber(1); //dummy receipt number
		ccTransaction.setTax(Double.parseDouble(appSettingsService
				.appSettings("TaxPercent").getParamValue().toString())
				* creditCard.getAmount());
		ccTransaction.setVendorAmount(0);
		//ccTransaction.setCreditCard(creditCardFound);
		//ccTransactionsList.add(ccTransaction);
        ccTransactionService.saveCreditCardTransaction(ccTransaction);
        
        
		//creditCardFound.setCreditCardTransaction(ccTransactionsList);
		creditCardService.saveCreditCard(creditCardFound);

	}

}
