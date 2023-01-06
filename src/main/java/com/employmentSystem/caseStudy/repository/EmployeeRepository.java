package com.employmentSystem.caseStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employmentSystem.caseStudy.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

}
