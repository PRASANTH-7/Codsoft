import java.util.*;
public class Number_Game{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int score = 0;
        int rounds = 0;
        String playAgain;

        do {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;
            rounds++;

            System.out.println("\nRound " + rounds + ": Guess the number between " + lowerBound + " and " + upperBound + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > generatedNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + generatedNumber + " in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1);  // More points for fewer attempts
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the number. It was " + generatedNumber + ".");
            }

            System.out.println("Your score so far: " + score);
            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = scanner.next().toLowerCase();
        } while (playAgain.equals("yes"));

        System.out.println("Thank you for playing! Your final score is " + score + " after " + rounds + " rounds.");
        scanner.close();
    }
}
