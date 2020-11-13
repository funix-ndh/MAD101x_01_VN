import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    // result of using loop vs result of using formula is difference when n is large enough
    // because when working with fraction (real number)
    // the calculation multiple times on real number can reduce the precision
    public static void main(final String[] args) {
        final Double n = getInput();
        System.out.printf("Output with loop is: %s\n", solve(n));
        System.out.printf("Output with formula is: %s", formula(n));
    }

    private static Double formula(final Double n) {
        return Double.valueOf(0.5) *
               (
                       Double.valueOf(1.5)
                       -
                       (Double.valueOf(1) / (n + Double.valueOf(1)))
                       -
                       (Double.valueOf(1) / (n + Double.valueOf(2)))
               );
    }

    private static Double solve(final Double n) {
        Double result = Double.valueOf(0);
        for (Double i = Double.valueOf(1); i <= n; i++) {
            result += Double.valueOf(1) / (i * (i + Double.valueOf(2)));
        }
        return result;
    }

    private static Double getInput() {
        while (true) {
            try {
                System.out.print("Input n = ");
                final double input = Double.parseDouble(sc.nextLine());
                if (input > 2) {
                    return input;
                }
                System.out.println("Please input positive integer lager than 2.");
            } catch (final Exception e) {
                System.out.println("Invalid input for integer!");
            }
        }
    }
}
