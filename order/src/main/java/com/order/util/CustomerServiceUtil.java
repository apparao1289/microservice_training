package com.order.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.order.external.model.CustomerDetails;

@Component
public class CustomerServiceUtil {

	@Autowired
	public RestTemplate restTemplate;

	public boolean checkCustomerCredit(String customerId, Double totalPrice) {

		String url = "http://localhost:8081/customer/customer/";

		CustomerDetails customerDetails = restTemplate.getForObject(url, CustomerDetails.class);

		if (customerDetails != null && totalPrice > customerDetails.getCredit()) {
			return false;
		}
		return true;

	}

}
