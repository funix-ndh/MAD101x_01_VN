import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/*
 * Review how lotto work
 * Let's say we have set A = {0,1,2,3,...,99} and variable x which { x ∈ A | x is an integer }
 * When we pick one number from set A => probability to pick exact x is 1/100
 * two numbers need to pick first number from set A (size = 100)
 * => after first number size A remain 99 (reduce by 1)
 * => probability to pick correct is 1/100 * 1/99
 *
 * conclusion:
 *   fact: f(1) = 1/100
 *   f(n) = f(n-1) * 1/(100 - n + 1)
 *
 * lotto game is very hard to win
 */
public final class Main {

    private static final Random random = new Random();
    private static final Scanner sc = new Scanner(System.in);
    private static double amount = 1000000;
    private static final double[] winPool = { 0, 70, 4500, 300000, 20000000 };

    public static void main(final String[] args) {
        while (true) {
            System.out.println("=============================================");
            System.out.println("=                 GUESS GAME                =");
            System.out.println("=============================================");
            System.out.println("0. Exit");
            System.out.println("1. Pick one number from 0-99");
            System.out.println("2. Pick two numbers from 0-99");
            System.out.println("3. Pick three numbers from 0-99");
            System.out.println("4. Pick four numbers from 0-99");

            final int inputN = getChoice();

            // exit game
            if (inputN == 0) {
                break;
            }

            playGame(inputN);
        }
    }

    private static void playGame(final int n) {
        final double betAmount = getBetAmount();

        final Set<Integer> randomSetNumber = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            randomSetNumber.add(randomNumber(0, 99));
        }

        final Set<Integer> inputSetNumber = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            inputSetNumber.add(getInputNumberAt(i + 1));
        }

        System.out.printf("Random set number is: %s\n", randomSetNumber);
        System.out.printf("Input set number is: %s\n", inputSetNumber);

        if (randomSetNumber.equals(inputSetNumber)) {
            System.out.println("Congratulations, you win!");
            amount += betAmount * winPool[n];
        } else {
            System.out.println("Good luck next time!");
            amount -= betAmount;
        }
        System.out.printf("Your current amount: %.1f\n", amount);
    }

    private static int randomNumber(final int min, final int max) {
        return random.nextInt(max - min) + min;
    }

    private static int getChoice() {
        while (true) {
            try {
                System.out.print("Your choice: ");
                final int choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > 4) {
                    System.out.println("Please choose from 0 - 4");
                    continue;
                }
                return choice;
            } catch (final Exception e) {
                System.out.println("Please choose from 0 - 4");
            }
        }
    }

    private static int getInputNumberAt(final int position) {
        while (true) {
            try {
                System.out.printf("Input your n(%d) number: ", position);
                final int number = Integer.parseInt(sc.nextLine());
                if (number < 0 || number > 99) {
                    System.out.println("Please choose from 0 - 99");
                    continue;
                }
                return number;
            } catch (final Exception e) {
                System.out.println("Please choose from 0 - 99");
            }
        }
    }

    private static double getBetAmount() {
        while (true) {
            try {
                System.out.print("Input your bet amount: ");
                final double betAmount = Double.parseDouble(sc.nextLine());
                if (betAmount <= 0) {
                    System.out.println("Bet amount must larger than 0");
                    continue;
                }
                return betAmount;
            } catch (final Exception e) {
                System.out.println("Bet amount must larger than 0");
            }
        }
    }
}
