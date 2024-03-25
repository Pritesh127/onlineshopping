package com.onlineshop.service;

import java.util.List;


import com.onlineshop.entity.EntityProduct;

public interface ProductService {

	List<EntityProduct> getAllProducts();

	EntityProduct saveProduct(EntityProduct entityProduct) ;
	
	EntityProduct getProductById(int productId);
	EntityProduct updateProduct(EntityProduct entityProduct);
	
	void deleteProduct(int id);
}
