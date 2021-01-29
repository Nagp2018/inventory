package com.nagp.inventory.backend;

import java.util.Collection;

import com.nagp.inventory.models.Product;


public interface InventoryDao {

    public Collection<Product> getAllProducts(final String id,final String name);
	
	public Product getProduct(String id);
	
	public void insertProduct(Product product);
	
	public String updateProduct(String id,Product product);
	
	public boolean isAvailable(String id);
	
}
