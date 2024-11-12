/*
 * Class: CMSC203 CRN20931
 * Instructor: Khandan Monshi
 * Description: Property class stores information about each property in the management company, parent to the plot class and child of the management company class
 * Due: 11/11/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Kyran Heijkoop
*/

public class Property {
	
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x, y, width, depth);
	}
	
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.getPropertyName();
		this.city = otherProperty.getCity();
		this.rentAmount = otherProperty.getRentAmount();
		this.owner = otherProperty.getOwner();
		plot = new Plot(otherProperty.getPlot());
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getCity() {
		return city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public String getOwner() {
		return owner;
	}

	public Plot getPlot() {
		return plot;
	}

	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
	
	
}
