/* 
* Class: CMSC203 CRN 20931
* Program: Assignment #6
* Instructor: Khandan Monshi
* Summary of Description: BevShop class that contains an arraylist of type Orders. Used to add Beverages to an order, check age for customers, and overall check data before creating new sales.
* Due Date: 12/15/2024
* Integrity Pledge: I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* Student Name: Kyran Heijkoop
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterface{

	private int alcoholicBevs;
	private int index = -1;
	private ArrayList<Order> orders = new ArrayList<>();
	
	public BevShop() {
		
	}
	
	public boolean isValidTime(int time) {
		return time >= 8 && time <= 23 ? true : false;
	}
	
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > MAX_FRUIT ? true : false;
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public boolean isEligibleForMore() {
		return alcoholicBevs < MAX_ORDER_FOR_ALCOHOL ? true : false;
	}

	public int getNumOfAlcoholDrink() {
		return alcoholicBevs;
	}

	public boolean isValidAge(int age) {
		return age >= MIN_AGE_FOR_ALCOHOL ? true : false;
	}

	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
		index++;
	}

	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.get(index).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	public void processAlcoholOrder(String bevName, Size size) {
		if (isEligibleForMore()) {
			orders.get(index).addNewBeverage(bevName, size);
			alcoholicBevs++;
		}
	}

	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		orders.get(index).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	public int findOrder(int orderNo) {
		
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		
		return -1;
	}

	public double totalOrderPrice(int orderNo) {
		return orders.get(orderNo).calcOrderTotal();
	}

	public double totalMonthlySale() {
		double totalSales = 0;
		
		for (Order o : orders) {
			totalSales += o.calcOrderTotal();
		}
		
		return totalSales;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	public Order getCurrentOrder() {
		return orders.get(index);
	}

	public Order getOrderAtIndex(int index) {
		if (index < totalNumOfMonthlyOrders()) {
			return orders.get(index);
		}
		return null;
	}

	public void sortOrders() {
		
		for (int i = 0; i < orders.size(); i++) {
			int startIndex = i;
			int newIndex = i;
			
			for (int j = i + 1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < orders.get(i).getOrderNo()) {
					newIndex = j;
				}
			}
			
			if (startIndex != newIndex) {
				Order temp = orders.get(startIndex);
				orders.set(startIndex, orders.get(newIndex));
				orders.set(newIndex, temp);
			}
		}
	}

	public String toString() {
		String s = "";
		
		for (Order o : orders) {
			s += o.toString();
		}
		
		return s;
	}
	
}

