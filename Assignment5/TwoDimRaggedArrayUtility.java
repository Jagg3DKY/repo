
/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Class responsible for converting data file to ragged array, and calculating values from data from the ragged array
 * Due: 12/3/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Kyran Heijkoop
*/

import java.io.*;
import java.util.Scanner;


public class TwoDimRaggedArrayUtility {
	
	public static final int MAX_ROWS = 10;
	public static final int MAX_COLS = 10;
	
	public TwoDimRaggedArrayUtility() {
		
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException{
		
		int rows = 0, col = 0;
		String line;
		double[][] tempArray = new double[MAX_ROWS][MAX_COLS];
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			String[] numbers = line.split(" ");
			
			for(String s : numbers) {
				tempArray[rows][col] = Double.parseDouble(s);
				col++;
			}
			
			col = 0;
			rows++;
		}
		
		double[][] raggedArray = new double[rows][];
		int cols = 0;
		for (int i = 0; i < rows; i++) {
			for (double d : tempArray[i]) {
				if (d == 0) {
					break;
				}
				cols++;
			}
			raggedArray[i] = new double[cols];
			for (int j = 0; j < cols; j++) {
				raggedArray[i][j] = tempArray[i][j];
			}
			cols = 0;
		}
		scanner.close();
		return raggedArray;
	}
	
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException, IOException{
		
		FileWriter fileWriter = new FileWriter(outputFile);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				fileWriter.write(data[i][j] + " ");
			}
			fileWriter.write("\n");
		}
		
		fileWriter.close();
	}

	
	public static double getTotal(double[][] data) {
		
		double total = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		
		return total;
	}

	
	public static double getAverage(double[][] data) {
		
		double total = 0;
		int elements = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
				elements++;
			}
		}
		
		return total / (double) elements;
	}

	
	public static double getRowTotal(double[][] data, int row) {
		
		double total = 0;

		for (int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		
		return total;
	}

	
	public static double getColumnTotal(double[][] data, int col) {
		
		double total = 0;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				total += data[i][col];
			}
		}
		
		return total;
	}

	
	public static double getHighestInRow(double[][] data, int row) {
		
		double highest = -999999;

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
			}
		}
		
		return highest;
	}

	
	public static int getHighestInRowIndex(double[][] data, int row) {
		
		int highestIndex = -1;
		double highest = getHighestInRow(data, row);
		
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] == highest) {
				highestIndex = i;
			}
		}
		
		return highestIndex;
	}

	
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = 999999;

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		
		return lowest;
	}

	
	public static int getLowestInRowIndex(double[][] data, int row) {
		
		int lowestIndex = -1;
		double lowest = getLowestInRow(data, row);
		
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] == lowest) {
				lowestIndex = i;
			}
		}
		
		return lowestIndex;
	}

	
	public static double getHighestInColumn(double[][] data, int col) {
		
		double highest = -999999;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] > highest) {
					highest = data[i][col];
				}
			}
		}
		
		return highest;
	}

	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
		int highestIndex = -1;
		double highest = getHighestInColumn(data, col);

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] == highest) {
					highestIndex = i;
				}
			}
		}
		
		return highestIndex;
	}

	
	public static double getLowestInColumn(double[][] data, int col) {
		
		double lowest = 999999;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
				}
			}
		}
		
		return lowest;
	}

	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		int lowestIndex = -1;
		double lowest = getLowestInColumn(data, col);

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] == lowest) {
					lowestIndex = i;
				}
			}
		}
		
		return lowestIndex;
	}

	
	public static double getHighestInArray(double[][] data) {
		
		double highest = -999999;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		
		return highest;
	}

	
	public static double getLowestInArray(double[][] data) {
		
		double lowest = 999999;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		
		return lowest;
	}
	
}
