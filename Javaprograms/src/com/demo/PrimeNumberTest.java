package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumberTest {
	
	public static void main(String[] args) {
		List<Integer> listInt=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> primeGet=listInt.stream().filter((number)->number%2!=0).collect(Collectors.toList());
		System.out.println("Prime Number"+primeGet);
	}
}
