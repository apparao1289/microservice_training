package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.mode.EmployeeDetails;
import com.employee.mode.PaginationConfigurationPropeties;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private PaginationConfigurationPropeties pageConfigProperties;
	
	@Value("${page.size}")
	private Integer defaultPageSize;
	
	@Value("${page.number}")
	private Integer defaultPageNumber;
	
	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
	@Override
	public boolean createEmployee(EmployeeDetails employeeDetails) {
		
		return employeeDao.createEmployee(employeeDetails);
	}

	@Override
	public List<EmployeeDetails> getEmployeeDetails(Integer pageNumber, Integer pageSize, String sortValue) {
		
		if(null == pageNumber) {
			//pageNumber = defaultPageNumber;
			pageNumber = pageConfigProperties.getNumber();
		}
		
		if(null == pageSize || pageSize == 0) {
			//pageSize = defaultPageSize;
			pageSize = pageConfigProperties.getSize();
		}
		
		pageNumber = pageNumber - 1;
		
		pageNumber = pageNumber < 0 ? 0 :pageNumber;
		
		List<EmployeeDetails> list = employeeDao.getEmployeeDetails(pageNumber, pageSize,sortValue);
		
		return list;
	}

}
