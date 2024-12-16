/* 
* Class: CMSC203 CRN 20931
* Program: Assignment #6
* Instructor: Khandan Monshi
* Summary of Description: Coffee class that contains metods specific to the coffee beverage, extends the beverage class
* Due Date: 12/15/2024
* Integrity Pledge: I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* Student Name: Kyran Heijkoop
*/

public class Coffee extends Beverage{
	
	private boolean extraShot, extraSyrup;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}

	public boolean getExtraShot() {
		return extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public double calcPrice() {
		double price = addSizePrice();
		
		if (extraShot && extraSyrup) {
			price++;
			return price;
		}
		
		else if (extraShot || extraSyrup) {
			price += .5;
			return price;
		}
		
		return price;
	}

	@Override
	public String toString() {
		return super.toString() + "," + extraShot + "," + extraSyrup + "," + calcPrice();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Coffee) {
			Coffee temp = (Coffee) obj;
			return  temp.getBevName().equals(this.getBevName()) && temp.getType() == this.getType() && 
					temp.getSize() == this.getSize() && temp.extraShot == this.extraShot && temp.extraSyrup == this.extraSyrup;
		}
		
		else {
			return false;
		}
		
	}
	
	
}
