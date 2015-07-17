package com.mum.edu.happycart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.edu.happycart.domain.Cart;
import com.mum.edu.happycart.domain.CartItem;
import com.mum.edu.happycart.domain.CreditCard;
import com.mum.edu.happycart.domain.CreditCardTransaction;
import com.mum.edu.happycart.domain.Order;
import com.mum.edu.happycart.domain.OrderDetail;
import com.mum.edu.happycart.domain.User;
import com.mum.edu.happycart.mail.MailService;
import com.mum.edu.happycart.service.AppSettingsService;
import com.mum.edu.happycart.service.CartService;
import com.mum.edu.happycart.service.CredentialService;
import com.mum.edu.happycart.service.CreditCardService;
import com.mum.edu.happycart.service.CreditCardTransactionService;
import com.mum.edu.happycart.service.MyFinanceService;
import com.mum.edu.happycart.service.OrderService;
import com.mum.edu.happycart.service.UserService;

@Controller
public class PaymentController {

	@Autowired
	CartService cartService;

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

	@Autowired
	CredentialService credentialService;

	@Autowired
	CreditCardService creditCardService;

	@Autowired
	AppSettingsService appSettingsService;

	@Autowired
	CreditCardTransactionService ccTransactionService;

	@Autowired
	MyFinanceService myFinanceService;

	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/checkout")
	public String getCreditCard(
			@ModelAttribute("creditCard") CreditCard creditCard, Model model) {

		String cartId = (String) (((ModelMap) model).get("cartSessionId"));
		Cart cart = cartService.read(cartId);
		model.addAttribute("amountDue", cart.getTotal());
		return "payment";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String verifyCreditCard(
			@Valid @ModelAttribute("creditCard") CreditCard creditCard,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "payment";
		}
		CreditCard creditCardFound = creditCardService
				.findCreditCard(creditCard.getNumber());

		if (creditCardFound == null) {
			model.addAttribute("errorMessage",
					appSettingsService.appSettings("ErrorCard").getParamValue()
							.toString());
			return "payment";
		}

		if (creditCardFound.getCreditAvailable() < creditCard.getAmount()) {
			model.addAttribute("errorMessage",
					appSettingsService.appSettings("ErrorBalance")
							.getParamValue().toString());
			return "payment";
		}

		createdOrder(model);
		processCreditCardTransaction(creditCard, creditCardFound, model);

		model.addAttribute("message", "Payment Completed Successfully");
		model.addAttribute("message1", "Thank you for shopping with us!!!");
		model.addAttribute("message2",
				"Your Receipt and Expected Delivery date has been emailed to your account!!!");

		return "messagePage";
	}

	public void createdOrder(Model model) {

		Order order = new Order();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		String cartId = (String) (((ModelMap) model).get("cartSessionId"));
		Cart cart = cartService.read(cartId);

		for (Entry<String, CartItem> item : cart.getCartItems().entrySet()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setPrice(item.getValue().getTotalPrice());
			orderDetail.setQuantity(item.getValue().getQuantity());
			orderDetail.setProduct(item.getValue().getProduct());
			orderDetail.setOrder(order);
			orderDetailList.add(orderDetail);
		}

		order.setOrderedDate(new Date());
		order.setTotalAmount(cart.getTotal());
		order.setUser(userService.getLoggedInUser());
		order.setOrderDetail(orderDetailList);

		orderService.saveOrder(order);
		sendEmail(model, order);

	}

	public void processCreditCardTransaction(CreditCard creditCard,
			CreditCard creditCardFound, Model model) {

		String cartId = (String) (((ModelMap) model).get("cartSessionId"));
		Cart cart = cartService.read(cartId);
		List<CreditCardTransaction> ccTransactionsList = new ArrayList<CreditCardTransaction>();

		for (Entry<String, CartItem> item : cart.getCartItems().entrySet()) {

			CreditCardTransaction ccTransaction = new CreditCardTransaction();

			ccTransaction.setAmountSpent(item.getValue().getTotalPrice());
			ccTransaction.setCreditCardNumber(creditCard.getNumber());
			ccTransaction.setHappyCartAmount(Double
					.parseDouble(appSettingsService
							.appSettings("HappyCartPercent").getParamValue()
							.toString())
					* item.getValue().getTotalPrice());
			ccTransaction.setProduct(String.valueOf(item.getValue()
					.getProduct().getId()));
			ccTransaction.setPurchaseDate(new Date());
			ccTransaction.setReceiptNumber(1); // dummy receipt number
			ccTransaction.setTax(Double.parseDouble(appSettingsService
					.appSettings("TaxPercent").getParamValue().toString())
					* item.getValue().getTotalPrice());
			ccTransaction.setVendorAmount(Double.parseDouble(appSettingsService
					.appSettings("VendorsPercent").getParamValue().toString())
					* item.getValue().getTotalPrice());
			// ccTransaction.setCreditCard(creditCardFound);
			ccTransactionsList.add(ccTransaction);
			ccTransactionService.saveCreditCardTransaction(ccTransaction);
		}

		creditCardFound.setAmount(creditCard.getAmount());
		creditCardFound.setCreditAvailable(creditCardFound.getCreditAvailable()
				- creditCard.getAmount());
		creditCardFound.setMoneyUsed(creditCardFound.getMoneyUsed()
				+ creditCard.getAmount());

		// creditCardFound.setCreditCardTransaction(ccTransactionsList);
		creditCardService.saveCreditCard(creditCardFound);
		myFinanceService.transferToMyFinance(ccTransactionsList);

	}

	public void sendEmail(Model model, Order order) {
		String cartId = (String) (((ModelMap) model).get("cartSessionId"));
		Cart cart = cartService.read(cartId);
		mailService
				.sendMail(
						"happycartmart@gmail.com",
						userService.getLoggedInUser().getEmail(),
						"Receipt and Delivery Date Notification - HappyCart",
						"Expected your products to be delivered in the coming 3 working days.Thank you for shopping with us!!!"
								+ "Total Amount Purchased -"
								+ order.getTotalAmount()
								+ "Purchase Date"
								+ order.getOrderedDate());
		for (Entry<String, CartItem> item : cart.getCartItems().entrySet()) {

			User vendor = userService.getUserByID(item.getValue().getProduct()
					.getUserId());
			mailService
					.sendMail(
							"happycartmart@gmail.com",
							vendor.getEmail(),
							"Request for Item Delivery - HappyCart ",
							"Dear Mr."
									+ vendor.getFname()
									+ " Please Make sure this product "
									+ item.getValue().getProduct().getName()
									+ "  will be delivered within 3 working days from now!!! Thank you"
									+ " Delivery Address "
									+ userService.getLoggedInUser()
											.getAddress().getStreet()
									+ ","
									+ userService.getLoggedInUser()
											.getAddress().getState()
									+ ","
									+ userService.getLoggedInUser()
											.getAddress().getZipcode());
		}
	}

}
