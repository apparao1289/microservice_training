package com.employee.service;

import java.util.List;

import com.employee.mode.EmployeeDetails;

public interface EmployeeService {
	
	boolean createEmployee(EmployeeDetails employeeDetails);

	List<EmployeeDetails> getEmployeeDetails(Integer pageNumber, Integer pageSize, String sortValue);

}
