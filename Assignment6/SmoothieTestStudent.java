import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SmoothieTestStudent {

    @Test
    public void testSmoothiePrice() {
        Smoothie smoothie = new Smoothie("Berry Smoothie", Size.MEDIUM, 3, true);
        double price = smoothie.calcPrice();
        assertEquals(5.5, price);
    }

    @Test
    public void testNumOfFruits() {
        Smoothie smoothie = new Smoothie("Berry Smoothie", Size.LARGE, 4, false);
        double price = smoothie.calcPrice();
        assertEquals(5.0, price);
    }

    @Test
    public void testAddProtein() {
        Smoothie smoothie = new Smoothie("Berry Smoothie", Size.SMALL, 0, true);
        double price = smoothie.calcPrice();
        assertEquals(3.5, price);
    }
    
    public void testToString() {
    	Smoothie smoothie = new Smoothie("Berry Smoothie", Size.MEDIUM, 3, true);
        assertTrue(smoothie.toString().equals("Berry Smoothie,MEDIUM,3,true"));
    }

    
    @Test
    public void testCoffeeEquals() {
    	Smoothie smoothie1 = new Smoothie("Berry Smoothie", Size.MEDIUM, 3, true);
    	Smoothie smoothie2 = new Smoothie("Berry Smoothie", Size.MEDIUM, 3, true);
        assertTrue(smoothie1.equals(smoothie2));
    }
}