import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {

    private Order order;
    private Customer customer;

    @BeforeEach
    void setUp() throws Exception {
        customer = new Customer("John Doe", 25);
        order = new Order(10, Day.MONDAY, customer);
        order.generateOrder();
    }

    @AfterEach
    void tearDown() throws Exception {
        order = null;
        customer = null;
    }

    @Test
    void testOrder() {
        assertNotNull(order);
        assertNotNull(order.getCustomer());
        assertEquals(customer, order.getCustomer());
    }

    @Test
    void testGenerateOrder() {
        int orderNumber = order.generateOrder();
        assertTrue(orderNumber >= 10000 && orderNumber <= 90000);
    }

    @Test
    void testGetOrderNo() {
        int orderNo = order.getOrderNo();
        assertTrue(orderNo >= 10000 && orderNo <= 90000);
    }

    @Test
    void testGetOrderTime() {
        assertEquals(10, order.getOrderTime());
    }

    @Test
    void testGetOrderDay() {
        assertEquals(Day.MONDAY, order.getOrderDay());
    }

    @Test
    void testGetCustomer() {
        assertEquals(customer, order.getCustomer());
    }

    @Test
    void testIsWeekend() {
        assertFalse(order.isWeekend());
        order = new Order(10, Day.SATURDAY, customer);
        assertTrue(order.isWeekend()); 
    }

    @Test
    void testGetBeverage() {
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        assertNotNull(order.getBeverage(0));
        assertEquals("Espresso", order.getBeverage(0).getBevName());
    }

    @Test
    void testGetTotalItems() {
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        order.addNewBeverage("Mojito", Size.LARGE);
        assertEquals(2, order.getTotalItems());
    }

    @Test
    void testAddNewBeverageStringSizeBooleanBoolean() {
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        assertEquals(1, order.getTotalItems());
        assertTrue(order.getBeverage(0) instanceof Coffee);
    }

    @Test
    void testAddNewBeverageStringSize() {
        order.addNewBeverage("Mojito", Size.LARGE);
        assertEquals(1, order.getTotalItems());
        assertTrue(order.getBeverage(0) instanceof Alcohol);
    }

    @Test
    void testAddNewBeverageStringSizeIntBoolean() {
        order.addNewBeverage("Berry Smoothie", Size.MEDIUM, 3, true);
        assertEquals(1, order.getTotalItems());
        assertTrue(order.getBeverage(0) instanceof Smoothie);
    }

    @Test
    void testCalcOrderTotal() {
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        order.addNewBeverage("Mojito", Size.MEDIUM);
        double total = order.calcOrderTotal();
        assertTrue(total > 0);
    }

    @Test
    void testFindNumOfBeveType() {
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        order.addNewBeverage("Mojito", Size.MEDIUM);
        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
    }

    @Test
    void testToString() {
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        String orderString = order.toString();
        assertTrue(orderString.contains("Espresso"));
    }

    @Test
    void testCompareTo() {
        Order order1 = new Order(10, Day.MONDAY, customer);
        order1.generateOrder(); 
        Order order2 = new Order(10, Day.MONDAY, customer);
        order2.generateOrder();
        
        int result = order1.compareTo(order2);
        assertTrue(result != 0);
    }

}