/* 
* Class: CMSC203 CRN 20931
* Program: Assignment #6
* Instructor: Khandan Monshi
* Summary of Description: Driver Class for the BevShop Class
* Due Date: 12/15/2024
* Integrity Pledge: I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* Student Name: Kyran Heijkoop
*/

import java.util.Scanner;

public class BevShopDriver {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        BevShop shop = new BevShop();  
        Customer customer1 = new Customer("John", 23); 
        Customer customer2 = new Customer("Ray", 18);  

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");
        
        System.out.println("Start please a new order:");
        shop.startNewOrder(10, Day.FRIDAY, customer1.getName(), customer1.getAge());
        System.out.println("Your Total Order for now is " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

        if (shop.isValidAge(customer1.getAge())) {
            System.out.println("Your age is above 20 and you are eligible to order alcohol");
            System.out.println("Would you please add an alcohol drink");

            shop.processAlcoholOrder("Beer", Size.MEDIUM);
            System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
            System.out.println("The Total Price on the Order is: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

            System.out.println("Your current alcohol drink order is less than 3");
            shop.processAlcoholOrder("Wine", Size.LARGE);
            System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
            System.out.println("The Total Price on the Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

            System.out.println("Your current alcohol drink order is less than 3");
            shop.processAlcoholOrder("Whiskey", Size.SMALL);
            System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
            System.out.println("The Total Price on the Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

            System.out.println("You have a maximum alcohol drinks for this order");

            System.out.println("Would you please add a COFFEE to your order: ");
            shop.processCoffeeOrder("Espresso", Size.MEDIUM, false, true);
            System.out.println("Total items on your order is " + shop.getCurrentOrder().getTotalItems());
            System.out.println("The Total Price on the Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

            System.out.println("#------------------------------------#");

        }
        
        System.out.println("Would you please start a new order");
        shop.startNewOrder(10, Day.SUNDAY, customer2.getName(), customer2.getAge());
        System.out.println("The Total Price on the Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

        System.out.println("Would you please add a SMOOTHIE to order");
        shop.processSmoothieOrder("Fruit Smoothie", Size.MEDIUM, 3, true);
        System.out.println("The Total Price on the Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

        System.out.println("Would you please add a SMOOTHIE to order");
        shop.processSmoothieOrder("Green Smoothie", Size.LARGE, 2, false);
        System.out.println("The Total Price on the Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

        System.out.println("Would you please add a COFFEE to order");
        shop.processCoffeeOrder("Latte", Size.SMALL, true, false);
        System.out.println("The Total Price on the Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

        System.out.println("Would you please add a drink");
        shop.processSmoothieOrder("Bananna Strawberry", Size.SMALL, 2, false);
        
        System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The Total price on the Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));

        System.out.println("Total price on the second Order: " + shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));
        System.out.println("Total amount for all Orders: " + shop.totalMonthlySale());
        
        int totalSmoothie = 0, totalCoffee = 0, totalAlcohol = 0;
        for (int i = 0; i < shop.totalNumOfMonthlyOrders(); i++) {
        	totalSmoothie += shop.getOrderAtIndex(i).findNumOfBeveType(Type.SMOOTHIE);
        	totalCoffee += shop.getOrderAtIndex(i).findNumOfBeveType(Type.COFFEE);
        	totalAlcohol += shop.getOrderAtIndex(i).findNumOfBeveType(Type.ALCOHOL);
        }
        
        System.out.println("Your total number of Smoothie Orders is: " + totalSmoothie);
        System.out.println("Your total number of Coffee Orders is: " + totalCoffee);
        System.out.println("Your total number of Alcohol Orders is: " + totalAlcohol);
        
        scanner.close();
    }
}