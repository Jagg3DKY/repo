/* 
* Class: CMSC203 CRN 20931
* Program: Assignment #6
* Instructor: Khandan Monshi
* Summary of Description: Alcohol class that contains metods specific to the alcohol beverage, extends the beverage class
* Due Date: 12/15/2024
* Integrity Pledge: I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* Student Name: Kyran Heijkoop
*/

public class Alcohol extends Beverage {

	private boolean isWeekend;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	public boolean isWeekend() {
		return isWeekend;
	}

	public double calcPrice() {
		double price = addSizePrice();
		
		if (isWeekend) {
			price += .6;
			return price;
		}
		
		return price;
	}

	@Override
	public String toString() {
		return super.toString() + "," + isWeekend + "," + calcPrice();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Alcohol) {
			Alcohol temp = (Alcohol) obj;
			return  temp.getBevName().equals(this.getBevName()) && temp.getType() == this.getType() && 
					temp.getSize() == this.getSize() && temp.isWeekend == this.isWeekend;
		}
		
		else {
			return false;
		}
		
	}
	
	
}
