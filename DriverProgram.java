// DriverProgram
//
// By: Nurul Ariessa Binti Norramli

import java.util.Scanner;

public class DriverProgram {

	// Clears the screen using backspace
	static void clearScreen() {
		for(int clear = 0; clear < 500; clear++) {
    	System.out.println("\b") ;
  	}
	}

  public static void main(String[] args) {

		int choice = 0;
		int stringLen = 0;
		Boolean isValid = false;
		Scanner scan = new Scanner(System.in);
		SecretCode code = new SecretCode();

    while (choice < 1 || choice > 3) {
			clearScreen();

			// Display menu
			System.out.println("\t\tChoose Encoding Method");
			System.out.println("\t\t----------------------");
			System.out.println("\n\n\t\t1. Simple Character Shifting");
			System.out.println("\t\t2. Caesar Cipher");
			System.out.println("\t\t3. Vigenere Cipher");
			System.out.print("\n\t\tEnter Your Choice [1|2|3]: ");

			if (scan.hasNextInt()) {
        choice = scan.nextInt() ;
    	}
			else {
        System.out.println("Sorry, couldn't understand you!");
    	}

			//choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
				case 1:

					// Checks string validity
					while (isValid == false) {
						clearScreen();

						// Takes input from user
						System.out.println("Enter string: ");
						String userInput = scan.nextLine();

						// Convert all characters in string to lowercase
						userInput = userInput.toLowerCase();

						code.setInString(userInput);

						isValid = code.checkStringValidity(code.getInString());

						if (isValid == true) {
							stringLen = code.getStringLen(code.getInString());
						}

						// Encode string using shiftChar()
						code.shiftChar(userInput, stringLen);
					}

					// Display result to screen
					System.out.println("inString: " + code.getInString());
					System.out.println("len: " + stringLen);
					System.out.println("outString: " + code.getOutString());

					break;

				case 2:

					clearScreen();

					// Takes input from user
					System.out.println("Enter string: ");
					String userInput = scan.nextLine();

					code.setInString(userInput);

					// Encode string using caesarCipher()
					code.caesarCipher(userInput, 4);

					// Display result to screen
					System.out.println("inString: " + code.getInString());
					System.out.println("len: " + code.getStringLen(code.getInString()));
					System.out.println("outString: " + code.getOutString());

					break;

				case 3:

					clearScreen();

					// Takes input from user
					System.out.println("Enter string: ");
					userInput = scan.nextLine();

					code.setInString(userInput);

					// Encode string using vigenereCipher()
					code.vigenereCipher(userInput);

					// Display result to screen
					System.out.println("inString: " + code.getInString());
					System.out.println("len: " + code.getStringLen(code.getInString()));
					System.out.println("outString: " + code.getOutString());

					break;

			}
		}
  }
}
