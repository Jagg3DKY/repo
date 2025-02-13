import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class PasswordCheckerUtility {
	
	
	static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		
		if (!password.equals(passwordConfirm)){
			throw new UnmatchedException("Passwords do not match");
		}
		
	}
	

	static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	

	static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (String password : passwords) {
			try {
				isValidPassword(password);				
			}
			
			catch(PasswordCheckerInvalidExceptions e) {
				invalidPasswords.add(password + " " + e.getMessage());
			}
			
		}
		
		return invalidPasswords;
	}
	

	static boolean hasBetweenSixAndNineChars(String password) {
		
		int len = password.length();
		return len >=6 && len <= 9;
	}
	

	static boolean hasDigit(String password) throws NoDigitException{
		
		for (int i = 0; i <password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		
		throw new NoDigitException("The password must contain at least one digit");
	}
	

	static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		
		for (int i = 0; i <password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	}
	

	static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            throw new NoSpecialCharacterException("The password must contain at least one special character");
        }
        
        return true;
	}
	

	static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		
		for (int i = 0; i <password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}
	

	static boolean isValidLength(String password) throws LengthException{
		
		if (password.length() >= 6) { 
			return true;
		}
		
		throw new LengthException("The password must be at least 6 characters long");
	}
	

	static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		
		isValidLength(password);
		hasDigit(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasSpecialChar(password);
		NoSameCharInSequence(password);
		return true;
	}
	

	static boolean isWeakPassword(String password) throws WeakPasswordException{
		if (password.length() >= 6 && password.length() <=9) {
			throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters.");
		}
		
		return false;
	}
	

	static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		
		for (int i = 0; i <password.length()-2; i++) {
			if (password.charAt(i) == password.charAt(i+1) && password.charAt(i) == password.charAt(i+2)) {
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
			}
		}
		
		return true;
	}
	
}
