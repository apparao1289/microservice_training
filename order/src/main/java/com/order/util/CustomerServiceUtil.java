package com.order.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.order.external.model.CustomerDetails;

@Component
public class CustomerServiceUtil {

	@Autowired
	public RestTemplate restTemplate;

	@Value("${customer.service.url}")
	public String url;
	
	public boolean checkCustomerCredit(String customerId, Double totalPrice) {

		StringBuilder sb = new StringBuilder(url).append(customerId);

		CustomerDetails customerDetails = restTemplate.getForObject(sb.toString(), CustomerDetails.class);
		//restTemplate.exchange(sb.toString(), HttpMethod.GET, null, CustomerDetails.class);

		if (customerDetails != null && totalPrice > customerDetails.getCredit()) {
			return false;
		}
		return true;

	}

}
