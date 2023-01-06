package com.employmentSystem.caseStudy.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employmentSystem.caseStudy.entity.EmployeeEntity;
import com.employmentSystem.caseStudy.repository.EmployeeRepository;
import com.employmentSystem.caseStudy.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public List<EmployeeEntity> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public EmployeeEntity getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}


	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}


}
