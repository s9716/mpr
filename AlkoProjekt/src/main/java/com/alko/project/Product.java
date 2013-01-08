package com.alko.project;

public class Product implements IProduct {
	public ProductMarks mark;
	public String name;
	public double price;
	public float code;
	boolean box;

	public Product(ProductMarks mark, double price) {
		this.mark = mark;
		this.price = price;
	}

	

	public Product(String name, double price, float code) {
		this.name = name;
		this.code = code;
		this.price = price;
	}

	public Product(ProductMarks mark, double price, float code) {
		this.mark = mark;
		this.code = code;
		this.price = price;
	}

	

}
