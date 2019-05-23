package org.openshift.RestClient;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RestClient extends Application {

	private FXMLLoader loader; 
	@Override
	public void start(Stage primaryStage) {
		try {

			loader = new FXMLLoader(getClass().getResource("Design.fxml"));
			BorderPane root = (BorderPane)loader.load(); 
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args ) {
		launch(args); 
	}
	
	@Override 
	public void stop() {
		System.out.println("koniec programu!!"); 
		DesignController c = loader.getController(); 
		c.end(); 
	}
	
}
