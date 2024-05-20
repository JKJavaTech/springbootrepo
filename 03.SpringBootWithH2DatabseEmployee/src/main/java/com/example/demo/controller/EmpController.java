package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.service.EmpService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("/createEmp")
	public ResponseEntity<Employee> saveEmpdata(@RequestBody Employee empdata){
		Employee empObject=empService.SaveEmpData(empdata);
		return new ResponseEntity<Employee>(empObject, HttpStatus.CREATED);
	}
	
	@GetMapping("/empData")
	public ResponseEntity<List<Employee>> getEmpData(){
	     List<Employee> listEmp=empService.getEmpdata();	
	     return new ResponseEntity<List<Employee>>(listEmp,HttpStatus.ACCEPTED);
	}	
	
	@GetMapping("/empDataById/{id}")
	public ResponseEntity<Optional<Employee>> getEmpDataById(@PathVariable("id") int id){
	     Optional<Employee> listEmp=empService.getDataById(id);	
	     return new ResponseEntity<Optional<Employee>>(listEmp,HttpStatus.ACCEPTED);
	}
}
