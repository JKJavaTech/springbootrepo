package com.demo;

public class EagerSingleton {

	public static final EagerSingleton sdp = new EagerSingleton();

	private EagerSingleton() {
	}
	
	public static EagerSingleton getInstance() {
			return sdp;
	}
	
	public static void main(String[] args) {
		EagerSingleton s1=EagerSingleton.getInstance();
		System.out.println(s1.hashCode());
		EagerSingleton s2=EagerSingleton.getInstance();
		System.out.println(s2.hashCode());
		
	}

}
