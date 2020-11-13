package asm2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    // The Fibonacci Sequence is the series of numbers:
    // 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
    private static final Map<Integer, Long> memorization = new HashMap<>();

    public static void main(final String[] args) {
        final int input = getInput();
        System.out.printf("Fibonacci of n = %s is: %s\n", input, fibonacci(input));
    }

    // recursion with memorization
    // reduce cost of redundant computing
    private static Long fibonacci(final int n) {
        if (memorization.containsKey(n)) {
            return memorization.get(n);
        }
        if (n <= 2) {
            return 1L;
        }
        final Long result = fibonacci(n - 1) + fibonacci(n - 2);
        memorization.put(n, result);
        return result;
    }

    private static int getInput() {
        while (true) {
            try {
                System.out.print("Input n = ");
                final int input = Integer.parseInt(sc.nextLine());
                if (input > 0) {
                    return input;
                }
                System.out.println("Please input positive integer!");
            } catch (final Exception e) {
                System.out.println("Invalid input for integer!");
            }
        }
    }
}
