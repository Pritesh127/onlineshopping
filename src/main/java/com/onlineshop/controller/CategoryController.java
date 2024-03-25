package com.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.onlineshop.entity.EntityCategory;
import com.onlineshop.service.CategoryService;




@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService; 
	
	
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	// To fetch data from database and send to frontend using entityCategory object
	@GetMapping("/category")
	public String listCategory(Model model) {
		model.addAttribute("entityCategory", categoryService.getAllCategory());
		return "categoryTemplate/categorypage";
	}
	
	// this method will create empty object and open the form addcategory and that form will return url of below method ie /category
	@GetMapping("/addcategory")
	public String category(Model model) {
		EntityCategory entityCategory = new EntityCategory();
		model.addAttribute("entityCategory",entityCategory);
		System.out.println(entityCategory);
		return "categoryTemplate/addcategory";
	}
	 
	// this mehtod will save data to the database
	@PostMapping("/category")
	public String addCategory(@ModelAttribute("entityCategory") EntityCategory entityCategory) {
		System.out.println("inside add category method ***************");
		categoryService.saveCategory(entityCategory);
//		return "categoryTemplate/categorypage";
		return "redirect:/category";
	}
	
	// for updating we need to fetch category data from database so we create method in service to get data from id
	//	and than use that method in below method 
	@GetMapping("/category/edit/{id}")
	public String editCategory(@PathVariable int id, Model model) {
		System.out.println("inside edit method +**************");
//		int i=Integer.parseInt(id);  
		System.out.println(id);
		model.addAttribute("entityCategory", categoryService.getCategoryById(id));
		return "categoryTemplate/editCategory";
	}
	
	
	@PostMapping("/category/{id}")
	public String updateCategory(@PathVariable int id,
			@ModelAttribute("entityCategory") EntityCategory entityCategory,
			Model model) {
		System.out.println("-7+++++++7********+*47-*4-+7*-+7-+74=======================*");
		
		// get category form database by id
		EntityCategory category = categoryService.getCategoryById(id);
		System.out.println(" before category setting  method ***********************");
		category.setCategoryName(entityCategory.getCategoryName());
		category.setCategoryRack(entityCategory.getCategoryRack());
		System.out.println(" before save method ***********************");
		//save updated category
		categoryService.updateCategory(category);
		return "redirect:/category";
	}
	
	@GetMapping("/deletecategory/{id}")
	public String deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
		return "redirect:/category";
	}

	
	
	
}
