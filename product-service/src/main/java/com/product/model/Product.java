package com.product.model;

public class Product {

	private int id;
	private String pid;
	private String pname;
	private String serialNumber;
	private double price;
	
	public Product(String pid, String pname, String serialNumber, double price) {
		super();
		this.id = id;
		this.pid = pid;
		this.pname = pname;
		this.serialNumber = serialNumber;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
