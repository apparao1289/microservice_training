package com.order.entity.service;

import com.order.entity.model.ProductOrderDetails;
import com.order.entity.model.Result;

public interface ProductOrderService {

	public Result createOrder(ProductOrderDetails productOrderDetails);

	public ProductOrderDetails getOrderDetailsById(String id);

}
