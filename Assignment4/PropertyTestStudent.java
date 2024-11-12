import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testProperty() {
        Property property = new Property();
        assertEquals("", property.getPropertyName());
        assertEquals("", property.getCity());
        assertEquals(0.0, property.getRentAmount(), 0.01); 
        assertEquals("", property.getOwner());
        assertNotNull(property.getPlot()); 
    }

    @Test
    void testPropertyStringStringDoubleString() {
        Property property = new Property("Sunny House", "Los Angeles", 2500.0, "John Doe");
        assertEquals("Sunny House", property.getPropertyName());
        assertEquals("Los Angeles", property.getCity());
        assertEquals(2500.0, property.getRentAmount(), 0.01);
        assertEquals("John Doe", property.getOwner());
        assertNotNull(property.getPlot()); 
    }

    @Test
    void testPropertyStringStringDoubleStringIntIntIntInt() {
        Property property = new Property("Beach Villa", "Santa Monica", 5000.0, "Alice", 5, 10, 20, 30);
        assertEquals("Beach Villa", property.getPropertyName());
        assertEquals("Santa Monica", property.getCity());
        assertEquals(5000.0, property.getRentAmount(), 0.01);
        assertEquals("Alice", property.getOwner());
        assertNotNull(property.getPlot()); 
        assertEquals(5, property.getPlot().getX());
        assertEquals(10, property.getPlot().getY());
        assertEquals(20, property.getPlot().getWidth());
        assertEquals(30, property.getPlot().getDepth());
    }

    @Test
    void testPropertyProperty() {
        Property originalProperty = new Property("Mountain Cabin", "Aspen", 4000.0, "Bob", 10, 20, 15, 25);
        Property copiedProperty = new Property(originalProperty);
        
        assertEquals(originalProperty.getPropertyName(), copiedProperty.getPropertyName());
        assertEquals(originalProperty.getCity(), copiedProperty.getCity());
        assertEquals(originalProperty.getRentAmount(), copiedProperty.getRentAmount(), 0.01);
        assertEquals(originalProperty.getOwner(), copiedProperty.getOwner());
        assertEquals(originalProperty.getPlot().getX(), copiedProperty.getPlot().getX());
        assertEquals(originalProperty.getPlot().getY(), copiedProperty.getPlot().getY());
        assertEquals(originalProperty.getPlot().getWidth(), copiedProperty.getPlot().getWidth());
        assertEquals(originalProperty.getPlot().getDepth(), copiedProperty.getPlot().getDepth());
    }

    @Test
    void testToString() {
        Property property = new Property("Oceanfront Property", "Miami", 7000.0, "Sarah");
        String expected = "Oceanfront Property,Miami,Sarah,7000.0";
        assertEquals(expected, property.toString());
    }
}