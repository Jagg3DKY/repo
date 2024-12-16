import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {

    private BevShop bevShop;

    @BeforeEach
    void setUp() throws Exception {
        bevShop = new BevShop();
    }

    @AfterEach
    void tearDown() throws Exception {
        bevShop = null;
    }

    @Test
    void testBevShop() {
        assertNotNull(bevShop);
    }

    @Test
    void testIsValidTime() {
        assertTrue(bevShop.isValidTime(8));
        assertTrue(bevShop.isValidTime(23));
        assertFalse(bevShop.isValidTime(7));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    void testGetMaxNumOfFruits() {
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    void testGetMinAgeForAlcohol() {
        assertEquals(21, bevShop.getMinAgeForAlcohol());
    }

    @Test
    void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(6));
        assertFalse(bevShop.isMaxFruit(4));
    }

    @Test
    void testGetMaxOrderForAlcohol() {
        assertEquals(3, bevShop.getMaxOrderForAlcohol());
    }

    @Test
    void testIsEligibleForMore() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertTrue(bevShop.isEligibleForMore());

        bevShop.processAlcoholOrder("Mojito", Size.MEDIUM);
        bevShop.processAlcoholOrder("Margarita", Size.SMALL);
        bevShop.processAlcoholOrder("Whiskey", Size.LARGE);

        assertFalse(bevShop.isEligibleForMore());
    }

    @Test
    void testGetNumOfAlcoholDrink() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertEquals(0, bevShop.getNumOfAlcoholDrink());

        bevShop.processAlcoholOrder("Mojito", Size.MEDIUM);
        assertEquals(1, bevShop.getNumOfAlcoholDrink());
    }

    @Test
    void testIsValidAge() {
        assertTrue(bevShop.isValidAge(21));
        assertFalse(bevShop.isValidAge(20));
    }

    @Test
    void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertNotNull(bevShop.getCurrentOrder());
        assertEquals("John", bevShop.getCurrentOrder().getCustomer().getName());
    }

    @Test
    void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, false, false);
        assertEquals(Type.COFFEE, bevShop.getCurrentOrder().getBeverage(0).getType());
    }

    @Test
    void testProcessAlcoholOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processAlcoholOrder("Mojito", Size.MEDIUM);
        assertEquals(Type.ALCOHOL, bevShop.getCurrentOrder().getBeverage(0).getType());
    }

    @Test
    void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);
        assertEquals(Type.SMOOTHIE, bevShop.getCurrentOrder().getBeverage(0).getType());
    }

    @Test
    void testFindOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.getCurrentOrder().generateOrder();
        bevShop.startNewOrder(12, Day.TUESDAY, "Jane", 30);
        bevShop.getCurrentOrder().generateOrder();
        assertEquals(1, bevShop.findOrder(bevShop.getOrderAtIndex(1).getOrderNo()));
        assertEquals(-1, bevShop.findOrder(15));
    }

    @Test
    void testTotalOrderPrice() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, false, true);
        bevShop.processAlcoholOrder("Mojito", Size.MEDIUM);
        assertEquals(5.0, bevShop.totalOrderPrice(0), 0.01);
    }

    @Test
    void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, false, false);
        bevShop.processAlcoholOrder("Mojito", Size.MEDIUM);

        bevShop.startNewOrder(12, Day.TUESDAY, "Jane", 30);
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);

        assertEquals(10.5, bevShop.totalMonthlySale(), 0.01);
    }

    @Test
    void testTotalNumOfMonthlyOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.startNewOrder(12, Day.TUESDAY, "Jane", 30);
        assertEquals(2, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    void testGetCurrentOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertNotNull(bevShop.getCurrentOrder());
    }

    @Test
    void testGetOrderAtIndex() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.startNewOrder(12, Day.TUESDAY, "Jane", 30);
        assertNotNull(bevShop.getOrderAtIndex(1));
        assertNull(bevShop.getOrderAtIndex(2));
    }

    @Test
    void testSortOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.getCurrentOrder().generateOrder();
        bevShop.startNewOrder(14, Day.MONDAY, "Jane", 30);
        bevShop.getCurrentOrder().generateOrder();
        bevShop.startNewOrder(9, Day.TUESDAY, "FRANK", 42);
        bevShop.getCurrentOrder().generateOrder();
        bevShop.sortOrders();
        assertTrue(bevShop.getOrderAtIndex(0).getOrderNo() < bevShop.getOrderAtIndex(1).getOrderNo() && bevShop.getOrderAtIndex(1).getOrderNo() < bevShop.getOrderAtIndex(2).getOrderNo());
    }

    @Test
    void testToString() {
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, false, false);
        System.out.println(bevShop.toString());
        assertTrue(bevShop.toString().equals("0,10,MONDAY,John,25,Espresso,SMALL,false,false,2.0"));
    }

}