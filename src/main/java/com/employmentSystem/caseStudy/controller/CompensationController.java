package com.employmentSystem.caseStudy.controller;

import java.util.Arrays;
import java.util.List;
import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.employmentSystem.caseStudy.entity.CompensationEntity;
import com.employmentSystem.caseStudy.service.CompensationService;
import com.employmentSystem.caseStudy.service.EmployeeService;

@Controller
public class CompensationController {
	
	private CompensationService compensationService;
	private EmployeeService employeeService;
	
	public CompensationController(CompensationService compensationService, EmployeeService employeeService) {
		super();
		this.compensationService = compensationService;
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee/compensationDetails/{id}")
	public String listcompensations(@PathVariable Long id, Model model) {
		
		model.addAttribute("employee", id);
		model.addAttribute("compensationDetails", compensationService.getCompensationHistory(id));

		return "compensationHistory";
		
	}
	
	@PostMapping("/employee/compensationDetails/search")
	public String searchCompensation(Model model, Date startDate, Date endDate) {
		//Not yet done
		return null;
	}
	
	@GetMapping("/employee/compensationDetails/new")
	public String createEmployeeCompensationForm(Model model) {
		CompensationEntity compensationEntity = new CompensationEntity();
		
		model.addAttribute("employeeList", employeeService.getAllEmployee());
		model.addAttribute("compensationDetails", compensationEntity);
		
		List<String> typeList = Arrays.asList("Salary", "Bonus", "Commission", "Allowance", "Adjustment");
		model.addAttribute("typeList", typeList);
		
		return "createCompensation";
	}
	
	@PostMapping("/employee/compensationDetails/save")
	public String saveEmployeeCompensation(@ModelAttribute("compensationDetails") CompensationEntity compensationEntity, RedirectAttributes redirAttrs) {
		String compensationType = compensationEntity.getCompensationType();
		Long check = checkEmployeeSalary(compensationEntity.getCompensationDate(), compensationEntity.getEmployeeId());
		if(check > 0 && compensationType.equals("Salary")) {
			redirAttrs.addFlashAttribute("duplicate", "Employee salary already exists for this month...");
			return "redirect:/employee/compensationDetails/new";
		}else {
			compensationService.saveCompensation(compensationEntity);
			
			redirAttrs.addFlashAttribute("added", "New compensation has been added successfully...");
			
			return "redirect:/employee";
		}
	}
	
	@GetMapping("/employee/compensationDetails/breakdown/{employeeId}/{compensationDate}")
	public String getCompensationBreakdown(@PathVariable("employeeId") Long employeeId, @PathVariable("compensationDate") Date compensationDate, Model model) {
		model.addAttribute("date", compensationDate);
		model.addAttribute("employee", employeeId);
		model.addAttribute("compensationDetails", compensationService.getCompensationBreakdown(compensationDate));
		return "compensationDetails";
	}
	
	@GetMapping("/employee/compensationDetails/edit/{compensationId}")
	public String editCompensationForm( @PathVariable("compensationId") Long compensationId, Model model) {
		model.addAttribute("compensationDetails", compensationService.getCompensationById(compensationId));
		return "editCompensation";
	}
	
	public Long checkEmployeeSalary(Date compensationDate, Long employeeId) {
		Long salary = compensationService.checkEmployeeSalary(compensationDate, employeeId);
		if(salary == null) {
			salary = (long) 0;
		}
		return salary;
	}
}
