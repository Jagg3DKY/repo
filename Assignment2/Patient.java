/* 
*Class: CMSC203 CRN 20931
*Program: Assignment 2
*Instructor: Khandan Monshi
*Summary of Description: Create a Driver Class and Two Object Classes for a Patient and 3 Procedures
*Due Date: 10/04/2024
*Integrity Pledge: I pledge that I have completed the programming assignment independently.
*I have not copied the code from a student or any source.
*Kyran Heijkoop
*/

public class Patient {

		private String firstName, middleName, lastName, address, city, state, phoneNumber, emergencyName, emergencyNumber;
		private int zipCode;
		
		
		//no arg constructor
		public Patient() {
			
		}
		//name constructor
		public Patient(String firstName, String middleName, String lastName) {
			
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
		}
		
		//all attribute constructor
		public Patient(String firstName, String middleName, String lastName, String address, String city, String state, 
				int zipCode, String phoneNumber, String emergencyName, String emergencyNumber) {
			
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
			this.phoneNumber = phoneNumber;
			this.emergencyName = emergencyName;
			this.emergencyNumber = emergencyNumber;
		}
		
		//mutators for each attribute
		public String getFirstName() {
			return firstName;
		}
		
		public String getMiddleName() {
			return middleName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public String getAddress() {
			return address;
		}
		
		public String getCity() {
			return city;
		}
		
		public String getState() {
			return state;
		}
		
		public int getZipCode() {
			return zipCode;
		}
		
		public String getPhoneNumber() {
			return phoneNumber;
		}
		
		public String getEmergencyName() {
			return emergencyName;
		}
		
		public String getEmergencyNumber() {
			return emergencyNumber;
		}
		
		
		
		//accessors for each attribute
		public void setFirstName(String s) {
			firstName = s;
		}
		
		public void setMiddleName(String s) {
			middleName = s;
		}
		
		public void setLastName(String s) {
			lastName = s;
		}
		
		public void setAddress(String s) {
			address = s;
		}
		
		public void setCity(String s) {
			city = s;
		}
		
		public void setState(String s) {
			state = s;
		}
		
		public void setZipCode(int x) {
			zipCode = x;
		}
		
		public void setPhoneNumber(String s) {
			phoneNumber = s;
		}
		
		public void setEmergencyName(String s) {
			emergencyName = s;
		}
		
		public void setEmergencyNumber(String s) {
			emergencyNumber = s;
		}
		
		
		//method to return full name
		public String buildFullName() {
			return firstName + " " + middleName + " " + lastName;
		}
		
		//method to return full address
		public String buildAddress() {
			return address + " " + city + " " + state + " " + zipCode;
		}
		
		//method to return emergency contact
		public String buildEmergencyContact() {
			return emergencyName + " " + emergencyNumber;
		}
		
		// toString method
		public String toString() {
			return " Name: " + buildFullName() + "\n Address: " + buildAddress() + "\n Emergency Contact: " + buildEmergencyContact();
		}
}	
	
