package com.onlineshop.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class EntityProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int productId;
	private String productName;
	private String productPrice;
	private String productBrand;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date manufacturingDate;
	

	private String productCategory;

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturinDate) {
		this.manufacturingDate = manufacturinDate;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	
	
	public EntityProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityProduct(String productName, String productPrice, String productBrand, String manufacturinDate,
			String productCategory) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productBrand = productBrand;
//		this.manufacturingDate = manufacturinDate;
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "EntityProduct [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productBrand=" + productBrand 
				+ ", productCategory=" + productCategory + "]";
	}
	
	
	
	
	
}
