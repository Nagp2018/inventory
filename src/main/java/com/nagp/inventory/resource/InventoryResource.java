package com.nagp.inventory.resource;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import com.nagp.inventory.models.Product;



@Component
@Path("/products")
public interface InventoryResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Product> getAllProducts(@PathParam("id")String id,@PathParam("name")String name);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Product getProduct(String id);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String updateProduct(@PathParam("id") String id, Product product);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addProduct(Product product);
	

	
	
}
