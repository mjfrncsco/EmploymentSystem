package com.employmentSystem.caseStudy.service;

import java.sql.Date;
import java.util.List;

import com.employmentSystem.caseStudy.entity.CompensationEntity;

public interface CompensationService {
	//Fetch all Compensation Data of an Employee
	List<CompensationEntity> getCompensationHistory(Long employees_id);
	
	//Fetch sum of all compensations per month each year
	//List<Compensation> getCompensationPerMonth();
	
	//Insert New Compensation Data in Database
	CompensationEntity saveCompensation(CompensationEntity compensationEntity);
	
	//Fetch Compensation by ID
	CompensationEntity getCompensationById(Long compensationId);
	
	//Fetch Compensations breakdown
	List<CompensationEntity> getCompensationBreakdown(Date compensationDate);
	
	//Search if Salary already exists
	Long checkEmployeeSalary(Date compensationDate, Long employeeId);
	
}
