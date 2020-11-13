import java.util.Arrays;
import java.util.Scanner;

public final class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(final String[] args) throws Exception {
        final int n = getInput();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = getElementValueOf(i);
        }
        final int sortOption = getSortOption();
        System.out.printf("Inputted array: %s\n", Arrays.toString(arr));
        qs(arr, 0, n - 1, sortOption);
        System.out.printf("Output sorted array using quicksort: %s", Arrays.toString(arr));
    }

    private static void qs(final int[] arr, final int start, final int end, int sortOption) {
        if (start >= end) {
            return;
        }
        final int mid = start + (end - start) / 2;
        final int index = partition(arr[mid], arr, start, end, sortOption);
        qs(arr, start, index - 1, sortOption);
        qs(arr, index, end, sortOption);
    }

    private static int partition(final int pivot, final int[] arr, int start, int end, int sortOption) {
        while (start <= end) {
            // ASC
            if (sortOption == 1) {
                while (arr[start] < pivot) {
                    start++;
                }
                while (arr[end] > pivot) {
                    end--;
                }
            } else { // DESC
                while (arr[start] > pivot) {
                    start++;
                }
                while (arr[end] < pivot) {
                    end--;
                }
            }
            if (start > end) {
                break;
            }
            final int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return start;
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

    private static int getElementValueOf(final int index) {
        while (true) {
            try {
                System.out.printf("Input n[%s] = ", index);
                return Integer.parseInt(sc.nextLine());
            } catch (final Exception e) {
                System.out.println("Invalid input for integer!");
            }
        }
    }

    private static int getSortOption() {
        while (true) {
            try {
                System.out.print("Input sort option (1. ASC, 2.DESC) = ");
                final int input = Integer.parseInt(sc.nextLine());
                if (input >= 1 && input <= 2) {
                    return input;
                }
                System.out.println("Please input 1 or 2.");
            } catch (final Exception e) {
                System.out.println("Invalid input for integer!");
            }
        }
    }
}
