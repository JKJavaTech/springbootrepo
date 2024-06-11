package com.demo.test.coll;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamAPIMethods {
	public static void main(String[] args) {
		List<Employee> listEmp = List.of(
				new Employee(101, "Male", 1000.00), 
				new Employee(102, "FeMale", 1000.00),
				new Employee(103, "Male", 1000.00), 
				new Employee(104, "FeMale", 1000.00),
				new Employee(105, "FeMale", 1000.00));
		
		Map<String,Map<Integer,Long>> mapCount=
				listEmp.stream()
				.collect(
						Collectors.groupingBy
						((emp)->emp.getName(),Collectors.groupingBy((emp)->emp.getId(),Collectors.counting())));
		System.out.println(mapCount);
		
		
		Map<String,Long> mapCountTest=
				listEmp.stream()
				.collect(Collectors.groupingBy(
								(emp)->emp.getName(),Collectors.counting()));
		System.out.println(mapCountTest);
		

	}

}
