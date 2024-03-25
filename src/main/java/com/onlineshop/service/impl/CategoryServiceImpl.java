package com.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.entity.EntityCategory;
import com.onlineshop.entity.User;
import com.onlineshop.repository.CategoryRepository;
import com.onlineshop.repository.UserRepository;
import com.onlineshop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;

	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository; 
	}
	
	@Override
	public EntityCategory saveCategory(EntityCategory entityCategory) {
		categoryRepository.save(entityCategory);
		return null;
	}
	
	@Override
	public List<EntityCategory> getAllCategory() {
		return categoryRepository.findAll();
		
	}

	@Override
	public EntityCategory getCategoryById(int categoryId) {		
		return categoryRepository.findById(categoryId).get();
	}

	
	@Override
	public EntityCategory updateCategory(EntityCategory entityCategory) {
		return categoryRepository.save(entityCategory);
	}

	@Override
	public void deleteCategory(int id) {

		categoryRepository.deleteById(id);
		
	}


	
	
	
}
