package com.mum.edu.happycart.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;


@Entity
public class User implements Serializable{

	
	
/**
	 * 
	 */
	private static final long serialVersionUID = -3794885616176050983L;

@Id
@GeneratedValue
@Column(name="user_id")
private long id;

private String fname;
private String lname;
@Email
private String email;
private String phone;
private String password;
private String userType;

@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinColumn(name="addressid")
private Address address;


@OneToOne(fetch=FetchType.LAZY) 
@JoinColumn(name="USERNAME") 
private Credentials credentials;

@OneToOne
@JoinColumn(name="creditCardId")
private CreditCard creditCard;


public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
public String getUserType() {
	return userType;
}


public void setUserType(String userType) {
	this.userType = userType;
}

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Credentials getCredentials() {
	return credentials;
}
public void setCredentials(Credentials credentials) {
	this.credentials = credentials;
}

public CreditCard getCreditCard() {
	return creditCard;
}

public void setCreditCard(CreditCard creditCard) {
	this.creditCard = creditCard;
}
	
}
