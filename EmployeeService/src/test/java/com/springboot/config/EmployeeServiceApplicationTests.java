package com.springboot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.mode.EmployeeDetails;
import com.employee.service.EmployeeService;

@SpringBootTest
class EmployeeServiceApplicationTests {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateEmployee() {
		System.out.println("testCreateEmployee executing..");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("Ram kumar");
		employeeDetails.setJob("Manager");
		employeeDetails.setComm(100);
		employeeDetails.setSalary(5000);
		employeeDetails.setDeptNo(2);
		
		boolean status = employeeService.createEmployee(employeeDetails);
		assertEquals(status, true);
	}
	
	@Test
	void testCreateEmployeeWithOutDeptNo() {
		System.out.println("testCreateEmployee executing..");
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setName("Ravi");
		employeeDetails.setJob("QA Manager");
		employeeDetails.setComm(100);
		employeeDetails.setSalary(7000);
		employeeDetails.setDeptNo(2);
		boolean status = employeeService.createEmployee(employeeDetails);
		assertEquals(status, true);
	}
	
	@Test
	void testGetEmployeeDetails() {
		List<EmployeeDetails> empList = employeeService.getEmployeeDetails(1, 5, "salary");
		assertNotNull(empList);
		assertEquals(empList.size(), 5);
	}

}
