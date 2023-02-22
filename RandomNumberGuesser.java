import java.util.Scanner;
public class RandomNumberGuesser {

	public static void main(String[] args) {
		boolean inRange = false;
		boolean cont = true;
		String again = "";
		Scanner sObj = new Scanner(System.in); // Scanner object
		RNG obj = new RNG(); // RNG object
		int nextGuess;
		int lowGuess = 0;
		int highGuess = 100;
		int randNum = obj.rand();
		obj.resetCount(); // Sets the counter to 0
		System.out.println("This is a random number guessing game where you will be trying to guess the number that is randomly generated\n");
		System.out.println("Enter your first guess(0-100): ");
		nextGuess = sObj.nextInt();
		while (obj.getCount() < 7 && cont) { //The main loop that repeats the program until user either guesses it right or exceeds the number of guesses
			if (obj.getCount() != 0 || again.equals("y")) { //This asks the user for each guess except the first one
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				nextGuess = sObj.nextInt();
			}
			inRange = obj.inputValidation(nextGuess, lowGuess, highGuess); //This calls a method from the RNG class to validate the input
			while (inRange == false) {
				
				if (inRange == false){ //This lets the make another guess because their first one was wrong
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					nextGuess = sObj.nextInt();
				}
				inRange = obj.inputValidation(nextGuess, lowGuess, highGuess); //This calls a method from the RNG class to validate the input
			}
			System.out.println("Number of guesses is " + obj.getCount()); //This informs the user of how much guesses they have done
			
			if (nextGuess > randNum) { //Checks to see if the user's guess was too high
				highGuess = nextGuess;
				System.out.println("You guess is too high");
			}
			else if (nextGuess < randNum){ //Checks to see if the user's guess was too low
				lowGuess = nextGuess;
				System.out.println("Your guess is too low");
			}
			else if (nextGuess == randNum) { //This asks the user if they want to try again and if they do, the program resets and starts all over
				System.out.println("Congratulations!!! You got it!!!\nDo you want to try again(y/n)? ");
				sObj.nextLine();
				again = sObj.nextLine();
				if (again.equals("y")) {
					obj.resetCount();
					randNum = obj.rand();
					lowGuess = 0;
					highGuess = 100;
					continue;
				}
				else {
					cont = false;
				}
			}
		}
		
		if (obj.getCount() > 7) { // Checks to see if the user has exceeded the number of guesses and informs them if they did
			System.out.println("\nYou have exceeded the number of guesses");
		}
		System.out.println("\n\nThank you for playing this game.\nProgrammer: Abass Shikur");
		
	}
}
