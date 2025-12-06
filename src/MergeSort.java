import java.util.Random;

public class MergeSort {

    public static long comparisons;

    public static void sort(int[] array) {
        comparisons = 0;
        if (array.length <= 1) return;
        int[] aux = new int[array.length];
        mergeSort(array, aux, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] aux, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(array, aux, start, mid);
        mergeSort(array, aux, mid + 1, end);

        int i = start, j = mid + 1, k = start;

        while (i <= mid && j <= end) {
            comparisons++;
            if (array[i] <= array[j]) {
                aux[k++] = array[i++];
            } else {
                aux[k++] = array[j++];
            }
        }

        while (i <= mid) aux[k++] = array[i++];
        while (j <= end) aux[k++] = array[j++];

        for (k = start; k <= end; k++) array[k] = aux[k];
    }

    public static void run(int num) {
        int[] array = new int[num];
        Random random = new Random();

        for (int i = 0; i < num; i++) array[i] = random.nextInt(100);

        System.out.println("Data set before mergesort:");
        for (int x : array) System.out.print(x + " ");
        System.out.println();

        sort(array);

        System.out.println("Data set after mergesort:");
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
