package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.CustomerDetails;
import com.customer.model.Result;
import com.customer.service.CustomerService;

import io.swagger.annotations.Api;
@Api("Customer")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/customer/create", consumes = "application/json")
	public Result createCustomer(@RequestBody CustomerDetails customerDetails) {

		return customerService.createCustomer(customerDetails);
	}

	@GetMapping(value = "/customer/{id}")
	public Object getCustomerById(@PathVariable("id") String id) {

		try {
			return customerService.getCustomerById(id);
		} catch (Exception e) {
			Result result = new Result();
			result.setStatus("FAIL");
			result.setMessage("Exception occurred while fetching customer details.");
			return result;
		}
	}

}
