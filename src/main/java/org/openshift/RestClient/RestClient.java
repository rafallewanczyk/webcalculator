package org.openshift.RestClient;

import org.openshift.calculations.Calculation;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 

public class RestClient {

	public static void main(String [] args ) throws IOException {
		Client client = ClientBuilder.newClient(); 
		String response = client.target("http://localhost:8080/web-calculator/api/test").request(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(response);
		client.close(); 
		
		Calculation calc = new Calculation (1, "2 + 2 * 2") ;
//		System.out.println(calc.toString()); 
		
		Gson gson = new GsonBuilder().create(); 
		gson.toJson(calc, System.out);
		
	}
	
}
