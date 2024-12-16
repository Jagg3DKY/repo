/* 
* Class: CMSC203 CRN 20931
* Program: Assignment #6
* Instructor: Khandan Monshi
* Summary of Description: Abstract class that contains general methods for all types of beverages, such as adding price based on size. Also contains type, size, name, and base prices for all beverages
* Due Date: 12/15/2024
* Integrity Pledge: I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* Student Name: Kyran Heijkoop
*/

public abstract class Beverage {
	
	private String bevName;
	private Type type;
	private Size size;
	private static final double BASE_PRICE = 2.0;
	private static final double SIZE_PRICE = .5;
	
	
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
		
	}
	
	public double addSizePrice() {
		return BASE_PRICE + size.ordinal() * SIZE_PRICE;
	}
	
	public abstract double calcPrice();
	
	public boolean equals(Object obj) {
		
		if (obj instanceof Beverage) {
			Beverage temp = (Beverage) obj;
			return temp.bevName.equals(this.bevName) && temp.getSize() == this.getSize() && temp.getType() == this.getType(); 
			
		}
		
		else {
			return false;
		}
		
	}
	
	public double getBasePrice() {
		return BASE_PRICE;
	}

	public String getBevName() {
		return bevName;
	}

	public Type getType() {
		return type;
	}


	public Size getSize() {
		return size;
	}

	@Override
	public String toString() {
		return bevName + "," + size;
	}
	
}
