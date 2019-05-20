package org.openshift.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder; 

import org.openshift.calculations.Calculation;

@Path("test")
public class MyResource {

	@GET()
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		System.out.println("odebralem text"); 
		return "it workss"; 
	}
	
	
	@POST()
	@Path("calc")
	@Consumes("application/json")
	@Produces("application/json")
	public Calculation test(Calculation calc) {
		System.out.println("odebralem = " + calc); 
		calc.increase(); 
		return calc; 
		
	}
}
