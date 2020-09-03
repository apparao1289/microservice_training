package com.order.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
			StringBuilder url = new StringBuilder(inventoryUrl).append(productItem.getProductId());
			ProductDetails productDetails = restTemplate.getForObject(url.toString(), ProductDetails.class);
			if (!(null != productDetails && productDetails.getQuantity() > 0)) {
				return false;
			}
		}

		return true;
	}

}
