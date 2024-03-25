package com.onlineshop.service;

import java.util.List;



import com.onlineshop.entity.EntityCategory;


public interface CategoryService {

	List<EntityCategory> getAllCategory();

	EntityCategory saveCategory(EntityCategory entityCategory) ;
	
	EntityCategory getCategoryById(int categoryId);
	EntityCategory updateCategory(EntityCategory entityCategory);
	
	void deleteCategory(int id);
}
