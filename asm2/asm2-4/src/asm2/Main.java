package asm2;

import java.util.Scanner;

// Because requirement didn't mention about negative or fraction exponential
// So this implementation will using positive integer only
public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int first = getInt("Input first number: ");
        final int second = getInt("Input second number: ");
        System.out.printf("%s^%s is %s", first, second, pow(first, second));
    }

    private static long pow(final int first, final int second) {
        // every number has exponent 0 will result 1
        if (second <= 0) {
            return 1L;
        }
        // exponential of base 0 or 1 will result itself
        if (first <= 1) {
            return first;
        }
        return first * pow(first, second - 1);
    }

    private static Integer getInt(final String msg) {
        while (true) {
            try {
                System.out.print(msg);
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
