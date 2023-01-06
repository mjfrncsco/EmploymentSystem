package com.employmentSystem.caseStudy.service;

import java.util.List;

import com.employmentSystem.caseStudy.entity.EmployeeEntity;

public interface EmployeeService {
	List<EmployeeEntity> getAllEmployee();
	
	EmployeeEntity saveEmployee (EmployeeEntity employee);
	
	EmployeeEntity getEmployeeById (Long id);
	
	EmployeeEntity updateEmployee (EmployeeEntity employee);
	
//	void deleteEmployeeById(Long id);
}
