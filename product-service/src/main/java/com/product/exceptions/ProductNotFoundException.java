package com.product.exceptions;

public class ProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 8709749729055270426L;

	public ProductNotFoundException(String message) {
		super(message);
	}
	
}
