package com.example.demo.communication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service

public class ImplFeighClient implements CommunicateUsingFeign {
    @Autowired
	private CommunicateUsingFeign communicateUsingFeign;
	@Override
	public Employee[] getEmpData() {
		return communicateUsingFeign.getEmpData();
	}

}
