package com.mum.edu.happycart.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@XmlRootElement
@Entity
public class Product{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	//private String productId;
	private String name;
	
	@JsonIgnore
	@Transient
	private MultipartFile  productImage;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private SubCategory subcategory;
	private String description;
	private String manufacturer;
	private double unitPrice;
	private String conditions;
	private int unitInStock;
	
	
	public Product(String name, MultipartFile productImage, SubCategory subcategory, String description,
			String manufacturer, double unitPrice, String conditions, int unitInStock) {
		super();
		this.name = name;
		this.productImage = productImage;
		this.subcategory = subcategory;
		this.description = description;
		this.manufacturer = manufacturer;
		this.unitPrice = unitPrice;
		this.conditions = conditions;
		this.unitInStock = unitInStock;
	}

	public Product(){
		this("",null,null,"","",0,"",0);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}



	public SubCategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}
}
