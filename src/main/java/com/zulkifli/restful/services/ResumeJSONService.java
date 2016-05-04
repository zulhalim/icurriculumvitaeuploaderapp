package com.zulkifli.restful.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import com.zulkifli.models.*;
 
@Path("/json/resume")
public class ResumeJSONService {
 
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public ResumeModel getResumeInJSON() {
 
		ResumeModel msg = new ResumeModel();
		msg.setName("Zulkifli Halim");
		msg.setEmail("zul.halim87@gmail.com");
		msg.setAbout("Fokus and passionate doing my job, can be a good teamwork member and able to work independently");
 
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
