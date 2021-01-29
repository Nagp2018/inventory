package com.nagp.inventory.backend;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.nagp.inventory.models.Product;


@Component
public class InventoryDaoImpl implements InventoryDao{

	
	private final ConcurrentMap<String, Product> products  = new ConcurrentHashMap<>();
	
	
	@Override
	public Collection<Product> getAllProducts(final String id,final String name) {
		
			return products.values();
		
	}

	@Override
	public Product getProduct(final String id) {
		return products.get(id);
	}

	@Override
	public void insertProduct(final Product product) {
		if(Objects.isNull(product.getId())){
			product.setId(UUID.randomUUID().toString());
		}		
		
		 products.put(product.getId(), product);
	}

	@Override
	public String updateProduct(String id, Product product) {
		if (products.containsKey(id)) {
			 products.put(id, product);
		} 
		return "Product Detail Updated";
	}

	@Override
	public boolean isAvailable(String id) {
		if (products.containsKey(id)) {
			 return products.get(id).getProductQty() > 0 ? true : false;
		} 
		return false;
	}

	
	

}
