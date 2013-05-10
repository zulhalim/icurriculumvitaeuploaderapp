package com.ijoshluisaac.restful.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import com.ijoshluisaac.models.*;
 
@Path("/json/resume")
public class ResumeJSONService {
 
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public ResumeModel getResumeInJSON() {
 
		ResumeModel msg = new ResumeModel();
		msg.setName("Joshua U. Nwankwo");
		msg.setEmail("joshluisaac@gmail.com");
		msg.setAbout("Motivated,Loves new challenging stuffs and goal orinted");
 
		return msg;
 
	}
 
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createResumeInJSON(ResumeModel msg) {
 
		String result = "Profile saved successfully : " + msg;
		return Response.status(201).entity(result).build();
 
	}
 
}
