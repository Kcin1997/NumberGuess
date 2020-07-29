package Number_Guess;
import java.util.Random;


public class Guess {

	private static int guessCount;
	private static Random randSeed;

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
		guessCount = (guessCount <= 0 ) ? 0 : guessCount + 1;
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
	  //TODO: Complete
		incrementGuess();
		System.out.printf("Current Guess: %d\n", guess);
		return GuessResult.CORRECT;
	}
	
	public static void randomGuess() {
		resetGuesses();
		int lowestNumber = 0;
		int highestNumber = 100;
		int currentGuess = randomNumber();
		GuessResult lastResult =  checkGuess(currentGuess);  // guess random number between 1 and 100 to start.
		while (lastResult != GuessResult.CORRECT ) {
			switch (lastResult) {
			case TOO_HIGH:
				highestNumber = currentGuess + 1;
				break;
			case TOO_LOW:
				lowestNumber = currentGuess + 1;
				break;
			}
			currentGuess = randomNumber(lowestNumber, highestNumber);
			lastResult = checkGuess(currentGuess);
		}
	}
	
	public static void binaryGuess() {
		resetGuesses();
		int lowestNumber = 0;
		int highestNumber = 100;
		int currentGuess = 50;
		GuessResult lastResult =  checkGuess(currentGuess);  // guess 50 to start
		while (lastResult != GuessResult.CORRECT ) {
			switch (lastResult) {
			case TOO_HIGH:
				highestNumber = currentGuess + 1;
				break;
			case TOO_LOW:
				lowestNumber = currentGuess + 1;
				break;
			}
			currentGuess = (highestNumber - lowestNumber) / 2 + highestNumber;
			lastResult = checkGuess(currentGuess);
		}
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
		System.out.printf("Correct. The hidden number was %d.", hiddenNumber);	
	}
	
	private static int getUserGuess() {
		//TODO : finish 
		return 1;
	}
	
}
