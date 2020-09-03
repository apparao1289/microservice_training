package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.model.ProductOrderDetails;
import com.order.entity.model.Result;
import com.order.entity.service.ProductOrderService;

@RestController
public class OrderController {

	@Autowired
	private ProductOrderService productOrderService;
	
	@PostMapping(value = "/order/create", consumes = "application/json")
	public Result createOrder(@RequestBody ProductOrderDetails productOrderDetails) {
		
		return productOrderService.createOrder(productOrderDetails);
	}

	@GetMapping(value = "/order/{id}")
	public ProductOrderDetails getOrderDetailsById(@PathVariable("id") String id) {
		
		return productOrderService.getOrderDetailsById(id);
	}
	
}
