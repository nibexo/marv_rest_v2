package com.marvin.v1;



public class Product{

	private String name;
	private int qty;

	public Product() {
	}

	public Product(String name, int qty) {
		this.name = name;
		this.qty = qty;
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

	@Override
	public String toString() {
		return "Product [name=" + name + ", qty=" + qty + "]";
	}

}