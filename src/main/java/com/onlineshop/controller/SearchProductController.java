package com.onlineshop.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.entity.EntityProduct;
import com.onlineshop.repository.ProductRepository;

@RestController
public class SearchProductController {

	//search handler method
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	@GetMapping("/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query, Principal principle){
		List<EntityProduct> products = this.productRepository.findByProductNameContaining(query);
		return ResponseEntity.ok(products);
	}
}
