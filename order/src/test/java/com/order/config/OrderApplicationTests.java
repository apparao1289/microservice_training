package com.order.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.entity.model.ProductItemDetails;
import com.order.entity.model.ProductOrderDetails;
import com.order.entity.service.ProductOrderService;

@SpringBootTest
class OrderApplicationTests {
	
	@Autowired
	private ProductOrderService ProductOrderService;

	@Test
	void contextLoads() {
	}
	
	//@Test
	public void createOrder() {
		
		ProductOrderDetails productOrderDetails = new ProductOrderDetails();
		productOrderDetails.setName("32 inch led tv");
		productOrderDetails.setTotalPrice(100.0);
		productOrderDetails.setCustomerId("e86677e9-3cf7-4b4d-9f3c-a9f5661681ec");
		List<ProductItemDetails> productItemDetailsList = new ArrayList<>();
		ProductItemDetails productItemDetails = new ProductItemDetails();
		productItemDetails.setName("32 inch led LG TV");
		productItemDetails.setPrice(100.0);
		productItemDetails.setProductId("d918d22f-967a-4ec1-9f5f-0c9ea189d3aa");
		productItemDetailsList.add(productItemDetails);
		ProductOrderService.createOrder(productOrderDetails);
	}

	//@Test
	public void testGetProductDetails() {
		ProductOrderDetails productOrderDetails = ProductOrderService.getOrderDetailsById("12345");
		assertThat(productOrderDetails.getName()).isNull();
		System.out.println("Name:"+productOrderDetails.getName());
	}
}
