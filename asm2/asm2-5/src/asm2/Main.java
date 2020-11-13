package asm2;

import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    // A is the source rod
    // B is the target rod
    // C is the temp rod
    public static void main(String[] args) {
        final int input = getInput();
        solveHanoiTower(input, "A", "B", "C");
    }

    // 1st step: move all n-1 stacks from source rod to temp rod
    // 2nd step: after finished 1st step, move the last stack from source rod to target rod
    // 3rd step: move all remain stacks from temp rod to target rod
    private static void solveHanoiTower(final int n, final String from, final String to, final String temp) {
        if (n == 1) {
            System.out.printf("%s -> %s\n", from, to);
            return;
        }
        solveHanoiTower(n - 1, from, temp, to);
        solveHanoiTower(1, from, to, temp);
        solveHanoiTower(n - 1, temp, to, from);
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
