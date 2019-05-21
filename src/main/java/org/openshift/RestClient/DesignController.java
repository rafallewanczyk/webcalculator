package org.openshift.RestClient;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.openshift.calculations.Calculation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Class responsing for the user events
 * @since 1.0
 * @author Rafal Lewanczyk
 */
public class DesignController {

	/**
	 *Object responsible for evaluating the value of input string calls jshell
	 */
	private Calculation calc; 
	public Alert alert;// = new Alert(AlertType.ERROR); 
	private Client client; 
	private Gson gson; 
	private WebTarget target; 

	@FXML
	public TextField inputField; 
	
	@FXML
	public Button enter; 
	
	@FXML
	public Button AC; 

	/**
	 * Method identifying pressed button and putting proper character to output
	 * @param event pressed character button
	 */
	@FXML
	private void handleClick(Event event) {
		Button btn = (Button)event.getSource();
		calc.setCommand(calc.getCommand() + btn.getText());
		inputField.setText(calc.getCommand());
	}
	
	@FXML
	private void AC() {
		calc.setCommand("");
		inputField.setText(calc.getCommand());
	}
	
	
	/**
	 *Function calling jshell to evaluate result of the input string 
	 *After the evaluation checks if the returned value is not null 
	 *if true puts the result on the screen else shows alert and clears the screen  
	 */
	@FXML
	private void Enter() {
		Response response = target.request("application/json").post(Entity.json(gson.toJson(calc))); 
		String responseString = response.readEntity(String.class);
		calc = gson.fromJson(responseString, Calculation.class);
		response.close();
		inputField.setText(String.valueOf(calc.getResult()));

	}


	public void initialize() {
		calc = new Calculation(0, "", 0); 
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("incorrect input"); 
		client = ClientBuilder.newClient(); 
		
		gson = new GsonBuilder().create(); 

		target = client.target("http://web-calc-web-calculator.1d35.starter-us-east-1.openshiftapps.com/api/test/calc"); 
		//Response response = target.request("application/json").post(Entity.json(gson.toJson(calc)));
		//String responseString = response.readEntity(String.class);
		//Calculation calc_ret = gson.fromJson(responseString, Calculation.class); 
		//System.out.println(calc_ret);
		//response.close(); 
		//client.close(); 
		
		//AC.setOnAction(e -> AC());
		//enter.setOnAction(e -> Enter());
	}
	
	public void end() {
		System.out.println("shut down client"); 
		client.close(); 
	}
}
