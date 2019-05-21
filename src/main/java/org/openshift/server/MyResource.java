package org.openshift.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.openshift.calculations.Calculation;

import com.fathzer.soft.javaluator.DoubleEvaluator;

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
		DoubleEvaluator evaluator = new DoubleEvaluator(); 
		calc.setResult(evaluator.evaluate(calc.getCommand()));
		calc.setCommand(String.valueOf(calc.getResult()));
		System.out.println(calc.getCommand() + " = " + calc.getResult());
		return calc; 
		
	}
}
