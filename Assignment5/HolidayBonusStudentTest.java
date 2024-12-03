import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HolidayBonusStudentTest {

    private double[][] dataSet1;
    private double[][] dataSet2;

    @BeforeEach
    public void setUp() {
        // Initialize test data sets for the test methods
        dataSet1 = new double[][] { {1, 2, 3}, {4, 5}, {6, 7, 8} };
        dataSet2 = new double[][] { {-7500, 1200}, {20, 50, 100, 200, 5000, 2000},  {3000, -50, 10000}, {50}, {700, 800, 2000, 60, 7000, 20000} };
    }

    @Test
    public void testCalculateHolidayBonus() {
        // Call the calculateHolidayBonus method on dataSet1
        double[] result1 = HolidayBonus.calculateHolidayBonus(dataSet1);

        assertEquals(3000.0, result1[0]);
        assertEquals(4000.0, result1[1]);
        assertEquals(15000.0, result1[2]);
        
        double[] result2 = HolidayBonus.calculateHolidayBonus(dataSet2);

        assertEquals(5000.0, result2[0]);
        assertEquals(12000.0, result2[1]);
        assertEquals(10000.0, result2[2]);
        assertEquals(2000.0, result2[3]);
        assertEquals(17000.0, result2[4]);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double result1 = HolidayBonus.calculateTotalHolidayBonus(dataSet1);
        assertEquals(22000, result1, 0.001);
        
        double result2 = HolidayBonus.calculateTotalHolidayBonus(dataSet2);
        assertEquals(46000, result2, 0.001);
    }
}
