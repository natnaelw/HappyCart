package com.mum.edu.happycart.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6212595579666071819L;
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private long id;
	private String street;
	private String state;
	private String zipcode;

	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
