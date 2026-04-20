

import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        try (// Write a Java program to sort a numeric array, and calculate the sum and
             // average value of array elements.
                Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Input size of array: ");
            int n = keyboard.nextInt();
            int[] arr = new int[n];
            System.out.println("Input elements of array: ");
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = keyboard.nextInt();
                sum += arr[i];
            }
            int temp;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.println("Sorted array: ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("\nSum of array: " + sum);
            System.out.println("Average of array: " + (double) sum / n);
        }
    }
}
