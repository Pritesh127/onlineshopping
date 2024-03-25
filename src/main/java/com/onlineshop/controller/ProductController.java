package com.onlineshop.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlineshop.entity.EntityCategory;
import com.onlineshop.entity.EntityProduct;
import com.onlineshop.repository.CategoryRepository;
import com.onlineshop.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/products")
	public String listProduct(Model model) {
		model.addAttribute("entityProduct", productService.getAllProducts());
		List<EntityCategory> listCategory = categoryRepository.findAll();
		model.addAttribute("listCategory",listCategory);
//		model.addAttribute("standardDate", new Date());
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		return "productTemplates/productpage";
	}
	
	// this method will create empty object and open the form addcategory and that form will return url of below method ie /category
		@GetMapping("/addproduct")
		public String product(Model model) {
			EntityProduct entityProduct = new EntityProduct();
			model.addAttribute("entityProduct",entityProduct);
			List<EntityCategory> listCategory = categoryRepository.findAll();
			model.addAttribute("listCategory",listCategory);
			System.out.println(entityProduct);
			return "productTemplates/addProduct";
		}
	
		// this mehtod will save data to the database
		@PostMapping("/products")
		public String addProduct(@ModelAttribute("entityProduct") EntityProduct entityProduct) {
			System.out.println("inside add category method ***************");
			System.out.println(entityProduct);
			entityProduct.setManufacturingDate(new Date());
			productService.saveProduct(entityProduct);
			
//			return "categoryTemplate/categorypage";
			return "redirect:/products";
		}
		
		
		// for updating we need to fetch category data from database so we create method in service to get data from id
		//	and than use that method in below method 
		@GetMapping("/product/edit/{id}")
		public String editProduct(@PathVariable int id, Model model) {
			System.out.println("inside edit method +**************");
//			int i=Integer.parseInt(id);  
			List<EntityCategory> listCategory = categoryRepository.findAll();
			model.addAttribute("listCategory",listCategory);
			System.out.println(id);
			model.addAttribute("entityProduct", productService.getProductById(id));
			return "productTemplates/editproduct";
		}
		
		
		@PostMapping("/product/{id}")
		public String updateProduct(@PathVariable int id,
				@ModelAttribute("entityProduct") EntityProduct entityProduct,
				Model model) {
			System.out.println("-7+++++++7********+*47-*4-+7*-+7-+74=======================*");
			
			// get category form database by id
			EntityProduct product = productService.getProductById(id);
			System.out.println(" before product setting  method ***********************");
			product.setProductName(entityProduct.getProductName());
			product.setProductBrand(entityProduct.getProductBrand());
//			product.setManufacturingDate(entityProduct.getManufacturingDate());
			product.setProductPrice(entityProduct.getProductPrice());
			product.setProductCategory(entityProduct.getProductCategory());
			System.out.println(" before save method ***********************");
			//save updated category
			productService.updateProduct(product);
			return "redirect:/products";
		}
		
		@GetMapping("/deleteproduct/{id}")
		public String deleteproduct(@PathVariable int id) {
			productService.deleteProduct(id);
			return "redirect:/products";
		}
		
		
		
}
