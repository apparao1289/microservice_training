package com.order.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.entity.model.ProductItemDetails;
import com.order.external.model.ProductDetails;

@Component
public class InventoryServiceUtil {

	@Autowired
	public RestTemplate restTemplate;

	@Value("${inventory.service.url}")
	public String inventoryUrl;
	
	public boolean checkInventory(List<ProductItemDetails> productItemDetails) {

		for (ProductItemDetails productItem : productItemDetails) {
			ProductDetails productDetails = getProductDetails(productItem);
			if (!(null != productDetails && productDetails.getQuantity() > 0)) {
				return false;
			}
		}

		return true;
	}
	
	@HystrixCommand(fallbackMethod = "productDetails")
	public ProductDetails getProductDetails(ProductItemDetails productItemDetails) {
		StringBuilder url = new StringBuilder(inventoryUrl).append(productItemDetails.getProductId());
		ProductDetails productDetails = restTemplate.getForObject(url.toString(), ProductDetails.class);
		return productDetails;
	}
	
	public ProductDetails productDetails() {
		System.out.println("Invoking fallback method...");
		ProductDetails productDetails = new ProductDetails();
		return productDetails;
	}
}
