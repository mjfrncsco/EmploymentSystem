package com.employmentSystem.caseStudy.repository;

import java.util.List;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employmentSystem.caseStudy.entity.CompensationEntity;

public interface CompensationRepository extends JpaRepository<CompensationEntity, Long> {
	
	/*
	@Query(value = "SELECT CONCAT(MONTHNAME(compensationDate), ' ', YEAR(compensationDate)) AS date, SUM(amount) as amount "
			+ "FROM CompensationEntity c WHERE c.employeeId LIKE CONCAT('%',:employee_id,'%')"
			+ "GROUP BY compensationDate ORDER BY compensationDate ASC", nativeQuery = true)
	*/
	
	@Query(value="SELECT compensation_id, SUM(amount) AS amount, comp_description, compensation_date, compensation_type, employee_id "
			+ "FROM compensation "
			+ "WHERE employee_id = ?1 GROUP BY MONTH(compensation_date) , YEAR(compensation_date)", nativeQuery=true)
	public List<CompensationEntity> getCompensationHistory(Long employee_id);
	
	@Query(value="SELECT * FROM compensation WHERE compensation_date LIKE CONCAT(YEAR(?1), '-', MONTH(?1), '-%') ORDER BY compensation_date DESC", nativeQuery=true)
	public List<CompensationEntity> getCompensationBreakdown(Date compensationDate);
	
	@Query(value="SELECT compensation_id FROM compensation "
			+ "WHERE compensation_date LIKE CONCAT(YEAR(?1), '-', MONTH(?1), '-%') AND employee_id = ?2 AND compensation_type = 'Salary'", nativeQuery=true)
	public Long checkEmployeeSalary(Date compensationDate, Long employeeId);
	
}
