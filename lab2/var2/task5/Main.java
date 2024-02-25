package lab2.var2.task5;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    // initialize Scanner
    Scanner sc = new Scanner(System.in);

    // create instance of Random class
    Random rand = new Random();

    // input matrix number
    boolean valid = false;
    int n = 0;
    do {
      System.out.print("Enter matrix number: ");
      try {
        n = sc.nextInt();
        if (n <= 0) {
          System.out.println("Input value must be greater than 0.Please, retry!");
        } else {
          valid = true;
        }
      } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Input value must be integer. Please, retry!");
      }
    } while(!valid);
    sc.nextLine();

    // initialize matrix
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = rand.nextInt(-n, n + 1);
      }
    }

    // output original matrix
    System.out.println("Original matrix: ");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }

    // output transposed matrix
    System.out.println("Transposed matrix: ");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[j][i] + "\t");
      }
      System.out.println();
    }
  }
}
