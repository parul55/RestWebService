package com.zensar.services;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/zenparam")
public class HelloParam{
	
	
	
	@Path("/welcomed/{year}/{month}/{day}")
	@GET
	@Produces("text/html")

	public Response getMessage(@PathParam("year") int year,@PathParam("month") int month,@PathParam("day") int day){
		LocalDate date=LocalDate.of(year, month, day);
		return Response.status(200).entity("<p> Happy Birthday --> "+date.toString()+"</p>").build();
	}
	
	
	
	@Path("/welcome/{nm}")
	@GET
	@Produces("text/html")
	public Response getMessage(@PathParam("nm") String name){
		return Response.status(200).entity("<p>Hello <b><i>" +name+"</i></b> Welcome to Zensar Hello Service</p>").build();
	}

}

