/* 
* Class: CMSC203 CRN 20931
* Program: Assignment #6
* Instructor: Khandan Monshi
* Summary of Description: Smoothie class that contains metods specific to the smoothie beverage, extends the beverage class
* Due Date: 12/15/2024
* Integrity Pledge: I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* Student Name: Kyran Heijkoop
*/

public class Smoothie extends Beverage{
	
	private int numOfFruits;
	private boolean addProtein;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	public boolean getAddProtein() {
		return addProtein;
	}

	public double calcPrice() {
		double price = addSizePrice() + .5 * numOfFruits;
		
		if (addProtein) {
			price += 1.5;
			return price;
		}
		
		return price;
	}

	@Override
	public String toString() {
		return super.toString() + "," + addProtein + "," + numOfFruits + "," + calcPrice();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Smoothie) {
			Smoothie temp = (Smoothie) obj;
			return  temp.getBevName().equals(this.getBevName()) && temp.getType() == this.getType() && 
					temp.getSize() == this.getSize() && temp.numOfFruits == this.numOfFruits && temp.addProtein == this.addProtein;
		}
		
		else {
			return false;
		}
		
	}
	
	
}
