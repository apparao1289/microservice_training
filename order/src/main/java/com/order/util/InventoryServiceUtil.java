package com.order.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.order.entity.model.ProductItemDetails;

@Component
public class InventoryServiceUtil {

	@Autowired
	public RestTemplate restTemplate;

	public boolean checkInventory(List<ProductItemDetails> productItemDetails) {

		

		return false;
	}

}
