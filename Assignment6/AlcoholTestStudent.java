import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AlcoholTestStudent {

    @Test
    public void testAlcoholPrice() {
        Alcohol alcohol1 = new Alcohol("Beer", Size.MEDIUM, false);
        double price1 = alcohol1.calcPrice();
        Alcohol alcohol2 = new Alcohol("Whiskey", Size.LARGE, true);
        double price2 = alcohol2.calcPrice();
        assertEquals(2.5, price1);
        assertEquals(3.6, price2);
    }

    @Test
    public void testAlcoholEquals() {
        Alcohol alcohol1 = new Alcohol("Beer", Size.MEDIUM, true);
        Alcohol alcohol2 = new Alcohol("Beer", Size.MEDIUM, true);
        assertTrue(alcohol1.equals(alcohol2));
    }

    @Test
    public void testAlcoholType() {
    	Alcohol alcohol = new Alcohol("Whiskey", Size.LARGE, true);
        assertTrue(alcohol.toString().equals("Whiskey,LARGE,true,3.6"));
    }
}