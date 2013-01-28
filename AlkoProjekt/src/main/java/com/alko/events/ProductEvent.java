package com.alko.events;

import java.util.EventObject;

import com.alko.project.Product;


public class ProductEvent extends EventObject {

	private Product _product;
	
	
	public Product getProduct() {
		return _product;
		}	
	
	
	public ProductEvent(Object source, Product product) {
		super(source);
		_product=product;
		

		
		
		
	}
	
}
