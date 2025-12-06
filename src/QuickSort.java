import java.util.Random;

public class QuickSort {

    public static long comparisons;

    public static void sort(int[] array) {
        comparisons = 0;
        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int start, int end) {
        if (start >= end) return;

        int pivot = array[(start + end) / 2];
        int i = start, j = end;

        while (i <= j) {
            while (i <= end && array[i] < pivot) {
                comparisons++;
                i++;
            }

            while (j >= start && array[j] > pivot) {
                comparisons++;
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (start < j) quick(array, start, j);
        if (i < end) quick(array, i, end);
    }

    public static void run(int num) {
        int[] array = new int[num];
        Random random = new Random();

        for (int i = 0; i < num; i++) array[i] = random.nextInt(100);

        System.out.println("Data set before quickSort:");
        for (int x : array) System.out.print(x + " ");
        System.out.println();

            sort(array);

            System.out.println("Data set after quickSort:");
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
