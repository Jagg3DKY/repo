import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test the methods of PasswordChecker
 * @author Professor Kartchner
 *
 */
public class PasswordChecker_GFA_Test {
    ArrayList<String> passwords;
    String password1, password2;

    @BeforeEach
    public void setUp() throws Exception {
        passwords = new ArrayList<String>();
    }

    @AfterEach
    public void tearDown() throws Exception {
        passwords = null;
    }
    
    @Test
    public void testGetInvalidPasword() {
        PasswordCheckerUtility.getInvalidPasswords(passwords);
    }
    
    @Test
    public void testIsValidPasswordTooShort() {
        try {
            assertTrue(PasswordCheckerUtility.isValidPassword("abc12"));
        } catch (LengthException e) {
            assertTrue(true, "Successfully threw a LengthException");
        } catch (Exception e) {
            fail("Threw some other exception besides LengthException");
            System.out.println("line 49");
        }
    }
    
    @Test
    public void testIsValidPasswordSuccess() {
        try {
            assertEquals(true, PasswordCheckerUtility.isValidPassword("strongPWD1"));
        } catch (NoSpecialCharacterException e) {
            System.out.println(e.getMessage());
            assertTrue(true, "Successfully threw a NoSpecialCharacterException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail("Threw some other exception besides LengthException");
        }
    }
        
    @Test
    public void testIsValidPasswordTooShortThrowsSomeOtherExcep() {
        try {
            assertTrue(PasswordCheckerUtility.isValidPassword("abcABs"));
        } catch (LengthException e) {
            System.out.println(e.getMessage());
            assertTrue(true, "Successfully threw a LengthException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue(true, "Threw some other exception besides LengthException");
        }
    }
}