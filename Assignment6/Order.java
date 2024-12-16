/* 
* Class: CMSC203 CRN 20931
* Program: Assignment #6
* Instructor: Khandan Monshi
* Summary of Description: Order class containing data of any specific order. Uses customer and beverage classes to create a complete order containing multiple beverages, and one customer
* Due Date: 12/15/2024
* Integrity Pledge: I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* Student Name: Kyran Heijkoop
*/

import java.util.Random;
import java.util.ArrayList;


public class Order implements OrderInterface, Comparable<Order> {
	
	
	private int orderNumber, orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages = new ArrayList<>();
	Random rand = new Random();
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		
	}
	
    public int generateOrder() {
    	this.orderNumber = rand.nextInt(10000, 90001);
    	return this.orderNumber;
    }

    public int getOrderNo() {
    	return this.orderNumber;
    }

    public int getOrderTime() {
    	return this.orderTime;
    }
    
    public Day getOrderDay() {
    	return this.orderDay;
    }
    
    public Customer getCustomer() {
    	return this.cust;
    }
    
    public boolean isWeekend() {
    	if (orderDay.ordinal() > 4) {
    		return true;
    	}
    	return false;
    }
    
    public Beverage getBeverage(int itemNo) {
    	return beverages.get(itemNo);
    }
    
    public int getTotalItems() {
    	return beverages.size();
    }
    
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
    	beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }
	
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, isWeekend()));
	}

    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
    	beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    public double calcOrderTotal() {
    	double orderTotal = 0;
    	
    	for (Beverage b : beverages) {
    		orderTotal += b.calcPrice();
    	}
    	
    	return orderTotal;
    }
    
    public int findNumOfBeveType(Type type) {
    	int totalBevs = 0;
    	
    	for (Beverage b : beverages) {
    		if (b.getType() == type) {
    			totalBevs++;
    		}
    	}
    	
    	return totalBevs;
    }
    
    public String toString() {
    	String s = "" + orderNumber + "," + orderTime + "," + orderDay + "," + cust.toString();
    	
    	for (Beverage b : beverages) {
    		s += "," + b.toString();
    	}
    	
    	return s;
    }
    
    public int compareTo(Order anotherOrder) {
    	
    	if (this.getOrderNo() == anotherOrder.getOrderNo()) {
    		return 0;
    	}
    	
    	else if (this.getOrderNo() > anotherOrder.getOrderNo()) {
    		return 1;
    	}
    	
    	else {
    		return -1;
    	}
    }
}
