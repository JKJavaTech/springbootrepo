package com.example.demo.controller;

import java.util.ArrayList;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.communication.ImplFeighClient;
import com.example.demo.entity.Address;
import com.example.demo.entity.DataTransferObject;
import com.example.demo.entity.Employee;
import com.example.demo.service.AddressService;

import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AddressController {
	
	//static Variables
	private static DataTransferObject dto=new DataTransferObject();
	private static List<DataTransferObject> dataTransferList=new ArrayList<DataTransferObject>();
	private static Employee empDataList=null;
	private static Employee empData=new Employee();
	private static List<Employee> listEmpData=new ArrayList<Employee>();
	private static DataTransferObject dtoTest=new DataTransferObject();
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ImplFeighClient implFeighClient;

	
	@Autowired private @Getter @Setter RestTemplate restTemplate;
	 

	@Autowired
	private @Getter @Setter WebClient webClient;


	@GetMapping(value = "/getAddress/{Id}")
	public ResponseEntity<Optional<Address>> getEmpDataById(@PathVariable("Id") int empId) {
		java.util.Optional<Address> getAddress = addressService.getAddressById(empId);
		return new ResponseEntity<Optional<Address>>(getAddress, HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/createAddress")
	public ResponseEntity<Address> getEmpData(@RequestBody Address address) {
		Address addressUpdate = addressService.saveAddress(address);
		return new ResponseEntity<Address>(addressUpdate, HttpStatus.CREATED);
	}

	/*
	 * Using The RestTemplate to call the one service to another service
	 * -----------------------------------------------------------------
	 * 
	 * @GetMapping(value="/callingService/{id}") public DataTransferObject
	 * getDataFromEmpService(@PathVariable("id") int id){ Employee
	 * fromCallMicro=restTemplate.getForEntity("http://localhost:8082/empDataById/"+
	 * id, Employee.class).getBody(); System.out.println(fromCallMicro.getEmpId());
	 * Address address=getEmpData(id).getBody().get(0); DataTransferObject dto=new
	 * DataTransferObject(fromCallMicro, address); return dto; }
	 */

	@GetMapping(value = "/callingService/{id}")
	public Employee getDataFromEmpService(@PathVariable("id") int id) {
		Employee fromCallMicro = webClient.get().uri("http://localhost:8082/empDataById/" + id).retrieve()
				.bodyToMono(Employee.class).block();
		System.out.println(fromCallMicro.getEmpId());
		Address address =addressService.getAddressById(id).get();
		fromCallMicro.setAddress(address);
		//dto.setAddress(address);
		dto.setEmp(fromCallMicro);
		return fromCallMicro;
	}

	@GetMapping(value = "/callingAllDetailsService")
	public List<DataTransferObject> getDataFromEmpAllDetailsService() {
        DataTransferObject dtoObject=null;
        List<DataTransferObject> afterData=new ArrayList<DataTransferObject>();;
		Employee[] fromCallMicro = webClient.get().uri("http://localhost:8082/empData")
		        .retrieve()
				.bodyToMono(Employee[].class)
				.block();
		for(Employee empCallMicro:fromCallMicro) {
			Address getAddMicro=getEmpDataById(empCallMicro.getEmpId()).getBody().get();
			empCallMicro.setAddress(getAddMicro);
			dtoObject=new DataTransferObject(empCallMicro);
			afterData.add(dtoObject);	
		}
		return afterData;
	}

	
	@GetMapping(value = "/callingAllDetailsServiceUsingFeign")
	public List<DataTransferObject> getDataFromEmpAllDetailsServiceFeign() {
        DataTransferObject dtoObject=null;
        List<DataTransferObject> afterData=new ArrayList<DataTransferObject>();;
		Employee[] fromCallMicro = implFeighClient.getEmpData();
		for(Employee empCallMicro:fromCallMicro) {
			Address getAddMicro=getEmpDataById(empCallMicro.getEmpId()).getBody().get();
			empCallMicro.setAddress(getAddMicro);
			dtoObject=new DataTransferObject(empCallMicro);
			afterData.add(dtoObject);	
		}
		return afterData;
	}

}
