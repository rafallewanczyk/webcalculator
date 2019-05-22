package org.openshift.calculations;

public class Calculation {

	private int error; 
	private String command; 
	private double result; 
	
	public Calculation(int Error, String Command, double Result) {
		error = Error; 
		command = Command; 
		result = Result; 
	}
	
	public Calculation() {
	}
	
	
	public String getCommand() {
		return command; 
	}
	
	public void setCommand(String Command) {
		command = Command; 
	}
	
	public void setResult(double Res) {
		result = Res; 
	}
	
	public double getResult() {
		return result; 
	}
	
	public void setError(int e) {
		error = e; 
	}
	 
	public int getError() {
		return error; 
	}
	
	@Override 
	public String toString(){
		return (Integer.toString(error) + " : " + command + " = " + result); 
		
	}
}
