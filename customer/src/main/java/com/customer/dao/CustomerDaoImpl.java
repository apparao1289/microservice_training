package com.customer.dao;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.entity.Customer;
import com.customer.model.CustomerDetails;
import com.customer.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean createCustomer(CustomerDetails customerDetails) {

		Customer custome = new Customer();
		BeanUtils.copyProperties(customerDetails, custome);
		custome.setCreated_on(new Date());
		custome.setCreatedBy(customerDetails.getName());
		custome.setLastUpdatedBy(customerDetails.getName());
		custome.setLastUpdatedOn(new Date());

		customerRepository.save(custome);
		return true;
	}

	@Override
	public CustomerDetails getCustomerById(String id) {

		CustomerDetails customerDetails = new CustomerDetails();

		Optional<Customer> customerEntity = customerRepository.findById(id);

		Customer customer = customerEntity.get();

		BeanUtils.copyProperties(customer, customerDetails);

		return customerDetails;
	}

}
