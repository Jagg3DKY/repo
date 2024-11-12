/*
 * Class: CMSC203 CRN20931
 * Instructor: Khandan Monshi
 * Description: Management class that acts as the parent driver class to the plot and property classes
 * Due: 11/11/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Kyran Heijkoop
*/

public class ManagementCompany {
	
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	private String name;
	private String taxID;
	private double mgmFee;
	private Plot plot;
	private Property[] properties;
	private int numberOfProperties = 0;
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties  = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties  = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		this.properties  = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.getName();
		this.taxID = otherCompany.getTaxID();
		this.mgmFee = otherCompany.getMgmFeePer();
		this.plot = new Plot(otherCompany.getPlot());
		this.properties = otherCompany.getProperties();
		this.numberOfProperties = otherCompany.getPropertiesCount();
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		Property prop = new Property(name, city, rent, owner);
		return addProperty(prop);
	}
	
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property prop = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(prop);
	}
	
	public int addProperty(Property property) {
		Property prop = new Property(property);
		
		if (this.numberOfProperties == 5) {
			return -1;
		}
		
		if (prop == null) {
			return -2;
		}
		
		if (!this.plot.encompasses(prop.getPlot())){
			return -3;
		}
		
		for (int i = 0; i < this.numberOfProperties; i++) {
			if (prop.getPlot().overlaps(this.properties[i].getPlot())){
				return -4;
			}
		}
		
		this.properties[this.numberOfProperties] = prop;
		this.numberOfProperties++;
		return this.numberOfProperties - 1;
	}
	
	public void removeLastProperty() {
		if (numberOfProperties > 0) {
			this.properties[this.numberOfProperties - 1] = null;
			numberOfProperties--;
		}
	}
	
	public boolean isPropertiesFull() {
		return this.numberOfProperties == ManagementCompany.MAX_PROPERTY;
	}
	
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	public double getTotalRent() {
		double totalRent = 0;
		
		for (Property property : properties) {
			if (property != null) {
				totalRent += property.getRentAmount();
			}
		}
		return totalRent;
	}
	
	public Property getHighestRentProperty() {
		double highestRent = 0;
		int index = 0;
		
		if (numberOfProperties == 0){
			return null;
		}
		
		for (int i = 0; i < this.numberOfProperties; i++) {
			if (properties[i].getRentAmount() > highestRent) {
				highestRent = properties[i].getRentAmount();
				index = i;
			}
		}
		return properties[index];
	}
	
	public boolean isMangementFeeValid() {
		if (this.mgmFee > 0 && this.mgmFee < 100) {
			return true;
		}
		
		else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}
	
	public Property[] getProperties() {
		return properties;
	}

	public double getMgmFeePer() {
		return mgmFee;
	}

	public Plot getPlot() {
		return plot;
	}
	
	public String toString() {
		String string = "List of the properties for " + this.name + ", taxID: " + this.taxID + "\n______________________________________________________\n";
		
		for (Property property : this.properties) {
			if (property != null) {
				string += property.toString() + "\n";
			}
		}
		string += "______________________________________________________\n\n total management Fee: " + this.getTotalRent() * (this.mgmFee)/100.0;
		return string;
	}
}
