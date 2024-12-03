
/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Class responsible calculating holiday bonuses, and total of holiday bonuses 
 * given data pulled from the ragged array created in the TwoDimRaggedArrayUtility class
 * Due: 12/3/24
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Kyran Heijkoop
*/

public class HolidayBonus {
	
	static final double HIGHEST_BONUS = 5000;
	static final double REGULAR_BONUS = 2000;
	static final double LOWEST_BONUS = 1000;
	
	public HolidayBonus() {
		
	}
	
	
	static double[] calculateHolidayBonus(double[][] data) {
		
		double[] holidayBonus = new double[data.length];
		int longestRow = -1;
		int highestInColIndex;
		int lowestInColIndex;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > longestRow) {
				longestRow = data[i].length;
			}
		}
		
		for (int col = 0; col < longestRow; col++) {
			
			highestInColIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
			lowestInColIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
			
			if (highestInColIndex == lowestInColIndex) {
				holidayBonus[highestInColIndex] += 5000;
			}
			
			else {
				for (int row = 0; row < data.length; row++) {
					if (col < data[row].length) {
						if (row != highestInColIndex && row != lowestInColIndex && data[row][col] >= 0) {
							holidayBonus[row] += 2000;
						}
						else if (row == highestInColIndex && data[row][col] >= 0) {
							holidayBonus[row] += 5000;
						}
						else if (row == lowestInColIndex && data[row][col] >= 0) {
							holidayBonus[lowestInColIndex] += 1000;
						}
					}
				}
			}
		}
		
		return holidayBonus;
	}
	
	
	static double calculateTotalHolidayBonus(double[][] data) {
		
		double total = 0;
		double[] holidayBonus = calculateHolidayBonus(data);
		
		for (int i = 0; i < holidayBonus.length; i++) {
			total += holidayBonus[i];
		}
		
		return total;
	}
}
