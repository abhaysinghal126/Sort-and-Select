import java.util.Random;

public class BubbleSort {

    public static long comparisons;

    public static void sort(int[] array) {
        comparisons = 0; 
        int n = array.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                comparisons++; 
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static void run(int num) {
        int n = num;
        Random random = new Random();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) array[i] = random.nextInt(100);

        System.out.println("Data set before bubblesort:");
        for (int x : array) System.out.print(x + " ");
        System.out.println();

        sort(array);

        System.out.println("Data set after bubblesort:");
        for (int x : array) System.out.print(x + " ");
        System.out.println();

    }

    public static long[] measurePerformance(int[] array) {
        long start = System.nanoTime();
        sort(array);
        long end = System.nanoTime();
        long timeMs = (end - start) / 1000000;
        return new long[]{comparisons, timeMs};
    }
}
