

import java.util.Scanner;

public class AddMatrices {
    public static void main(String[] args) {
        try (// input 2 matrix which size can be different then add them
                Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Input size n and m of matrices: ");
            int n = keyboard.nextInt();
            int m = keyboard.nextInt();
            int[][] matrix1 = new int[n][m];
            System.out.println("Input elements of matrix 1: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix1[i][j] = keyboard.nextInt();
                }
            }
            int[][] matrix2 = new int[n][m];
            System.out.println("Input elements of matrix 2: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix2[i][j] = keyboard.nextInt();
                }
            }
            int[][] matrix3 = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            System.out.println("Matrix 1: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix1[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("Matrix 2: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix2[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("Matrix 3: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix3[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}
