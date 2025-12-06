import java.util.Random;

public class InsertionSort {

    public static long comparisons;

    public static void sort(int[] array) {
        comparisons = 0;

        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                comparisons++;
                array[j + 1] = array[j];
                j--;
            }
            if (j >= 0) comparisons++;
            array[j + 1] = key;
        }
    }

    public static void run(int num) {
        int[] array = new int[num];
        Random random = new Random();

        for (int i = 0; i < num; i++) array[i] = random.nextInt(100);

        System.out.println("Data set before insertionsort:");
        for (int x : array) System.out.print(x + " ");
        System.out.println();

        sort(array);

        System.out.println("Data set after insertionsort:");
        for (int x : array) System.out.print(x + " ");
        System.out.println();

        System.out.println("Comparisons: " + comparisons);
    }

    public static long[] measurePerformance(int[] array) {
        long start = System.nanoTime();
        sort(array);
        long end = System.nanoTime();
        long timeMs = (end - start) / 1000000;
        return new long[]{comparisons, timeMs};
    }
}
