import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(final String[] args) {
        final int input = getInput();
        System.out.printf("n! is : %d", factorial(input));
    }

    private static int factorial(final int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static int getInput() {
        while (true) {
            try {
                System.out.print("Input n = ");
                final int input = Integer.parseInt(sc.nextLine());
                if (input >= 0) {
                    return input;
                }
                System.out.println("Please input non-negative integer!");
            } catch (final Exception e) {
                System.out.println("Invalid input for integer!");
            }
        }
    }
}
