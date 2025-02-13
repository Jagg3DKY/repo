import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	String ps1 = "aBh&7", ps2 = "kjh51!", ps3 = "*JKIH653%", ps4 = "aBh&7d3", ps5 = "aBBBh&7", ps6 = "aryKI^%";
	
    @BeforeEach
    public void setUp() throws Exception {
        
    }

    @AfterEach
    public void tearDown() throws Exception {
    
    }

    /**
     * Test if the password is less than 6 characters long.
     * This test should throw a LengthException for second case.
     */
    @Test
    public void testIsValidPasswordTooShort() {
        try {
            PasswordCheckerUtility.isValidLength(ps1);
            fail("Expected LengthException not thrown");
        } catch (LengthException e) {
            assertEquals("The password must be at least 6 characters long", e.getMessage());
        }
    }
    
    /**
     * Test if the password has at least one uppercase alpha character
     * This test should throw a NoUpperAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoUpperAlpha() {
        try {
            PasswordCheckerUtility.hasUpperAlpha(ps2);
            fail("Expected NoUpperAlphaException not thrown");
        } catch (NoUpperAlphaException e) {
            assertEquals("The password must contain at least one uppercase alphabetic character", e.getMessage());
        }
    }
    
    /**
     * Test if the password has at least one lowercase alpha character
     * This test should throw a NoLowerAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoLowerAlpha() {
        try {
            PasswordCheckerUtility.hasLowerAlpha(ps3);
            fail("Expected NoLowerAlphaException not thrown");
        } catch (NoLowerAlphaException e) {
            assertEquals("The password must contain at least one lowercase alphabetic character", e.getMessage());
        }
    }

    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsWeakPassword() {
        try {
            PasswordCheckerUtility.isWeakPassword(ps4);
            fail("Expected WeakPasswordException not thrown");
        } catch (WeakPasswordException e) {
            assertEquals("The password is OK but weak - it contains fewer than 10 characters.", e.getMessage());
        }
    }
    
    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsValidPasswordInvalidSequence() {
        try {
            PasswordCheckerUtility.NoSameCharInSequence(ps5);
            fail("Expected InvalidSequenceException not thrown");
        } catch (InvalidSequenceException e) {
            assertEquals("The password cannot contain more than two of the same character in sequence.", e.getMessage());
        }
    }
    
    /**
     * Test if the password has at least one digit
     * One test should throw a NoDigitException
     */
    @Test
    public void testIsValidPasswordNoDigit() {
        try {
            PasswordCheckerUtility.hasDigit(ps6);
            fail("Expected NoDigitException not thrown");
        } catch (NoDigitException e) {
            assertEquals("The password must contain at least one digit", e.getMessage());
        }
    }
    
    /**
     * Test correct passwords
     * This test should not throw an exception
     */
    @Test
    public void testIsValidPasswordSuccessful() {
        try {
            boolean result = PasswordCheckerUtility.isValidPassword("Valid123!");
            assertTrue(result);
        } catch (Exception e) {
            fail("No exception should be thrown for valid password");
        }
    }
    
    /**
     * Test the invalidPasswords method
     * Check the results of the ArrayList of Strings returned by the validPasswords method
     */
    @Test
    public void testInvalidPasswords() {
    	ArrayList<String> passwords = new ArrayList<>(Arrays.asList("aBh&7", "*JKIH653%", "kjh51!", "aBBBh&7", "(0hgU7&", "aryKI^%", "ghJK765", "dVbe&^%"));
        ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
        
        assertTrue(invalidPasswords.contains("aBh&7 The password must be at least 6 characters long"));
        assertTrue(invalidPasswords.contains("kjh51! The password must contain at least one uppercase alphabetic character"));
        assertTrue(invalidPasswords.contains("*JKIH653% The password must contain at least one lowercase alphabetic character"));
        assertTrue(invalidPasswords.contains("aBBBh&7 The password cannot contain more than two of the same character in sequence."));
        assertFalse(invalidPasswords.contains("(0hgU7&"));
        assertFalse(invalidPasswords.contains("aryKI^%"));
        assertTrue(invalidPasswords.contains("ghJK765 The password must contain at least one special character"));
        assertTrue(invalidPasswords.contains("dVbe&^% The password must contain at least one digit"));
    }
}