import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(final String[] args) throws Exception {
        final int inputBase10 = getInputBase10();
        final int convertToBase = getInputConvertBase();
        final String outputTargetBase = inputBase10 == 0 ? "0" : convert(inputBase10, convertToBase);
        System.out.printf("Convert base 10(%s) to base %s: %s", inputBase10, convertToBase, outputTargetBase);
    }

    private static String convert(final int inputBase10, final int convertToBase) {
        if (inputBase10 == 0) {
            return "";
        }
        final int remain = inputBase10 % convertToBase;
        // ascii a = 97
        // remain character start from 10
        // char = 97 - 10 + remain <=> 87 + remain
        final String formatRemain = remain > 9 ? String.valueOf((char) (87 + remain)) : String.valueOf(remain);
        return convert(inputBase10 / convertToBase, convertToBase) + formatRemain;
    }

    private static int getInputBase10() {
        while (true) {
            try {
                System.out.print("Input base 10 = ");
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

    private static int getInputConvertBase() {
        while (true) {
            try {
                System.out.print("Input base (2-36) = ");
                final int input = Integer.parseInt(sc.nextLine());
                if (input >= 2 && input <= 36) {
                    return input;
                }
                System.out.println("Please input integer base 2-36");
            } catch (final Exception e) {
                System.out.println("Invalid input for integer!");
            }
        }
    }
}
