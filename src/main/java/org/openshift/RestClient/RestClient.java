package org.openshift.RestClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.ClientBuilder; 

public class RestClient {

	public static void main(String [] args ) {
		Client client = ClientBuilder.newClient(); 
		String response = client.target("http://localhost:8080/web-calculator/api/test").request(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(response);
		client.close(); 
	}
	
}
