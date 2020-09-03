package com.customer.dao;

import com.customer.model.CustomerDetails;

public interface CustomerDao {
	
	boolean createCustomer(CustomerDetails customerDetails);
	
	CustomerDetails getCustomerById(String id);

}
