package org.openshift.RestClient;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.openshift.calculations.Calculation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 

public class RestClient {

	public static void main(String [] args ) throws IOException {
		Client client = ClientBuilder.newClient(); 
	
		Calculation calc = new Calculation (1, "4 + 2 * 5", 0);
		
		Gson gson = new GsonBuilder().create(); 

		WebTarget target = client.target("http://web-calc-web-calculator.1d35.starter-us-east-1.openshiftapps.com/api/test/calc"); 
		Response response = target.request("application/json").post(Entity.json(gson.toJson(calc)));
		String responseString = response.readEntity(String.class);
		Calculation calc_ret = gson.fromJson(responseString, Calculation.class); 
		System.out.println(calc_ret);
		response.close(); 
		client.close(); 
		
		
		//DoubleEvaluator evaluator = new DoubleEvaluator(); 
		//String expression = "2 + 2 * 2"; 
		//Double result = evaluator.evaluate(expression);
		//System.out.println(expression + " = " + result); 
			
	}
	
}
