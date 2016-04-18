package com.marvin.v2;



public class Product {

	private String name;
	private int qty;
	private int sec;

	public Product() {
	}

	public Product(String name, int qty, int sec) {
		this.name = name;
		this.qty = qty;
		this.sec = sec;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", qty=" + qty + ", sec="+ sec+ "]";
	}

}