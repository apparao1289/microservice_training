package com.inventory.service;

import java.util.List;

import com.inventory.model.ProductDetails;
import com.inventory.model.Result;

public interface ProductService {

	public Result onboardProduct(ProductDetails productDetails);

	public ProductDetails getProductById(String id);

	public List<ProductDetails> getProductByName(String name);

}
