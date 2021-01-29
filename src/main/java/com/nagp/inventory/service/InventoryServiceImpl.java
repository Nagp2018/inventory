package com.nagp.inventory.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.nagp.inventory.backend.InventoryDao;
import com.nagp.inventory.models.Product;


@Service
public class InventoryServiceImpl implements InventoryService {

	
	private final InventoryDao inventoryDao;
	
	@Autowired private JmsTemplate jmsTemplate;
	 
	@Autowired(required=false)
	public InventoryServiceImpl(final InventoryDao inventoryDao) {
	        this.inventoryDao = inventoryDao;
	}
	    
	@Override
	public Collection<Product> getAllProducts(final String id,final String name) {
		Collection<Product> allProducts = inventoryDao.getAllProducts(id,name);
		
		
		
		return allProducts.isEmpty() ? Collections.emptyList() : new ArrayList<>(allProducts);
	}

	@Override
	public Product getProduct(final String id) {
		return inventoryDao.getProduct(id);
	}

	@Override
	public String addProduct(final Product product) {
		inventoryDao.insertProduct(product);
		return "Product Added to Inventory";
	}

	@Override
	public String updateProduct(final String id,final Product product) {
		inventoryDao.updateProduct(id, product);
		return "Product Details Updated";
	}

	@Override
	@JmsListener(destination="OrderRequestReceivedEvent")
	public void isAvailable(String orderID) {
		System.out.println("messgae received in inventory");
		 if(inventoryDao.isAvailable(orderID)){
			  sendInventoryAvaliableEvent(orderID);
		 }else{
			 sendProductNotAvailable(orderID);
		 }
	}
	
	public void sendInventoryAvaliableEvent(String orderID){
		jmsTemplate.convertAndSend("InventoryAvaliableEvent", orderID);
	}
	
	public void sendProductNotAvailable(String orderID){
		jmsTemplate.convertAndSend("InventoryNotAvaliableEvent", orderID);
	}

	

	
}
