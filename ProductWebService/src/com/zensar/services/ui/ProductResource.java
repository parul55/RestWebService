package com.zensar.services.ui;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.zensar.business.ProductService;
import com.zensar.business.ProductServiceImpl;
import com.zensar.entities.Product;

/*
 * Author:	Parul Singh
 * Creation Date: 26th Jul 2019 10.00AM
 * Modified Date: 26th Jul 2019 10.00AM
 * Version: 1.0
 * Copyright: Zensar Technologies. All rights reserved. 
 * Description: Product  web service
 * It provides data through RESTful web Service
 */
@Path("/products")
public class ProductResource {
	private ProductService productService;
	
	public ProductResource(){
		productService=new ProductServiceImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Product> getAllProducts(){
		
		return productService.findAllProducts();
		
	}
	@Path("/{id}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getProduct(@PathParam("id") int productId){
		Product product=productService.findProductById(productId);
		if(product!=null)
			return Response.status(200).entity(product.toString()).build();
		else
			return Response.status(200).entity("Product " +productId+ " not found ").build();

	}
	
	@Path("/product/{id}")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Product getProductById(@PathParam("id") int productId){
		return productService.findProductById(productId);
	}
	
	@Path("/count")
	@GET
	@Produces("text/plain")
	/*public Response getProductCount(){
		return Response.status(200).entity("No. of products: "+productService.getProductCount()).build();
		
	}*/
	public String getProductCount(){
		 return ("No. of products: "+productService.getProductCount());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createProduct(@FormParam("id") int productId,@FormParam("name") String name,@FormParam("brand") String brand,@FormParam("price") double price){
		Product product=new Product(productId,name,brand,price);
		productService.create(product);
		return Response.ok().build();
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces("text/plain")
	public String removeProduct(@PathParam("id") int productId){
		Product product=productService.findProductById(productId);
			if(product!=null){
				productService.remove(product);
				return "Product "+productId+" deleted";
			}
			else{
				return "Product " +productId+" not found.";
			}
		}
	}
	

