package org.openshift.calculations;

public class Calculation {

	private int id; 
	private String command; 
	
	public Calculation(int Id, String Command) {
		id = Id; 
		command = Command; 
	}
	
	public Calculation() {
	}
	
	public void increase() {
		id ++ ; 
		command = "2 + 3 * 4"; 
	}
	
	@Override 
	public String toString(){
		return (Integer.toString(id) + " : " + command); 
		
	}
}
