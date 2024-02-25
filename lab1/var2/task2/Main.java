package lab1.var2.task2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
  // initialize stdin
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    // initialize array length
    int length = inputInteger("Enter array length: ");

    // set array of integers
    int[] integers = new int[length];
    System.out.println("Input " + length + " integers:");
    for (int i = 0; i < length; i++) {
      integers[i] = inputInteger("Enter: ");
    }

    // output min and max value in array
    int min = 2147483647;  // max int value
    int max = -2147483648; // min int value 
    for (int value: integers) {
      if (value > max) max = value;
      if (value < min) min = value;
    }
    System.out.println("Minimum value is: " + min);
    System.out.println("Maximum value is: " + max);
  }

  // method to input integer value with catch exeptions
  private static int inputInteger(String staticText) {
    int variable = 0;
    boolean valid = false;

    do {
      System.out.print(staticText);
      try {
        variable = sc.nextInt();
        valid = true;
      } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Input value must be integer. Please, retry!");
      }
    } while(!valid);

    sc.nextLine();
    return variable;
  }
}
