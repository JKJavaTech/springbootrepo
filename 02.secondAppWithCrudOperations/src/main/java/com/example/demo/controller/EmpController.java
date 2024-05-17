package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;

import javax.print.attribute.standard.Media;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;

@RestController
public class EmpController {
	
	private static Employee emp=new Employee();
	
   @PostMapping(path="/createempData")
	public Employee createEmployee(@RequestBody Employee empData) {
	  emp.setId(empData.getId());
	  emp.setName(empData.getName());
	  emp.setEmailId(empData.getEmailId());
	  emp.setCompany(empData.getCompany());
	  return emp;
	}
   
    @GetMapping(path="/getempData")
	public Employee GetEmployee() {
	  return emp;
	}
}
