import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int minNum = 1;
        int maxNum = 100;
        int maxAttempts = 5;
        int totalAttempts = 0;
        int rounds = 0;

        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            totalAttempts += numberGame(minNum, maxNum, maxAttempts, rand, sc);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! You played " + rounds + " round(s) and your total score is " + totalAttempts + ".");
    }

    public static int numberGame(int minNum, int maxNum, int maxAttempts, Random rand, Scanner sc) {
        int targetNumber = rand.nextInt(maxNum - minNum + 1) + minNum;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game! Guess a number between " + minNum + " and " + maxNum + ".");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                return attempts;
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try guessing a higher number.");
            } else {
                System.out.println("Too high! Try guessing a lower number.");
            }
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
        return 0;
    }
}