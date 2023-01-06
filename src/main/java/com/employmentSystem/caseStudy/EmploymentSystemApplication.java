package com.employmentSystem.caseStudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employmentSystem.caseStudy.entity.EmployeeEntity;
import com.employmentSystem.caseStudy.repository.EmployeeRepository;

@SpringBootApplication
public class EmploymentSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmploymentSystemApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Long id = (long) 1;
//		
//		EmployeeEntity employee1 = new EmployeeEntity(id, "Mark", "Jumaday", "Francisco", "08/21/1999", "Developer");
//		employeeRepository.save(employee1);
		
		
		
	}

}
