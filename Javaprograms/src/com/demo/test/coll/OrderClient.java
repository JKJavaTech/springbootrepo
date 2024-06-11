package com.demo.test.coll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OrderClient {

	public static void main(String[] args) {

		List<OrderModel> listOrder = Stream.of(new OrderModel(101, "Oppo", Arrays.asList(123456L, 3456789L)),
				new OrderModel(102, "LG", Arrays.asList(9998887656L, 123456789L)),
				new OrderModel(103, "Sony", Arrays.asList(76767677L, 3456789L))).toList();

		// Using the map function to get the list of orders
		List<String> getOrders = listOrder.stream().map((orderModel) -> orderModel.getOrderName()).toList();
		System.out.println("The List Orders Was " + getOrders);
		// Using flatmap function to get the list of list mobile numbers
		List<Long> getMobileNumbers = listOrder.stream().flatMap((orderModel) -> orderModel.getMobileNumver().stream())
				.toList();
		System.out.println("Getting the Mobile Numbers >>> " + getMobileNumbers);
	}

}
