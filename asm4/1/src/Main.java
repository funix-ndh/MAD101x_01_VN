import java.util.Arrays;
import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(final String[] args) {
        final int n = getInputN();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = getInput(i);
        }
        System.out.printf("Inputted array: %s\n", Arrays.toString(arr));
        qs(arr, 0, arr.length - 1);
        System.out.printf("Sorted array: %s\n", Arrays.toString(arr));
        final int k = getInputK();
        System.out.println("k was " + (bs(arr, k) ? "found" : "not found") + " in array.");
    }

    private static void qs(final int[] arr, final int l, final int r) {
        if (l >= r) {
            return;
        }
        final int pivot = arr[l + (r - l) / 2];
        final int index = partition(pivot, arr, l, r);
        qs(arr, l, index - 1);
        qs(arr, index, r);
    }

    private static int partition(final int pivot, final int[] arr, int l, int r) {
        while (l <= r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l > r) {
                break;
            }
            final int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return l;
    }

    private static boolean bs(final int[] arr, final int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            final int m = l + (r - l) / 2;
            if (arr[m] < k) {
                l = m + 1;
            } else if (arr[m] > k) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private static int getInputN() {
        while (true) {
            try {
                System.out.print("Please input n = ");
                final int input = Integer.parseInt(sc.nextLine());
                if (input >= 2) {
                    return input;
                }
                System.out.println("Please input integer lager than 2.");
            } catch (final Exception e) {
                System.out.println("Please input integer!");
            }
        }
    }

    private static int getInputK() {
        while (true) {
            try {
                System.out.print("Please input k = ");
                return Integer.parseInt(sc.nextLine());
            } catch (final Exception e) {
                System.out.println("Please input integer!");
            }
        }
    }

    private static int getInput(final int index) {
        while (true) {
            try {
                System.out.printf("Please input n[%s] = ", index);
                return Integer.parseInt(sc.nextLine());
            } catch (final Exception e) {
                System.out.println("Please input integer!");
            }
        }
    }
}
