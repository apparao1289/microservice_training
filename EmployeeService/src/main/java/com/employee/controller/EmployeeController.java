package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.employee.mode.EmployeeDetails;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/registration")
	public String getRegistartionForm(ModelMap map) {
		return "registration";

	}

	@PostMapping(value = "/save")
	public ModelAndView saveEmployee(EmployeeDetails employeeDetails) {
		// Stores the values in DB.
		employeeService.createEmployee(employeeDetails);
		ModelAndView mv = new ModelAndView("success");
		return mv;
	}

	@PostMapping(value = "/create")
	public @ResponseBody EmployeeDetails saveEmployeeRest(@RequestBody EmployeeDetails employeeDetails) {
		// Stores the values in DB.
		employeeService.createEmployee(employeeDetails);
		return employeeDetails;
	}
	
	@GetMapping(value = "/pageNumber/{pageNumber}/pageSize/{pageSize}/sort/{sortValue}")
	public @ResponseBody List<EmployeeDetails> getEmployeeDetails(@PathVariable("pageNumber") Integer pageNumber,
			@PathVariable("pageSize") Integer pageSize, @PathVariable("sortValue") String sortValue) {

		return employeeService.getEmployeeDetails(pageNumber, pageSize, sortValue);
	}
}
