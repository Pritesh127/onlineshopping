package com.onlineshop.entity;

import jakarta.persistence.*;

@Entity
public class EntityCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int categoryId;
	@Column(nullable = false, unique = true)
	private String categoryName;
//	private String categoryBrand;
	private String categoryRack;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
//	public String getCategoryBrand() {
//		return categoryBrand;
//	}
//	public void setCategoryBrand(String categoryBrand) {
//		this.categoryBrand = categoryBrand;
//	}
	public String getCategoryRack() {
		return categoryRack;
	}
	public void setCategoryRack(String categoryRack) {
		this.categoryRack = categoryRack;
	}
	
	
	
	public EntityCategory() {
		super();
		
	}
	public EntityCategory(String categoryName, String categoryBrand, String categoryRack) {
		super();
		this.categoryName = categoryName;
		
		this.categoryRack = categoryRack;
	}//this.categoryBrand = categoryBrand;
	
	
	@Override
	public String toString() {
		return "EntityCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryRack=" + categoryRack + "]";
	} //categoryBrand="+ categoryBrand + ",
	
	
	
}
