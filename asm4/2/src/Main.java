import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(final String[] args) {
        playGame(1, 6);
    }

    private static void playGame(final int min, final int max) {
        System.out.printf("Min: %s, Max: %s\n", min, max);
        if (max == min) {
            System.out.printf("The answer must be %s", max);
            return;
        }
        final int guess = min + (max - min) / 2;
        final int isCorrect = getAns(String.format("Is %s the correct answer? (0. No, 1. Yes) ", guess));
        if (isCorrect == 1) {
            System.out.println("Thank you!");
            return;
        }
        if (max - min == 1) {
            System.out.printf("The answer must be %s", max + min - guess);
            return;
        }
        final int isBigger = getAns("Is it smaller or bigger? (0. Smaller, 1. Bigger) ");
        if (isBigger == 1) {
            playGame(guess + 1, max);
        } else {
            playGame(min, guess - 1);
        }
    }

    private static int getAns(final String msg) {
        while (true) {
            try {
                System.out.print(msg);
                final int ans = Integer.parseInt(sc.nextLine());
                if (ans == 0 || ans == 1) {
                    return ans;
                }
                System.out.println("Please input 0 or 1.");
            } catch (final Exception e) {
                System.out.println("Please input 0 or 1.");
            }
        }
    }
}
