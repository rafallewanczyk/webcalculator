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
	
		Calculation calc = new Calculation (1, "1 + 2 * 3") ;
		
		Gson gson = new GsonBuilder().create(); 

		WebTarget target = client.target("http://localhost:8080/web-calculator/api/test/calc"); 
		Response response = target.request("application/json").post(Entity.json(gson.toJson(calc)));
		String responseString = response.readEntity(String.class);
		System.out.println(responseString);
		Calculation calc_ret = gson.fromJson(responseString, Calculation.class); 
		System.out.println(calc_ret);
		response.close(); 
		client.close(); 
			
	}
	
}
