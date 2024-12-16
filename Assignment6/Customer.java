/* 
* Class: CMSC203 CRN 20931
* Program: Assignment #6
* Instructor: Khandan Monshi
* Summary of Description: Customer class that contains data specific to the customer, such as age and name.
* Due Date: 12/15/2024
* Integrity Pledge: I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* Student Name: Kyran Heijkoop
*/

public class Customer {
	
	private String name;
	private int age;
	
	public Customer(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer c){
		this.name = c.getName();
		this.age = c.getAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name + "," + age;
	}
	


}
