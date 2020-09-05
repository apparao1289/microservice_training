package com.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.mode.EmployeeDetails;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepositiry;

	@Override
	public boolean createEmployee(EmployeeDetails employeeDetails) {

		Employee empEntity = new Employee();
		empEntity.setId(generateEmployeeId());
		empEntity.setName(employeeDetails.getName());
		empEntity.setJob(employeeDetails.getJob());
		empEntity.setDeptNo(employeeDetails.getDeptNo());
		empEntity.setSalary(employeeDetails.getSalary());
		empEntity.setComm(employeeDetails.getComm());
		empEntity.setMgr(2);
		empEntity.setHireDate(null);

		employeeRepositiry.save(empEntity);

		return true;
	}

	private Integer generateEmployeeId() {
		Integer id = employeeRepositiry.getMaxId();
		return id + 1;
	}

	@Override
	public List<EmployeeDetails> getEmployeeDetails(Integer pageNumber, Integer pageSize, String sortValue) {

		EmployeeDetails employeeDetails = null;
		List<EmployeeDetails> list = new ArrayList<>();

		Sort sort = Sort.by(sortValue);
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Employee> employeePage = employeeRepositiry.findAll(pageable);
		List<Employee> employeeList = employeePage.getContent();

		for (Employee e : employeeList) {
			employeeDetails = new EmployeeDetails();
			BeanUtils.copyProperties(e, employeeDetails);
			list.add(employeeDetails);
		}
		return list;
	}

}
