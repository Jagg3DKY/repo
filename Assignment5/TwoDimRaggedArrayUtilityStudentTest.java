import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityStudentTest {
	
    private double[][] dataSet1;
    private double[][] dataSet2;
    private File newFile1;
    private File newFile2;
    
	@BeforeEach
	void setUp() throws Exception {
	
		newFile1 = new File("test.txt");
		newFile2 = new File("test2.txt");
		dataSet1 = new double[][] { {1, 2, 3}, {4, 5}, {6, 7, 8} };
        dataSet2 = new double[][] { {-7500, 1200}, {20, 50, 100, 200, 5000, 2000},  {3000, -50, 10000}, {50}, {700, 800, 2000, 60, 7000, 20000} };
    }
	
	@AfterEach
	void tearDown() throws Exception {
	    if (newFile1.exists()) {
	    	newFile1.delete();
	    }
	    if (newFile2.exists()) {
	    	newFile2.delete();
	    }
	}
	
	@Test
	void testWriteToFileAndReadFile() throws FileNotFoundException, IOException {
		
		TwoDimRaggedArrayUtility.writeToFile(dataSet1, newFile1);
		TwoDimRaggedArrayUtility.writeToFile(dataSet2, newFile2);
		
		double[][] dataSet3 = TwoDimRaggedArrayUtility.readFile(newFile1);
		double[][] dataSet4 = TwoDimRaggedArrayUtility.readFile(newFile2);
		
		assertEquals(dataSet1.length, dataSet3.length,"1");
        for (int i = 0; i < dataSet1.length; i++) {
            assertArrayEquals(dataSet1[i], dataSet3[i], "2");
        }
        
		assertEquals(dataSet2.length, dataSet4.length, "3");
        for (int i = 0; i < dataSet2.length; i++) {
            assertArrayEquals(dataSet2[i], dataSet4[i], "4");
        }
	}

	@Test
	void testGetTotal() {
		
		assertEquals(TwoDimRaggedArrayUtility.getTotal(dataSet1), 36);
		assertEquals(TwoDimRaggedArrayUtility.getTotal(dataSet2), 44630);
	}

	@Test
	void testGetAverage() {
		assertEquals(TwoDimRaggedArrayUtility.getAverage(dataSet1), 4.5);
		assertEquals(TwoDimRaggedArrayUtility.getAverage(dataSet2), 2479.45, .1);
	}

	@Test
	void testGetRowTotal() {
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), 6);
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), 9);
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2), 21);
		
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 0), -6300);
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 1), 7370);
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 2), 12950);
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 3), 50);
		assertEquals(TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 4), 30560);
	}

	@Test
	void testGetColumnTotal() {
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), 11);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1), 14);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2), 11);
		
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 0), -3730);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 1), 2000);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 2), 12100);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 3), 260);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 4), 12000);
		assertEquals(TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 5), 22000);

	}

	@Test
	void testGetHighestInRow() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), 3);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 1), 5);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), 8);
		
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 0), 1200);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 1), 5000);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 2), 10000);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 3), 50);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 4), 20000);
	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0), 2);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1), 1);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2), 2);
		
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 0), 1);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 1), 4);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 2), 2);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 3), 0);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 4), 5);
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), 1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1), 4);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), 6);
		
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 0), -7500);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 1), 20);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 2), -50);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 3), 50);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 4), 60);
	}

	@Test
	void testGetLowestInRowIndex() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0), 0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1), 0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2), 0);
		
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 0), 0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 1), 0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 2), 1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 3), 0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 4), 3);
	}

	@Test
	void testGetHighestInColumn() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0), 6);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1), 7);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), 8);
		
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 0), 3000);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 1), 1200);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 2), 10000);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 3), 200);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 4), 7000);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 5), 20000);
	}

	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0), 2);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1), 2);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2), 2);
		
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 0), 2);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 1), 0);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 2), 2);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 3), 1);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 4), 4);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 5), 4);
	}

	@Test
	void testGetLowestInColumn() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), 1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), 2);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2), 3);
		
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 0), -7500);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 1), -50);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 2), 100);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 3), 60);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 4), 5000);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 5), 2000);
	}

	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0), 0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1), 0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2), 0);
		
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 0), 0);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 1), 2);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 2), 1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 3), 4);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 4), 1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 5), 1);
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), 8);
		assertEquals(TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), 20000);
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), 1);
		assertEquals(TwoDimRaggedArrayUtility.getLowestInArray(dataSet2), -7500);
	}

}
