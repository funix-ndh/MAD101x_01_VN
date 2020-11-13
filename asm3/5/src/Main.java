import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int n = getInput();
        System.out.printf("Factorial of %s! is ", n);
        final int[] result = new int[500];
        final int size = factorial(n, result);
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
        System.out.printf("\nTotal trailing zero of %s! is %s", n, countZero(result, size));
    }

    private static int factorial(final int n, final int[] result) {
        result[0] = 1;
        int size = 1;
        for (int i = 2; i <= n; i++) {
            size = multiple(i, result, size);
        }
        return size;
    }

    private static int multiple(final int x, final int[] result, int size) {
        int carry = 0;
        for (int i = 0; i < size; i++) {
            final int prod = result[i] * x + carry;
            result[i] = prod % 10;
            carry = prod / 10;
        }
        while (carry > 0) {
            result[size] = carry % 10;
            carry /= 10;
            size++;
        }
        return size;
    }

    private static int countZero(final int[] result, final int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (result[i] == 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
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
