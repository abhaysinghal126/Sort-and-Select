import java.util.Scanner;

public class LinearSearch {
    public static int linearSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++)  {
            if (a[i] == key) return i;
        }
        return -1;
    }

    public static void run(Scanner scanner) {
        System.out.print("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
        int v = scanner.nextInt();
        System.out.println("");
        if (v >= 0 && v <= 9) {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) arr[i] = i;
            int pos = linearSearch(arr, v);
            System.out.println(pos >= 0 ? "Found" : "Not found");
        } else {
            System.out.println("Not found");
        }
    }
}
