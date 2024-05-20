package com.demo;

public class LazySingleton {
	
	private static LazySingleton lazySingleton=null;
	
	private LazySingleton() {
		
	}
	
	public static LazySingleton getInstance() {
		if(lazySingleton==null)
			return lazySingleton=new LazySingleton();
		return lazySingleton;
	}
	public static void main(String[] args) {
		LazySingleton ls=LazySingleton.getInstance();
		System.out.println(ls.hashCode());
		LazySingleton lsOne=LazySingleton.getInstance();
		System.out.println(lsOne.hashCode());
	}

}
