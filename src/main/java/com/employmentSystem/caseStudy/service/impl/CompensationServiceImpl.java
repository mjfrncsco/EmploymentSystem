package com.employmentSystem.caseStudy.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employmentSystem.caseStudy.entity.CompensationEntity;
import com.employmentSystem.caseStudy.repository.CompensationRepository;
import com.employmentSystem.caseStudy.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService{

	private CompensationRepository compensationRepository;
	
	public CompensationServiceImpl(CompensationRepository compensationRepository) {
		super();
		this.compensationRepository = compensationRepository;
	}

	@Override
	public List<CompensationEntity> getCompensationHistory(Long employee_id) {
		return compensationRepository.getCompensationHistory(employee_id);
	}

	@Override
	public CompensationEntity saveCompensation(CompensationEntity compensationEntity) {
		return compensationRepository.save(compensationEntity);
	}

	@Override
	public CompensationEntity getCompensationById(Long compensationId) {
		return compensationRepository.findById(compensationId).get();
	}

	@Override
	public List<CompensationEntity> getCompensationBreakdown(Date compensationDate) {
		return compensationRepository.getCompensationBreakdown(compensationDate);
	}

	@Override
	public Long checkEmployeeSalary(Date compensationDate, Long employeeId) {
		return compensationRepository.checkEmployeeSalary(compensationDate, employeeId);
	}

}
