import java.util.Scanner;

public class SecondEnhance {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Guessing Game! Enter a number to choose a level.");
		System.out.println();		
		System.out.println("1. Beginner (between 1 and 10).");
		System.out.println("2. Intermediate (between 1 and 100).");
		System.out.println("3. Advanced (between 1 and 1,000).");
		System.out.println("4. Expert (between 1 and 10,000).");
		
		int level = input.nextInt();
		boolean playGame = true;
		int guess = 0;
		int[] guessList = {};
		
		while (level < 1 || level > 4) {
			System.out.println("Error! Please enter a number from 1 to 4.");
			level = input.nextInt();
		}		
		
		while (playGame) {
			int targetNum = (int)(Math.random() * Math.pow(10, level)) + 1;
			// System.out.println(targetNum);
			guess = 1;
			
			System.out.println("Starting from level " + level + ".");
			System.out.println("Please enter a number.");
			int userGuess = input.nextInt();
			
			while (userGuess != targetNum) {	
				if (userGuess > targetNum) {
					System.out.println("Your guess is too high! Try aiming lower.");
					userGuess = input.nextInt();
					guess++;
				} else if (userGuess < targetNum) {
					System.out.println("Your guess is too low! Try aiming higher.");
					userGuess = input.nextInt();
					guess++;
				}
			}
			
			System.out.println("You've guessed then number in " + guess + " guesses.");	
			guessList = updateArray(guess, guessList);
			System.out.println("Would you like to play again? Enter true or false.");
			playGame = input.nextBoolean();			
		}
		
		System.out.println("Thanks for playing!");
		System.out.println("Here's how many guesses it took you in each game:");
		printArray(guessList);
		
	}

	public static int[] updateArray(int number, int[] oldArray) {
		int[] newArray = new int[(oldArray.length + 1)];
		
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		
		newArray[(newArray.length - 1)] = number;
		return newArray;
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i]);
			System.out.print(", ");
		}
		
		System.out.print(array[(array.length - 1)]);
		System.out.println();
	}
}