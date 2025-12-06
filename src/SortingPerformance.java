import java.util.Random;

public class SortingPerformance {
    public static void run() {
        int[] sizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        Random random = new Random();
        
        System.out.print(String.format("%-30s", "algorithm,type,metric"));
        for (int size : sizes) {
            System.out.print(String.format("%12d", size));
        }
        System.out.println();
        System.out.println();
        
        long[] bubbleComparisons = new long[sizes.length];
        long[] bubbleTime = new long[sizes.length];
        long[] insertionComparisons = new long[sizes.length];
        long[] insertionTime = new long[sizes.length];
        long[] mergeComparisons = new long[sizes.length];
        long[] mergeTime = new long[sizes.length];
        long[] quickComparisons = new long[sizes.length];
        long[] quickTime = new long[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int[] array = new int[sizes[i]];
            for (int j = 0; j < sizes[i]; j++) array[j] = random.nextInt(100);
            long[] result = BubbleSort.measurePerformance(array);
            bubbleComparisons[i] = result[0];
            bubbleTime[i] = result[1];
        }
        
        for (int i = 0; i < sizes.length; i++) {
            int[] array = new int[sizes[i]];
            for (int j = 0; j < sizes[i]; j++) array[j] = random.nextInt(100);
            long[] result = InsertionSort.measurePerformance(array);
            insertionComparisons[i] = result[0];
            insertionTime[i] = result[1];
        }
        
        for (int i = 0; i < sizes.length; i++) {
            int[] array = new int[sizes[i]];
            for (int j = 0; j < sizes[i]; j++) array[j] = random.nextInt(100);
            long[] result = MergeSort.measurePerformance(array);
            mergeComparisons[i] = result[0];
            mergeTime[i] = result[1];
        }
        
        for (int i = 0; i < sizes.length; i++) {
            int[] array = new int[sizes[i]];
            for (int j = 0; j < sizes[i]; j++) array[j] = random.nextInt(100);
            long[] result = QuickSort.measurePerformance(array);
            quickComparisons[i] = result[0];
            quickTime[i] = result[1];
        }
        
        System.out.print(String.format("%-30s", "bubbleSort,random,comparisons"));
        for (long value : bubbleComparisons) System.out.print(String.format("%12d", value));
        System.out.println();
        
        System.out.print(String.format("%-30s", "bubbleSort,random,ms"));
        for (long value : bubbleTime) System.out.print(String.format("%12d", value));
        System.out.println();
        
        System.out.print(String.format("%-30s", "insertionSort,random,comparisons"));
        for (long value : insertionComparisons) System.out.print(String.format("%12d", value));
        System.out.println();
        
        System.out.print(String.format("%-30s", "insertionSort,random,ms"));
        for (long value : insertionTime) System.out.print(String.format("%12d", value));
        System.out.println();
        
        System.out.print(String.format("%-30s", "mergeSort,random,comparisons"));
        for (long value : mergeComparisons) System.out.print(String.format("%12d", value));
        System.out.println();
        
        System.out.print(String.format("%-30s", "mergeSort,random,ms"));
        for (long value : mergeTime) System.out.print(String.format("%12d", value));
        System.out.println();
        
        System.out.print(String.format("%-30s", "quickSort,random,comparisons"));
        for (long value : quickComparisons) System.out.print(String.format("%12d", value));
        System.out.println();
        
        System.out.print(String.format("%-30s", "quickSort,random,ms"));
        for (long value : quickTime) System.out.print(String.format("%12d", value));
        System.out.println();
        System.out.println();
    }
}
