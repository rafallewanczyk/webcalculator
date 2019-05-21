package org.openshift.RestClient;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button; 
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import org.openshift.calculations.Calculation;

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
		/*
		Button btn = (Button)event.getSource();
		calc.setInput(calc.getInput() + btn.getText());
		inputField.setText(calc.getInput());
		*/
	}
	
	private void AC() {
		/*calc.setInput("");
		inputField.setText(calc.getInput());
		*/
	}
	
	
	/**
	 *Function calling jshell to evaluate result of the input string 
	 *After the evaluation checks if the returned value is not null 
	 *if true puts the result on the screen else shows alert and clears the screen  
	 */
	private void Enter() {
		/*calc.evaluate();

		if(calc.getInput() == null) {
			alert.show();
			AC() ;
			return ; 
		}
		inputField.setText(calc.getInput());
		*/
	}

	public void initialize() {
		/*
		calc = new Calculation(); 
		alert = new Alert(AlertType.ERROR);
		alert.setContentText("incorrect input"); 
		AC.setOnAction(e -> AC());
		enter.setOnAction(e -> Enter());
		*/
	}
}
