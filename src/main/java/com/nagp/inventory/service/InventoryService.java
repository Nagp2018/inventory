package com.nagp.inventory.service;

import java.util.Collection;

import com.nagp.inventory.models.Order;
import com.nagp.inventory.models.Product;



public interface InventoryService {

	public Collection<Product> getAllProducts(final String id,final String name);
	
	public Product getProduct(String id);
	
	public String addProduct(Product product);
	
	public String updateProduct(String id,Product product);
	
	public void isAvailable(String orderID);
}
