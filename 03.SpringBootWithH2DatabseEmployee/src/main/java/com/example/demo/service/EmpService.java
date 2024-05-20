package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmpDao;

@Service
public class EmpService {
	
	@Autowired
	private EmpDao empDao;
	
	public Employee SaveEmpData(Employee empData) {
		return empDao.save(empData);
	}
	
	public List<Employee> getEmpdata(){
		return (List<Employee>) empDao.findAll();
	}
	
	public Optional<Employee> getDataById(int id) {
		return empDao.findById(id);
	}
}
