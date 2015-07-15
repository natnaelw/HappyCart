package com.mum.edu.happycart.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class CreditCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 899550823247576223L;
	@Id
	@GeneratedValue
	@Column(name = "creditCardId")
	private long id;
	
	@NotEmpty(message="{NotEmpty.CreditCard.name.validation}")
	//@Pattern(regexp="[a-zA-z]+ [a-zA-Z]*[.]? [a-zA-Z]+", message="{Pattern.CreditCard.name.validation}")
	private String name;
	
	@NotEmpty(message="{NotEmpty.CreditCard.number.validation}")
	@Pattern(regexp="[0-9]{16}", message="{Pattern.CreditCard.number.validation}")
	private String number;
	
	@NotEmpty(message="{NotEmpty.CreditCard.expireMonth.validation}")
	private String expireMonth;
	
	@NotEmpty(message="{NotEmpty.CreditCard.expireYear.validation}")
	private String expireYear;
	
	@NotEmpty(message="{NotEmpty.CreditCard.cvv.validation}")
	@NotNull @Size(min=3, max=3, message="{Pattern.CreditCard.cvv.validation}")
	private String cvv;
	
	@NotEmpty(message="{NotEmpty.CreditCard.type.validation}")
	@NotNull 
	private String type;
	
	private double cardValue;
	
	private double creditAvailable;
	
	private double moneyUsed;
	
	private double amount;
	
//	@OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<CreditCardTransaction> creditCardTransaction;
	
//	 @OneToOne (cascade=CascadeType.ALL)
//	  @JoinColumn(name="user_id", unique= true, nullable=true, insertable=true, updatable=true)
//	  private User user;
//	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpireMonth() {
		return expireMonth;
	}

	public void setExpireMonth(String expMonth) {
		this.expireMonth = expMonth;
	}

	public String getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(String expYear) {
		this.expireYear = expYear;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCardValue() {
		return cardValue;
	}

	public void setCardValue(double cardValue) {
		this.cardValue = cardValue;
	}

	public double getCreditAvailable() {
		return creditAvailable;
	}

	public void setCreditAvailable(double creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	public double getMoneyUsed() {
		return moneyUsed;
	}

	public void setMoneyUsed(double moneyUsed) {
		this.moneyUsed = moneyUsed;
	}

//	public List<CreditCardTransaction> getCreditCardTransaction() {
//		return creditCardTransaction;
//	}
//
//	public void setCreditCardTransaction(
//			List<CreditCardTransaction> creditCardTransaction) {
//		this.creditCardTransaction = creditCardTransaction;
//	}
	
	

}
