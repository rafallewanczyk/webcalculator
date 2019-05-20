package org.openshift.calculations;

public class Calculation {

	private int id; 
	private String command; 
	private double result; 
	
	public Calculation(int Id, String Command, double Result) {
		id = Id; 
		command = Command; 
		result = Result; 
	}
	
	public Calculation() {
	}
	
	
	public String getCommand() {
		return command; 
	}
	
	public void setResult(double Res) {
		result = Res; 
	}
	
	public double getResult() {
		return result; 
	}
	
	
	@Override 
	public String toString(){
		return (Integer.toString(id) + " : " + command + " = " + result); 
		
	}
}
