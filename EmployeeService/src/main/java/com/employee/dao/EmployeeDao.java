package com.employee.dao;

import java.util.List;

import com.employee.mode.EmployeeDetails;

public interface EmployeeDao {
	
	boolean createEmployee(EmployeeDetails employeeDetails);

	List<EmployeeDetails> getEmployeeDetails(Integer pageNumber, Integer pageSize, String sortValue);
}
