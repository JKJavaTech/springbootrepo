package com.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpListDemo {
	
	public static void main(String[] args) {
		
	   Employee e1=new Employee(101, "Durga", 10000.00);
	   Employee e2=new Employee(102, "Ant", 20000.00);
	   Employee e3=new Employee(103, "Bones", 90000.00);
	   
	   List<Employee> empList=new ArrayList<>();
	   empList.add(e1);
	   empList.add(e2);
	   empList.add(e3);
	   
	   //get the max salary of the employee
	   Employee empOptional=empList.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
	   System.out.println("Max Salary Was "+empOptional.getName());
	   
	   //removing the Strings in the array
	   String arr[]= {"","One",""};
	   Stream<String> streamString=Stream.of(arr);
	   List<String> getString=streamString.filter((str)->!str.isEmpty()).collect(Collectors.toList());
	   System.out.println("After Replacing Count Was "+getString);
	   
	   //Sorting Order reverse based on the empName and salary
	   List<Employee> afterSorting=empList.stream()
			   .sorted(Comparator.comparing(Employee::getName,Comparator.reverseOrder())
					   .thenComparing(Employee::getSalary))
			           .collect(Collectors.toList());
	   System.out.println(afterSorting);
	   
	   List<Employee> afterSortingNormal=empList.stream()
			   .sorted(Comparator.comparing(Employee::getName)
					   .thenComparing(Employee::getSalary))
			           .collect(Collectors.toList());
	   System.out.println(afterSortingNormal);
	   
	   String name="aaAAbbBBBBBB";
	   Map<Character,Long> mapCount=name.chars()
			   .mapToObj((ch)->(char)ch)
			   .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	   System.out.println("The Count Was "+mapCount);
	   
	}

}
