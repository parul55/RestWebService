package com.zensar.services;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/files")
public class FileDownloadService {
	private static final String FILE_PATH="d:/xp.txt";
	@GET
	@Path("/txt")
	@Produces("text/plain")
	public Response getFile(){
		File file=new File(FILE_PATH);
		ResponseBuilder responseBuilder=Response.ok(file);
		//responseBuilder.header("Content-Disposition", "attachment;filename=xp_file.txt");
		return responseBuilder.build();
	}
	
	@GET
	@Path("/images")
	@Produces("image/png")
	public Response getImage(){
		File file=new File("D:/images.jpg");
		ResponseBuilder responseBuilder=Response.ok(file);
		//responseBuilder.header("Content-Disposition", "attachment;filename=images.jpg");
		return responseBuilder.build();
	}
}
