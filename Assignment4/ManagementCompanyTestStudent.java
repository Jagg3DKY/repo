import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testManagementCompany() {
        ManagementCompany company = new ManagementCompany();
        assertEquals("", company.getName());
        assertEquals("", company.getTaxID());
        assertEquals(0.0, company.getMgmFeePer(), 0.01);
        assertNotNull(company.getPlot());
        assertEquals(0, company.getPropertiesCount());
    }

    @Test
    void testManagementCompanyStringStringDouble() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        assertEquals("XYZ Corp", company.getName());
        assertEquals("12345", company.getTaxID());
        assertEquals(15.0, company.getMgmFeePer(), 0.01);
        assertNotNull(company.getPlot());
        assertEquals(0, company.getPropertiesCount());
    }

    @Test
    void testManagementCompanyStringStringDoubleIntIntIntInt() {
        ManagementCompany company = new ManagementCompany("ABC Ltd.", "67890", 12.0, 5, 5, 20, 20);
        assertEquals("ABC Ltd.", company.getName());
        assertEquals("67890", company.getTaxID());
        assertEquals(12.0, company.getMgmFeePer(), 0.01);
        assertNotNull(company.getPlot());
        assertEquals(5, company.getPlot().getX());
        assertEquals(5, company.getPlot().getY());
        assertEquals(20, company.getPlot().getWidth());
        assertEquals(20, company.getPlot().getDepth());
        assertEquals(0, company.getPropertiesCount());
    }

    @Test
    void testManagementCompanyManagementCompany() {
        ManagementCompany originalCompany = new ManagementCompany("XYZ Corp", "12345", 15.0);
        ManagementCompany copiedCompany = new ManagementCompany(originalCompany);
        
        assertEquals(originalCompany.getName(), copiedCompany.getName());
        assertEquals(originalCompany.getTaxID(), copiedCompany.getTaxID());
        assertEquals(originalCompany.getMgmFeePer(), copiedCompany.getMgmFeePer(), 0.01);
        assertEquals(originalCompany.getPropertiesCount(), copiedCompany.getPropertiesCount());
        assertEquals(originalCompany.getPlot().getX(), copiedCompany.getPlot().getX());
        assertEquals(originalCompany.getPlot().getY(), copiedCompany.getPlot().getY());
        assertEquals(originalCompany.getPlot().getWidth(), copiedCompany.getPlot().getWidth());
        assertEquals(originalCompany.getPlot().getDepth(), copiedCompany.getPlot().getDepth());
    }

    @Test
    void testAddPropertyStringStringDoubleString() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        Property property = new Property("Sunny Villa", "Miami", 2000.0, "John Doe");
        int index = company.addProperty("Sunny Villa", "Miami", 2000.0, "John Doe");
        
        assertEquals(0, index);
        assertEquals(1, company.getPropertiesCount());
        assertEquals("Sunny Villa", company.getProperties()[0].getPropertyName());
    }

    @Test
    void testAddPropertyStringStringDoubleStringIntIntIntInt() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        int index = company.addProperty("Oceanfront House", "Malibu", 5000.0, "Alice", 3, 4, 6, 3);
        
        assertEquals(0, index);
        assertEquals(1, company.getPropertiesCount());
        assertEquals("Oceanfront House", company.getProperties()[0].getPropertyName());
        assertEquals(3, company.getProperties()[0].getPlot().getX());
        assertEquals(4, company.getProperties()[0].getPlot().getY());
    }

    @Test
    void testAddPropertyProperty() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        Property property = new Property("Mountain Retreat", "Aspen", 3500.0, "Bob", 5, 5, 10, 10);
        int index = company.addProperty(property);
        assertEquals(-3, index);
        assertEquals(0, company.getPropertiesCount());
        
        Property prop = new Property("Mountain Retreat", "Aspen", 3500.0, "Bob", 5, 5, 2, 3);
        int i = company.addProperty(prop);
        assertEquals(0, i);
        assertEquals(1, company.getPropertiesCount());
    }

    @Test
    void testRemoveLastProperty() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        company.addProperty("Sunny Villa", "Miami", 2000.0, "John Doe");
        company.addProperty("Oceanfront House", "Malibu", 5000.0, "Alice", 5, 5, 2, 2);
        
        assertEquals(2, company.getPropertiesCount());
        company.removeLastProperty();
        assertEquals(1, company.getPropertiesCount());
    }

    @Test
    void testIsPropertiesFull() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        assertFalse(company.isPropertiesFull());
        
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            company.addProperty("Property " + i, "City " + i, 1000.0, "Owner " + i, i, i, 1, 1);
        }
        
        assertTrue(company.isPropertiesFull());
    }

    @Test
    void testGetPropertiesCount() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        assertEquals(0, company.getPropertiesCount());
        
        company.addProperty("Sunny Villa", "Miami", 2000.0, "John Doe");
        assertEquals(1, company.getPropertiesCount());
        
        company.addProperty("Oceanfront House", "Malibu", 5000.0, "Alice", 7, 7, 2, 1);
        assertEquals(2, company.getPropertiesCount());
    }

    @Test
    void testGetTotalRent() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        company.addProperty("Sunny Villa", "Miami", 2000.0, "John Doe");
        company.addProperty("Oceanfront House", "Malibu", 5000.0, "Alice", 2, 3, 4, 5);
        
        assertEquals(7000.0, company.getTotalRent(), 0.01);
    }

    @Test
    void testGetHighestRentProperty() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        company.addProperty("Sunny Villa", "Miami", 2000.0, "John Doe");
        company.addProperty("Oceanfront House", "Malibu", 5000.0, "Alice", 6, 2, 2, 3);
        
        Property highestRentProperty = company.getHighestRentProperty();
        assertEquals("Oceanfront House", highestRentProperty.getPropertyName());
    }

    @Test
    void testIsMangementFeeValid() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        assertTrue(company.isMangementFeeValid());
        
        company = new ManagementCompany("XYZ Corp", "12345", -5.0);
        assertFalse(company.isMangementFeeValid());
        
        company = new ManagementCompany("XYZ Corp", "12345", 105.0);
        assertFalse(company.isMangementFeeValid());
    }

    @Test
    void testToString() {
        ManagementCompany company = new ManagementCompany("XYZ Corp", "12345", 15.0);
        company.addProperty("Sunny Villa", "Miami", 2000.0, "John Doe");
        company.addProperty("Oceanfront House", "Malibu", 5000.0, "Alice", 1, 2, 5, 5);
        
        String expected = "List of the properties for XYZ Corp, taxID: 12345\n______________________________________________________\n" +
                          "Sunny Villa,Miami,John Doe,2000.0\n" +
                          "Oceanfront House,Malibu,Alice,5000.0\n" +
                          "______________________________________________________\n\n total management Fee: 1050.0";
        assertEquals(expected, company.toString());
    }
}
