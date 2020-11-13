import java.util.Scanner;
import java.util.regex.Pattern;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Pattern inputValidate = Pattern.compile("^[0-9a-z]*$");

    public static void main(final String[] args) throws Exception {
        final String input = getInput();
        final int fromBase = getInputConvertBase();
        if (!isValidInputAndBase(input, fromBase)) {
            System.out.printf("Invalid input %s for base %s", input, fromBase);
            return;
        }
        final String output = "0".equals(input) ? "0" : String.valueOf(convert(input, fromBase));
        System.out.printf("Convert base %s(%s) to base 10: %s", fromBase, input, output);
    }

    private static int convert(final String num, final int fromBase) {
        if (num.isEmpty()) {
            return 0;
        }
        final int base10 = charToBase10(num.charAt(0));
        return base10 * (int) Math.pow(fromBase, num.length() - 1) + convert(num.substring(1), fromBase);
    }

    // input range from char 'a' -> 'z' and '0' to '9'
    // ascii code of char 'a' start from 97 but since we've started 'a' from 10 so 87
    // ascii code of char '0' start from 48
    private static int charToBase10(final char c) {
        return c >= 'a' && c <= 'z' ? c - 87 : c - 48;
    }

    private static boolean isValidInputAndBase(final String input, final int base) {
        for (int i = 0; i < input.length(); i++) {
            if (charToBase10(input.charAt(i)) >= base) {
                return false;
            }
        }
        return true;
    }

    private static String getInput() {
        while (true) {
            System.out.print("Input n = ");
            final String input = sc.nextLine();
            if (inputValidate.matcher(input).matches()) {
                return input;
            }
            System.out.println("Input doesn't match regex pattern ^[0-9a-z]*$");
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
