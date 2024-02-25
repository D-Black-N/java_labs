package lab2.var2.task6;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.lang.Math;

public class Main {
  // initialize Scanner
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    // create instance of Random class
    Random rand = new Random();

    // input matrix number
    int dimension = 0;
    while (dimension < 1) {
      dimension = inputInteger("Enter matrix dimention: ");
      if (dimension < 1) {
        System.out.println("Integer must be greater than 1. Please, retry!");
      }
    }

    // initialize matrix
    int[][] matrix = new int[dimension][dimension];
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        matrix[i][j] = rand.nextInt(-dimension, dimension + 1);
      }
    }

    // output original matrix
    System.out.println("Original matrix: ");
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }

    // select norm type
    int normType = 0;
    while (normType < 1 || normType > 3) {
      normType = inputInteger("Select norm type (1 - '1-norm', 2 - '2-norm', 3 - '3-norm'): ");
      if (normType < 1 || normType > 3) {
        System.out.println("Integer must be greater than 1 and less than 4. Please, retry!");
      }
    }

    // process and return output
    double resultNorm = 0;
    switch (normType) {
      case 1: resultNorm = firstNorm(matrix, dimension);
              break;
      case 2: resultNorm = secondNorm(matrix, dimension);
              break;
      case 3: resultNorm = thirdNorm(matrix, dimension);
              break;
    }
    System.out.print("Processing result: " + resultNorm);
    System.out.println();
  }

  private static int inputInteger(String text) {
    boolean valid = false;
    int n = 0;
    do {
      System.out.print(text);
      try {
        n = sc.nextInt();
        valid = true;
      } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Input value must be integer. Please, retry!");
      }
    } while(!valid);
    sc.nextLine();
    return n;
  }

  // first norm: row with max sum of absolute elements
  private static double firstNorm(int[][] matrix, int dimension) {
    double result = 0;
    for (int i = 0; i < dimension; i++) {
      int sum = 0;
      for (int j = 0; j < dimension; j++) {
        sum += Math.abs(matrix[i][j]);
      }
      if ((double)sum > result) result = (double)sum;
    }
    return result;
  }

  // second norm: column with max sum of absolute elements
  private static double secondNorm(int[][] matrix, int dimension) {
    double result = 0;
    for (int i = 0; i < dimension; i++) {
      int sum = 0;
      for (int j = 0; j < dimension; j++) {
        sum += Math.abs(matrix[j][i]);
      }
      if ((double)sum > result) result = (double)sum;
    }
    return result;
  }

  private static double thirdNorm(int[][] matrix, int dimension) {
    int sum = 0;
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        sum += matrix[i][j] * matrix[i][j];
      }
    }
    double result = Math.sqrt(sum);
    return result;
  }
}
