package com.example.demo.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Employee;

@FeignClient(name ="testEmp" ,url="http://localhost:8082,")
public interface CommunicateUsingFeign {
	
	@GetMapping(value = "/empData")
	public Employee[] getEmpData();
	

}
