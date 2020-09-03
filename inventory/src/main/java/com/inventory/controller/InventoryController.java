package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.ProductDetails;
import com.inventory.model.Result;
import com.inventory.service.ProductService;

@RestController
public class InventoryController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/product/onboard", consumes = "application/json")
	public Result onboardProduct(@RequestBody ProductDetails productDetails) {

		return productService.onboardProduct(productDetails);

	}

	@GetMapping(value = "/product/{id}")
	public ProductDetails getProductById(@PathVariable("id") String id) {

		return productService.getProductById(id);
	}

	@GetMapping(value = "/product/name/{name}")
	public List<ProductDetails> getProductByName(@PathVariable("name") String name) {

		return productService.getProductByName(name);
	}
}
