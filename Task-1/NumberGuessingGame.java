import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> scores = new ArrayList<>();

        int round = 1;
        boolean playAgain = true;

        System.out.println("====================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("====================================");

        while (playAgain) {

            System.out.println();
            System.out.println("Choose difficulty:");
            System.out.println("1. Easy   (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard   (1-200, 5 attempts)");

            int difficulty;

            while (true) {

                System.out.print("Enter choice: ");

                if (scanner.hasNextInt()) {

                    difficulty = scanner.nextInt();

                    if (difficulty >= 1 && difficulty <= 3) {
                        break;
                    }

                } else {

                    scanner.next();
                }

                System.out.println("Please enter 1, 2, or 3.");
            }

            int maxNumber;
            int maxAttempts;

            if (difficulty == 1) {

                maxNumber = 50;
                maxAttempts = 10;

            } else if (difficulty == 2) {

                maxNumber = 100;
                maxAttempts = 7;

            } else {

                maxNumber = 200;
                maxAttempts = 5;
            }

            int secretNumber = random.nextInt(maxNumber) + 1;

            int attempts = 0;
            boolean correct = false;

            System.out.println();
            System.out.println(
                    "I'm thinking of a number between 1 and "
                            + maxNumber + "."
            );

            System.out.println(
                    "You have " + maxAttempts + " attempts."
            );

            while (!correct && attempts < maxAttempts) {

                System.out.println();
                System.out.println(
                        "Attempt " + (attempts + 1)
                                + "/" + maxAttempts
                );

                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {

                    System.out.println(
                            "Please enter a valid number."
                    );

                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < 1 || guess > maxNumber) {

                    System.out.println(
                            "Please enter a number between 1 and "
                                    + maxNumber
                    );

                    continue;
                }

                attempts++;

                if (guess > secretNumber) {

                    System.out.println("Too High!");

                } else if (guess < secretNumber) {

                    System.out.println("Too Low!");

                } else {

                    System.out.println("Correct!");
                    correct = true;
                }
            }

            System.out.println();

            if (correct) {

                String result =
                        "Round " + round +
                        " — guessed in " +
                        attempts + " attempts";

                System.out.println(result);
                scores.add(result);

            } else {

                String result =
                        "Round " + round +
                        " — You Lost! Number was " +
                        secretNumber;

                System.out.println("You Lost!");
                System.out.println(
                        "The number was: " + secretNumber
                );

                scores.add(result);
            }

            System.out.print("Play again? (yes/no): ");
            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
            }

            round++;
        }

        System.out.println();
        System.out.println("====================================");
        System.out.println("              SCORE");
        System.out.println("====================================");

        for (String score : scores) {
            System.out.println(score);
        }

        System.out.println("====================================");
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
