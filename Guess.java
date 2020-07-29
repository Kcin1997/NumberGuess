package Number_Guess;
import java.util.Random;
import java.util.Scanner;


public class Guess {

	private static int guessCount;
	private static Random randSeed;
	private static Scanner sc;

	public enum GuessResult {
		TOO_HIGH, TOO_LOW, CORRECT
	}
	
	private static int randomNumber(int minNumber, int maxNumber) {
		if (randSeed == null) {
			randSeed = new Random();
		}
		return randSeed.nextInt(maxNumber - minNumber) + minNumber;
	}
	
	private static int randomNumber() {
		return randomNumber(1,101);
	}
	
	private static void incrementGuess() {
		guessCount = (guessCount < 0 ) ? 0 : guessCount + 1;
	}
	
	private static void resetGuesses() {
		guessCount = 0;
	}
	
	public static int getGuessCount() {
		return guessCount;
	}
	
	/** guessResult : sends a guess to the user and returns if it is too high, low or correct
	 * 
	 * @param guess guessed number
	 * @return enum for too high, too low, or correct responses.
	 */
	private static GuessResult checkGuess(int guess) {
		if (sc == null) {
			sc = new Scanner(System.in);
		}
		
		System.out.printf("Is your number %d?\nType \'h\' if the number is too high, \'l\' if the number is too low, or \'c\'c if the number is correct.\n", guess);
		String input = sc.next();
		switch (input) {
			case "h":
			case "H":
				incrementGuess();
				return GuessResult.TOO_HIGH;
			case "l":
			case "L":
				incrementGuess();
				return GuessResult.TOO_LOW;
			case "c":
			case "C":
				incrementGuess();
				return GuessResult.CORRECT;
			default:
				System.out.println("Invalid input.");
				return checkGuess(guess);
		}
	}
	
	public static void randomGuess() {
		resetGuesses();
		int lowestNumber = 0;
		int highestNumber = 100;
		int currentGuess = randomNumber();
		System.out.println("Please choose a number between 1 and 100.");
		GuessResult lastResult =  checkGuess(currentGuess);  // guess random number between 1 and 100 to start.
		while (lastResult != GuessResult.CORRECT ) {
			switch (lastResult) {
			case TOO_HIGH:
				highestNumber = currentGuess - 1;
				break;
			case TOO_LOW:
				lowestNumber = currentGuess + 1;
				break;
			default:
			}
			currentGuess = randomNumber(lowestNumber, highestNumber);
			lastResult = checkGuess(currentGuess);
		}
		System.out.printf("The computer took %d guesses to find your number.", getGuessCount() );
	}
	
	public static void binaryGuess() {
		resetGuesses();
		int lowestNumber = 0;
		int highestNumber = 100;
		int currentGuess = 50;
		System.out.println("Please choose a number between 1 and 100.");
		GuessResult lastResult =  checkGuess(currentGuess);  // guess 50 to start
		while (lastResult != GuessResult.CORRECT ) {
			switch (lastResult) {
			case TOO_HIGH:
				highestNumber = currentGuess - 1;
				break;
			case TOO_LOW:
				lowestNumber = currentGuess + 1;
				break;
			default:
			}
			currentGuess = (highestNumber - lowestNumber) / 2 + lowestNumber;
			lastResult = checkGuess(currentGuess);
		}
		System.out.printf("The computer took %d guesses to find your number.", getGuessCount() );
	}
	
	public static void userGuess() {
		resetGuesses();
		int hiddenNumber = randomNumber();
		int userGuess = getUserGuess();
		while( userGuess != hiddenNumber) {
			if (userGuess < hiddenNumber) {
				System.out.println("Too Low");
			} else {
				System.out.println("Too High");
			}
			userGuess = getUserGuess();
		}
		System.out.printf("Correct. The hidden number was %d.\n", hiddenNumber);
		System.out.printf("You took %d guesses to figure out the hidden number.\n", getGuessCount() );
	}
	
	private static int getUserGuess() {
		if (sc == null) {
			sc = new Scanner(System.in);
		}
		int userNum;
		incrementGuess();
		System.out.println("Please guess a number:");
		userNum = sc.nextInt();
		return userNum;
	}
	
}
