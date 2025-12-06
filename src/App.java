import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("Menu of Searching and Sorting Testbed.");
            System.out.println("");
            System.out.println("1. Linear searching");
            System.out.println("2. Binary searching");
            System.out.println("3. n^2 type of sorting");
            System.out.println("4. n * log(n) type of sorting");
            System.out.println("5. Sorting performance");
             System.out.println("");
            System.out.println("q/Q) Quit");
             System.out.println("");
            System.out.print("Your choice: ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("q")) break;
            switch (choice) {
                case "1":
                    LinearSearch.run(scanner); break;
                case "2":
                    BinarySearch.run(scanner); break;
                case "3":
                    BubbleSort.run(10); break;
                case "4":
                    QuickSort.run(10); break;
                case "5":
                    SortingPerformance.run(); break;
                default:
                    System.out.println("Choice " + choice + " not implemented.");
            }
        }
        scanner.close();
        System.out.println("Bye");
    }
}
