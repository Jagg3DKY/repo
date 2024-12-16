import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTestStudent {

    @Test
    public void testCustomerAge() {
        Customer customer = new Customer("John", 25);
        assertEquals(25, customer.getAge());
    }

    @Test
    public void testCustomerName() {
        Customer customer = new Customer("John", 25);
        assertEquals("John", customer.getName());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("John", 25);
        assertTrue(customer.toString().equals("John,25"));
    }
}