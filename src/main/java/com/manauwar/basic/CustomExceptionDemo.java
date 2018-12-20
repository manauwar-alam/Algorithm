package com.manauwar.basic;

import java.util.HashMap;
import java.util.Map;

public class CustomExceptionDemo {

	private static final Map<Integer, String> products = new HashMap<>();

	static {

		products.put(100, "Kit Kat");
		products.put(101, "5 Star");
		products.put(102, "Dairy Milk");
		products.put(103, "Pulse");
		products.put(104, "Melody");
	}

	public String getProduct(int productId) {

		if (products.get(productId) == null) {
			
			throw new NoSuchProductException("No Such Product Exists ", productId);
		}

		return products.get(productId);
	}

	public static void main(String[] args) {
		
		CustomExceptionDemo t = new CustomExceptionDemo();
		t.getProduct(1000);

	}

}




class NoSuchProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int productId;

	public NoSuchProductException() {
		super();
	}

	public NoSuchProductException(String message, int prductId) {
		super(message);
		this.productId = prductId;
	}

	public NoSuchProductException(String message, int productId, Throwable cause) {
		super(message, cause);
		this.productId = productId;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public String getMessage() {
		return super.getMessage() + " for Product Id : " + productId;
	}

	public int getProductId() {
		return productId;
	}

}
