package lab1.var2.task1;

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

    // output even numbers
    System.out.println("Even numbers in array: ");
    conditionOutput(integers, 0);

    // output odd numbers
    System.out.println("Odd numbers in array: ");
    conditionOutput(integers, 1);
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

  // method to output even or odd integers
  private static void conditionOutput(int[] array, int reminder) {
    int length = array.length;
    for (int i = 0; i < length; i++) {
      if (array[i] % 2 == reminder) {
        System.out.println(array[i]);
      }
    }
  } 
}
