package com.employmentSystem.caseStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employmentSystem.caseStudy.entity.EmployeeEntity;
import com.employmentSystem.caseStudy.service.EmployeeService;


@Controller

public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//handler method to handle list employee and return mode and view
	@GetMapping("/employee")
	public String listEmployees(Model model) {
		model.addAttribute("employee", employeeService.getAllEmployee());
		return "employee";
	}
	@GetMapping("employee/newEmployee")
	public String createEmployeeForm(Model model) {
		
		//create employee object to hold employee data
		EmployeeEntity employee = new EmployeeEntity();
		model.addAttribute("employee", employee);
		return "createEmployee";
	}
	
	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute("employee") EmployeeEntity employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employee";
	} 
	
	@GetMapping("/employee/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "updateEmployee";
	}
	
	@PostMapping("/employee/{id}")
	public String updateEmployee(@PathVariable Long id, 
			@ModelAttribute("employee") EmployeeEntity employee,
			Model model) {
		
		//get student from database by id
		EmployeeEntity existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setMiddleName(employee.getMiddleName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setBirthDate(employee.getBirthDate());
		existingEmployee.setPosition(employee.getPosition());
		
		//save updated student object
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employee";
		
		
	}
//	
//	//handler method to handle delete employee request
//	@GetMapping("/employee/{id}")
//	public String deleteEmployee(@PathVariable Long id) {
//		employeeService.deleteEmployeeById(id);
//		return "redirect:/employee";
//	}
}
