package com.nagp.inventory.resource;

import java.util.Collection;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.nagp.inventory.models.Product;
import com.nagp.inventory.service.InventoryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@EnableHystrix
public class InventoryResourceImpl implements InventoryResource{

	
	private  InventoryService inventoryService;	
	 
	@Autowired(required=false)
	public InventoryResourceImpl(final InventoryService inventoryService) {
	        this.inventoryService = inventoryService;
	}

    
	public InventoryResourceImpl() {
	}
	
	
	@Override
	@HystrixCommand(fallbackMethod = "GetFallback")
	public Collection<Product> getAllProducts(@PathParam("id")String id,@PathParam("name")String name){
		
		return inventoryService.getAllProducts(id,name);
		
	}

	@Override
	@HystrixCommand(fallbackMethod = "GetFallback")
	public Product getProduct(@PathParam("id")String id) {
		return inventoryService.getProduct(id);
	}
	
	
	@Override
	@HystrixCommand(fallbackMethod = "GetFallback")
	public String addProduct(Product product) {
		
		Optional.ofNullable(product.getProductName()).orElse("Product Name can not be empty");
		
		return  inventoryService.addProduct(product);
		
	}	
	  
	  
	@Override
	public String updateProduct(String id,Product product) {
		return  inventoryService.updateProduct(id, product);
	}

	private String GetFallback(){
		  System.out.println("Product Service is down!!! fallback route enabled...");
		  
	        return "CIRCUIT BREAKER ENABLED!!! No Response From Product Service at this moment. " +
	                    " Service will be back shortly - ";
	}
	


	
}
