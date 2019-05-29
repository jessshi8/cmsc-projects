import java.util.List;
import java.util.Map;

/**
 * Check rules on UMD passwords, as described at
 * https://identity.umd.edu/password/changepassword
 * 
 * A password must be at least 8 and no more than 32 characters in length.
 * A password must contain at least one character from each of the following
 * sets:
 * 
 * Uppercase alphabet (A-Z)
 * Lowercase alphabet (a-z)
 * Number (0-9) and special characters (such as # @ $ & among others
 * import java.util.List;
import java.util.Map;

/**
 * Check rules on UMD passwords, as described at
 * https://identity.umd.edu/password/changepassword
 * 
 * A password must be at least 8 and no more than 32 characters in length.
 * A password must contain at least one character from each of the following
 * sets:
 * 
 * Uppercase alphabet (A-Z)
 * Lowercase alphabet (a-z)
 * Number (0-9) and special characters (such as # @ $ & among others
 * 
 * A password may not begin or end with the space character.
 * A password may not contain more than two consecutive identical
 * characters.
 * A password may not be (or be a variation of ) a dictionary word in
 * English or many other languages. This includes making simple substitutions of
 * digits or punctuation that resemble alphabetic characters (such as replacing
 * the letter S in a common word with the $...
 * Passwords should not contain: carriage return, linefeed, /, \, or a
 * trailing * symbol).
 */
public class CheckPasswords {
	/** Count the number of uppercase letters in password; can assume only ASCII characters */
	static int countUppercaseLetters(String password) {
		int upperCase = 0;

		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				upperCase++;
			}
		}
		return upperCase;
	}

	/** Count the number of lowercase letters in password; can assume only ASCII characters */
	static int countLowercaseLetters(String password) {
		int lowerCase = 0;

		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				lowerCase++;
			}
		}
		return lowerCase;
	}

	/** Count the longest sequences of consecutive identical characters; can assume only ASCII characters */
	static int longestConsecutiveIdenticalCharacters(String password) {
		int run = 1;
		int longestRun = 0;

		for (int i = 0; i < password.length() - 1; i++) {
			while (password.charAt(i) == password.charAt(i + 1)) {
				run++;
				i++;
			}
			if (run > longestRun) {
				longestRun = run;
				run = 1;
			}
			run = 1;
		}
		return longestRun;
	}

	/**
	 * Check to see if a password is similar to a dictionary word. It is too similar
	 * if the dictionary word is contained in the password when ignoring case and
	 * treating '1' and 'l' as identical , 'o' and '0' as identical, and 's' and '$'
	 * as identical, and the length of the password is at least 5 characters longer
	 * than the word.
	 */
	static boolean similarToWord(String word, String password) {
		password = password.toLowerCase();
		word = word.toLowerCase();
		password = password.replace('1', 'l');
		password = password.replace('0', 'o');
		password = password.replace('$', 's');

		if (password.length() < word.length() || password.length() >= word.length() + 5) {
			return false;
		}
		for (int i = 0; i < password.length() - word.length() + 1; i++) {
			if (password.substring(i, i + word.length()).equals(word)) {
				return true;
			}
		}
		return false;
	}

	/** Check to see if password is an acceptable password by UMD standards */
	static boolean checkPassword(String password, List<String> dictionary) {
		int nonLetterCount = 0;
		int lowerCount = 0;
		int upperCount = 0;
		
		// Check length of password
		if (password.length() >= 8 && password.length() <= 32) {
			
			// Check for variation of dictionary word
			for (int i = 0; i < dictionary.size(); i++) {
				if (CheckPasswords.similarToWord(dictionary.get(i), password)) {
					return false;
				}
			}
			
			for (int x = 0; x < password.length(); x++) {
				char c = password.charAt(x);
				
				// Check for lower case letters 
				if (Character.isLowerCase(c)) {
					lowerCount++;
				}
				
				// Check for upper case letters
				if (Character.isUpperCase(c)) {
					upperCount++;
				}
				
				// Check for non letters
				if (c >= 32 && c <= 46 ||
						c >= 48 && c <= 57 ||
						c >= 58 && c <= 64) {
					nonLetterCount++;
				}
				
				// Return true if password contains all above characters
				if (lowerCount > 0 && upperCount > 0 && nonLetterCount > 0) {
					return true;
				}
				
				// Check for space at beginning/end
				if (password.startsWith(" ") ||
						password.endsWith(" ")) {
					return false;
				}
				
				// Check for carriage return, linefeed, /, and \
				if (c == 10 || c == 13 || c == 47 || c == 92) {
					return false;
				}
				
				// Check for trailing * symbol
				if (password.endsWith("*")) {
					return false;
				}
				
				// Check for more than 2 consecutive identical characters
				if 
				(CheckPasswords.longestConsecutiveIdenticalCharacters(password) > 2) {
					return false;
				}
			}
		}
		return false;
	}
}
