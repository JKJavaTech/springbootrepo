package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.communication.CommunicateUsingFeign;
import com.example.demo.dao.AddressDao;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;

import lombok.RequiredArgsConstructor;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;
	
	
	
	public List<Address> getAddress(){
		return (List<Address>) addressDao.findAll();
	}
	
	public Address saveAddress(Address address){
		return addressDao.save(address);
	}
	
	public Optional<Address> getAddressById(int id) {
		return addressDao.findById(id);
	}
	
	
}
