package com.inventory.dao;

import java.util.List;

import com.inventory.model.ProductDetails;

public interface ProductDao {

	public void onboardProduct(ProductDetails productDetails);
	
	
	public ProductDetails getProductById(String id);
	
	
	public List<ProductDetails> getProductByName(String name);
	
}
