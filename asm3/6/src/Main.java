import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    // Input n = aBcXyz-0123456789
    // Input k = 1
    // Encoding: BcDyZA-1234567890
    // Decoding: aBcXyz-0123456789
    public static void main(String[] args) {
        System.out.print("Input n = ");
        final String input = sc.nextLine();

        final int k = getInputK();

        final String encoding = gen(input, k, true);
        System.out.printf("Encoding: %s\n", encoding);

        final String decoding = gen(encoding, k, false);
        System.out.printf("Decoding: %s", decoding);
    }

    private static String gen(final String input, int k, final boolean encoding) {
        final char[] cArr = new char[input.length()];
        k = encoding ? k : -k;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c += k % 26;
                if (c > 'z') {
                    c = (char) ('a' - 1 + c % 'z');
                } else if (c < 'a') {
                    c = (char) ('z' + 1 - 'a' % c);
                }
                c -= 32;
            } else if (c >= 'A' && c <= 'Z') {
                c += k % 26;
                if (c > 'Z') {
                    c = (char) ('A' - 1 + c % 'Z');
                } else if (c < 'A') {
                    c = (char) ('Z' + 1 - 'A' % c);
                }
                c += 32;
            } else if (c >= '0' && c <= '9') {
                c += k % 10;
                if (c > '9') {
                    c = (char) ('0' - 1 + c % '9');
                } else if (c < '0') {
                    c = (char) ('9' + 1 - '0' % c);
                }
            }
            cArr[i] = c;
        }
        return String.valueOf(cArr);
    }

    private static int getInputK() {
        while (true) {
            try {
                System.out.print("Input k = ");
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
