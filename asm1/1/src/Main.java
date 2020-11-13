import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public final class Main {

    private static final Random random = new Random();
    private static final Scanner sc = new Scanner(System.in);

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
        } else {
            System.out.println("Good luck next time!");
        }
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
}
