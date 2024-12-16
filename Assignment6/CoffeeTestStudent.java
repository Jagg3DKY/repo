import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoffeeTestStudent {

    @Test
    public void testCoffeePrice() {
        Coffee coffee = new Coffee("Espresso", Size.LARGE, true, false);
        double price = coffee.calcPrice();
        assertEquals(3.5, price);
    }

    @Test
    public void testCoffeeWithExtraShot() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, false);
        double price = coffee.calcPrice();
        assertEquals(2.5, price);
    }

    @Test
    public void testCoffeeWithExtraSyrup() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, false, true);
        double price = coffee.calcPrice();
        assertEquals(2.5, price);
    }
    
    @Test
    public void testToString() {
        Coffee coffee1 = new Coffee("Espresso", Size.SMALL, true, true);
        assertTrue(coffee1.toString().equals("Espresso,SMALL,true,true,3.0"));
    }

    @Test
    public void testCoffeeEquals() {
        Coffee coffee1 = new Coffee("Espresso", Size.SMALL, true, true);
        Coffee coffee2 = new Coffee("Espresso", Size.SMALL, true, true);
        assertTrue(coffee1.equals(coffee2));
    }
}