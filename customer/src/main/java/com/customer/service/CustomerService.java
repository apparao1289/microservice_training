package com.customer.service;

import com.customer.model.CustomerDetails;
import com.customer.model.Result;

public interface CustomerService {

	Result createCustomer(CustomerDetails customerDetails);

	CustomerDetails getCustomerById(String id);

}
