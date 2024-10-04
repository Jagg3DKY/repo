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

import java.util.Scanner;


public class PatientDriverApp {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String fname, mname, lname, address, city, state, pnum, ename, enumb, name, date, practitioner;
		int zipCode;
		double charge;
		
		
		//Getting Patient Information
		System.out.println("Enter patients first name: ");
		fname = in.nextLine();
		
		System.out.println("Enter patients middle name: ");
		mname = in.nextLine();
		
		System.out.println("Enter patients last name: ");
		lname = in.nextLine();

		System.out.println("Enter patients address: ");
		address = in.nextLine();

		System.out.println("Enter patients city: ");
		city = in.nextLine();

		System.out.println("Enter patients state: ");
		state = in.nextLine();
		
		System.out.println("Enter patients zipcode: ");
		zipCode = in.nextInt();
		in.nextLine();
		
		while (zipCode < 1 || String.valueOf(zipCode).length() != 5) { //checks if zipCode is a valid zipCode
			System.out.println("zipCode must be 5 positive digits\nEnter patients zipcode: ");
			zipCode = in.nextInt();
			in.nextLine();
		}

		System.out.println("Enter patients phone number: ");
		pnum = in.nextLine();

		System.out.println("Enter patients emergency contact name: ");
		ename = in.nextLine();

		System.out.println("Enter patients emergency contact number: ");
		enumb = in.nextLine();
		
		//Create Patient object
		Patient patient = new Patient(fname, mname, lname, address, city, state, zipCode, pnum, ename, enumb);
		
		//initializing first procedure object
		Procedure pr1 = new Procedure();
		System.out.println("Enter name of first procedure: ");
		name = in.nextLine();
		pr1.setName(name);
		System.out.println("Enter date of first procedure: ");
		date = in.nextLine();
		pr1.setDate(date);
		System.out.println("Enter practitioner of first procedure: ");
		practitioner = in.nextLine();
		pr1.setPractitioner(practitioner);
		System.out.println("Enter charge of first procedure: ");
		charge = in.nextDouble();
		in.nextLine();
		
		while (charge < 0) { //check if charge is negative
			
			System.out.println("Charge must not be negative\nEnter charge of first procedure: ");
			charge = in.nextDouble();
			in.nextLine();
		}
		
		pr1.setCharges(charge);

		
		//initializing second procedure object
		System.out.println("Enter name of second procedure: ");
		name = in.nextLine();
		System.out.println("Enter date of second procedure: ");
		date = in.nextLine();
		
		Procedure pr2 = new Procedure(name, date);
		
		System.out.println("Enter practitioner of second procedure: ");
		practitioner = in.nextLine();
		pr2.setPractitioner(practitioner);
		System.out.println("Enter charge of second procedure: ");
		charge = in.nextDouble();
		in.nextLine();
		
		while (charge < 0) { //check if charge is negative
			
			System.out.println("Charge must not be negative\nEnter charge of second procedure: ");
			charge = in.nextDouble();
			in.nextLine();
		}
		
		pr2.setCharges(charge);
		
		//initializing third procedure object
		System.out.println("Enter name of third procedure: ");
		name = in.nextLine();
		System.out.println("Enter date of third procedure: ");
		date = in.nextLine();
		System.out.println("Enter practitioner of third procedure: ");
		practitioner = in.nextLine();
		System.out.println("Enter charge of third procedure: ");
		charge = in.nextDouble();
		in.nextLine();
		
		while (charge < 0) { //check if charge is negative
			
			System.out.println("Charge must not be negative\nEnter charge of third procedure: ");
			charge = in.nextDouble();
			in.nextLine();
		}
		
		Procedure pr3 = new Procedure(name, date, practitioner, charge);
		
		//Displaying all information
		System.out.println("\n\nPatient info: ");
		DisplayPatient(patient);
		System.out.println();
		DisplayProcedure(pr1);
		System.out.println();
		DisplayProcedure(pr2);
		System.out.println();
		DisplayProcedure(pr3);
		System.out.println("\nTotal Charges: $" + calculateTotalCharges(pr1, pr2, pr3));
		System.out.println("\nStudent Name: Kyran Heijkoop\nMC#: M21112856\nDue Date: 10/4/2024");
		in.close();
	}
	
	public static void DisplayPatient(Patient patient) {
		System.out.println(patient.toString());
	}
	
	public static void DisplayProcedure(Procedure procedure) {
		System.out.println(procedure.toString());
	} 
	
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
		return p1.getCharges() + p2.getCharges() + p3.getCharges();
	}
}
