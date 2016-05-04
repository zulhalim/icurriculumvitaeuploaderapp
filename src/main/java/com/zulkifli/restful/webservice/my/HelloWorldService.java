package com.zulkifli.restful.webservice.my;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {

	private static final String XML_MESSAGE_FRAGMENT = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
	private static final String MESSAGE = "<hello> Hello World! </hello> \n";
	private static final String PLAIN_TEXT_MESSAGE = "Hello Good World!...Plain Message \n";

	public HelloWorldService() {

	}

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String printXMLHELLO() {

		return HelloWorldService.XML_MESSAGE_FRAGMENT.concat(MESSAGE);

	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String printPlainText(){
		
		return HelloWorldService.PLAIN_TEXT_MESSAGE;
	}
	
	

}
