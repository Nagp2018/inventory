package com.nagp.inventory.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.nagp.inventory.resource.InventoryResource;
import com.nagp.inventory.resource.InventoryResourceImpl;


@Configuration
@ApplicationPath("/inventory")
public class JerseyConfiguration extends ResourceConfig {
	
	
  public JerseyConfiguration() {
  
  }
 
  @PostConstruct
  public void setUp() {
    register(InventoryResourceImpl.class);
    
  }
}