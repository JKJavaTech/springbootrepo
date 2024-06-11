package com.demo.test.coll;

import java.util.List;

public class OrderModel {
	private int id;
	private String orderName;
	private List<Long> mobileNumver;

	public OrderModel(int id, String orderName, List<Long> mobileNumver) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.mobileNumver = mobileNumver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public List<Long> getMobileNumver() {
		return mobileNumver;
	}

	public void setMobileNumver(List<Long> mobileNumver) {
		this.mobileNumver = mobileNumver;
	}

	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", orderName=" + orderName + ", mobileNumver=" + mobileNumver + "]";
	}

}
