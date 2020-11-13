package asm2;

import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int first = getInt("Input first number: ");
        final int second = getInt("Input second number: ");

        Long result = multiple(Math.abs(first), Math.abs(second));

        // both negative or both positive
        final boolean isPositiveResult = (first < 0 && second < 0) || (first > 0 && second > 0);

        if (!isPositiveResult) {
            result = -result;
        }

        System.out.printf("Multiple of %s and %s is %s", first, second, result);
    }

    private static Long multiple(final int first, final int second) {
        if (first <= 0 || second <= 0) {
            return 0L;
        }
        return first + multiple(first, second - 1);
    }

    private static Integer getInt(final String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (final Exception e) {
                System.out.println("Invalid input for integer!");
            }
        }
    }
}
