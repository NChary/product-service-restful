package com.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Mapping to a Table
@Table(name="product_details")
public class ProductEntity {

	@Id // Primary key in the db
	@GeneratedValue(strategy =  GenerationType.IDENTITY) // auto increment value 
	@Column(name="id")
	private int id;
	
	@Column(name="pid")
	private String pid;
	
	@Column(name="pname")
	private String pname;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="price")
	private double price;
	
	
	public ProductEntity() {
	}
	
	public ProductEntity(String pid, String pname, String serialNumber, double price) {
		super();
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
