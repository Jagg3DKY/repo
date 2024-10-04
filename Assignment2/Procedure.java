/* 
*Class: CMSC203 CRN 20931
*Program: Assignment 2
*Instructor: Khandan Monshi
*Summary of Description: Create a Driver Class and Two Object Classes for a Patient and 3 Procedures
*Due Date: 10/04/2024
*Integrity Pledge: I pledge that I have completed the programming assignment independently.
*I have not copied the code from a student or any source.
*Kyran Heijkoop
*/

public class Procedure {

	private String name, date, practitioner;
	private double charges;
	
	//no arg constructor
	public Procedure() {
		
	}
	
	//name + date constructor
	public Procedure(String name, String date) {
		
		this.name = name;
		this.date = date;
	}
	
	//all parameter constructor
	public Procedure(String name, String date, String practitioner, double charges) {
		
		this.name = name;
		this.date = date;
		this.practitioner = practitioner;
		this.charges = charges;
	}
	
	//mutators for each attribute
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setPractitioner(String practitioner) {
		this.practitioner = practitioner;
	}
	
	public void setCharges(double charges) {
		this.charges = charges;
	}
	
	//accessors for each attribute
	public String getName() {
		return name;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getPractitioner() {
		return practitioner;
	}
	
	public double getCharges() {
		return charges;
	}
	
	//toString Method
	public String toString() {
		return "\tProcedure: " + name + "\n\tProcedure Date: " + date + "\n\tPractitioner: " + practitioner + "\n\tCharge: $" + charges; 
	}
	
}
