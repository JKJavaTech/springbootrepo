package com.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSortValues {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Durga", 10000.00);
		Employee e2 = new Employee(102, "Ant", 90000.00);
		Employee e3 = new Employee(103, "Bones", 30000.00);

		Map<Integer, Employee> empMap = new HashMap<>();
		empMap.put(1, e1);
		empMap.put(2, e2);
		empMap.put(3, e3);
		System.out.println("The Map Was " + empMap);
		// Asending order
		Map<Integer, Employee> sortedMap = empMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary)))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()),
						LinkedHashMap::putAll);
		System.out.println(sortedMap);

		// Reversed Order
		Map<Integer, Employee> sortedMapReverse = empMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary).reversed()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()),
						LinkedHashMap::putAll);
		System.out.println(sortedMapReverse);
		
		
		//comparing with multiple values
		Map<Integer, Employee> sortedMapReverseqMul = empMap.entrySet().stream().
				sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Employee::getSalary))).
				collect(LinkedHashMap::new ,(map,entry)->map.put(entry.getKey(),entry.getValue()),LinkedHashMap::putAll);
				
		System.out.println(sortedMapReverseqMul);
	}

}
