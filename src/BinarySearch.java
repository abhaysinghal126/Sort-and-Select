import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == key)
                return mid;
            if (array[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void run(Scanner scanner) {
        System.out.print("In the list are values 0, ..., 9; which value would you like to search with binary search? ");
        int value = scanner.nextInt();
        System.out.println("");
        int[] array = new int[10];
        for (int i = 0; i < 10; i++)
            array[i] = i;
        int result = binarySearch(array, value);
        System.out.println(result >= 0 ? "Found" : "Not found");
    }
}
