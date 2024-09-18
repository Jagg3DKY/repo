/*
* Class: CMSC 203 CRN 20931
* Program: Assignment 1
* Instructor: Khandan Monshi
* Description: First Assignment, meant to teach how to read from a file, use scanner and random objects, use loops, manipulate Strings, etc
* Due: 9/18/24
* Platform/compiler: Eclipse
* Integrity Pledge: I pledge that I have completed the programming assignment independently.
* I have not copied the code from a student or any source.
* Kyran Heijkoop
*/



import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class ESPGame {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//creating scanner and random objects
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		//creating variables
		String file, userGuess, color, name, description, dueDate;
		final String BLACK = "black", WHITE = "white", GRAY = "gray", SILVER = "silver",
				MAROON = "maroon", RED = "red", PURPLE = "purple", FUCHSIA = "fuchsia",
				GREEN = "green", LIME = "lime", OLIVE = "olive", YELLOW = "yellow", 
				NAVY = "navy", BLUE = "blue", TEAL = "teal", AQUA = "aqua";
		
		int randomInt, correctGuesses = 0;
		
		
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		System.out.print("Enter the filename: ");
		
		//creating scanner object to read file
		file = input.next();
		File colorFile = new File(file);
		Scanner fileInput = new Scanner(colorFile);
		input.nextLine();
		
		//Print all colors from file
		System.out.println("There are sixteen colors from a file:");
		
		while (fileInput.hasNext()) {
			System.out.println(fileInput.nextLine());
		}
		System.out.println();
		
		//Loop that obtains users guess, sets random color for system, and checks if users guess and systems color match
		for (int i = 1; i < 4; i++) {
			//Retrieve users guess
			System.out.print("Round " + i + "\n\n");
			System.out.println("I am thinking of a color");
			System.out.println("Is it one from the list of colors above?");
			System.out.println("Enter your guess: ");
			userGuess = input.next();
			
			//Selects random color for system
			randomInt = rand.nextInt(1, 17);

			switch(randomInt) {
				case 1:
					color = BLACK;
					break;
				case 2:
					color = WHITE;
					break;
				case 3:
					color = GRAY;
					break;
				case 4:
					color = SILVER;
					break;
				case 5:
					color = MAROON;
					break;
				case 6:
					color = RED;
					break;
				case 7:
					color = PURPLE;
					break;
				case 8:
					color = FUCHSIA;
					break;
				case 9:
					color = GREEN;
					break;
				case 10:
					color = LIME;
					break;
				case 11:
					color = OLIVE;
					break;
				case 12:
					color = YELLOW;
					break;
				case 13:
					color = NAVY;
					break;
				case 14:
					color = BLUE;
					break;
				case 15:
					color = TEAL;
					break;
				case 16:
					color = AQUA;
					break;
				default:
					System.out.println("Error");
					return;
			}
			//Sets users guess to lowercase and compares users guess to systems random color
			userGuess = userGuess.toLowerCase();
			System.out.println("\nI was thinking of " + color);
			if (userGuess.equals(color)) {
				correctGuesses++;
			}
		
		}
		//print game over and users score
		System.out.println("Game Over");
		System.out.println("You guessed " + correctGuesses + " out of 3 colors correctly\n");
		
		//Retrieve user data
		input.nextLine();
		System.out.println("Enter your name: ");
		name = input.nextLine();
		System.out.println("Describe yourself:");
		description = input.nextLine();
		System.out.println("Due Date: ");
		dueDate = input.nextLine();
		
		//print user data
		System.out.println("User Name: " + name);
		System.out.println("User Description: " + description);
		System.out.println("Date: " + dueDate);
		System.out.println("Programmer name: Kyran Heijkoop");

		
		//close scanners
		fileInput.close();
		input.close();
	}
}

