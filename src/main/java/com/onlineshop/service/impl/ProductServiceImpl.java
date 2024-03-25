package com.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlineshop.entity.EntityProduct;
import com.onlineshop.repository.ProductRepository;
import com.onlineshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<EntityProduct> getAllProducts() {
		return productRepository.findAll();
		
	}
	
	@Override
	public EntityProduct getProductById(int productId) {		
		return productRepository.findById(productId).get();
	}

	
	@Override
	public EntityProduct updateProduct(EntityProduct entityProduct) {
		return productRepository.save(entityProduct);
	}
	
	@Override
	public void deleteProduct(int id) {

		productRepository.deleteById(id);
		
	}

	@Override
	public EntityProduct saveProduct(EntityProduct entityProduct) {
		productRepository.save(entityProduct);
		return null;
	}
	
	
}
