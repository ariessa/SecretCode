// SecretCode
//
// By: Nurul Ariessa Binti Norramli


import java.util.Scanner;
import java.lang.*;

public class SecretCode {

  private String inString;
  private String outString;
  private int stringLen;

  // Default Constructor
  public SecretCode() {
		this.inString = "";
		this.outString = "";
		this.stringLen = 0;
  }

  // Overloaded Constructor to initialise input string
  public SecretCode(String inString) {
		inString = "test";
  }

	// Setter Method for inString
	public void setInString(String newString) {
		this.inString = newString;
	}

	// Setter Method for outString
	public void setOutString(String newString) {
		this.outString = newString;
	}

	// Setter Method for stringLen
	public void setStringLen(int newStringLen) {
		this.stringLen = newStringLen;
	}

	// Getter Method for inString
	public String getInString() {
		return inString;
	}

	// Getter method for outString
	public String getOutString() {
		return outString;
	}

	// Getter method for stringLen
	public int stringLen() {
		return stringLen;
	}

  // Returns the length of input string
  public int getStringLen(String inString) {

		// Omits whitespace in calculation of length
		return inString.replace(" ", "").length();
  }

  // Checks the validity of string
  public boolean checkStringValidity(String inString) {

		Boolean isChar = inString.matches("[a-zA-Z]*");
		Boolean isWhitespace = inString.contains(" ");

		if (isChar == true || isWhitespace == true)
			return true;

		else
			return false;
  }

  // Shifts every character based on the length of input string
  public String shiftChar(String inString, int stringLen) {

		StringBuffer result = new StringBuffer();
		char ch;

		for (int i = 0; i < inString.length(); i++) {

			// Whitespace
			if (Character.isLetter(inString.charAt(i)) == false) {
				// Added 15 at the end because it works
				// Observed offset is 16, 102 (W) - 86 (f) = 16 (g)
				ch = (char) (((27 + stringLen - 97) % 27 + 97) + 15);
			}

			// Letters
			else {
				ch = (char)(((int)inString.charAt(i) + stringLen - 97) % 27 + 97);
			}

			if (Character.isLetter(ch)) {
				result.append(ch);
			}

			else {
				result.append(" ");
			}
		}

		String outString = result.toString();
		setOutString(outString);

		return getOutString();
	}


  // Shifts every character by 4 spaces and turns them into uppercase letter
  public String caesarCipher(String inString, int shift) {

		StringBuffer result = new StringBuffer();

    for (int i = 0; i < inString.length(); i++)
    {
      char ch = (char)(((int)inString.charAt(i) + shift - 65) % 26 + 65);

      if (Character.isLetter(ch))
        result.append(ch);

			else
				result.append(" ");
    }

		String str = result.toString();

		setOutString(str);

		return getOutString();
  }


  // Uses a keyword and Vigenere Table to encipher input string
  public String vigenereCipher(String inString) {

		final String key = "JAVA";
		String result = "";
		int j = 0;

		inString = inString.toUpperCase();

		for (int i = 0; i < inString.length(); i++) {
			char ch = inString.charAt(i);

			if (ch < 'A' || ch > 'Z')
				continue;

			result += (char) ((ch + key.charAt(j) - 2 * 'A') % 26 + 'A');
			j = ++j % key.length();
		}

		setOutString(result);

		return getOutString();
	}

}
