package com.order.entity.dao;

import com.order.entity.model.ProductOrderDetails;

public interface ProductOrderDao {
	
	public void createOrder(ProductOrderDetails productOrderDetails);
	
	public ProductOrderDetails getOrderDetailsById(String id);
}
