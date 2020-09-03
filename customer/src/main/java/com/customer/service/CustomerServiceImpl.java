package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.customer.dao.CustomerDao;
import com.customer.model.CustomerDetails;
import com.customer.model.Result;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	@Override
	public Result createCustomer(CustomerDetails customerDetails) {

		Result result = new Result();

		boolean status = customerDao.createCustomer(customerDetails);

		if (status) {

			result.setStatus("SUCCESS");
			result.setMessage("Customer created succesfully");

		} else {
			result.setStatus("FAIL");
			result.setMessage("There is some problem while creating the customer. please try again");
		}

		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public CustomerDetails getCustomerById(String id) {

		return customerDao.getCustomerById(id);
	}

}
