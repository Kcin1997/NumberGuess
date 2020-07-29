package Number_Guess;

import java.util.Scanner;

public class GuessDriver {

	public static void main(String[] args) {
		System.out.println("Number Guessing Program");
		System.out.println("=======================");
		Scanner sc = new Scanner(System.in);
		String input = "4";
		do {
			System.out.printf("Choose a program:\n1. Guess what the computer is thinking.\n2. Computer guesses what you are thinking. (easy)\n"
					+ "3. Computer guesses what you are thinking. (hard)\n4. Exit\n");
			input = sc.next();
			switch(input) {
				case "1":
					Guess.userGuess();
					break;
				case "2":
					Guess.randomGuess();
					break;
				case "3":
					Guess.binaryGuess();
					break;
				case "4":
					System.out.println("Thank You");
					break;
				default:
					System.out.println("Please imput a number between 1 and 4.");
					break;
			}
			
		} while( !input.equals("4") );

	}

}
