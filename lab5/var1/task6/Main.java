package lab5.var1.task6;

import java.util.Scanner;
import java.lang.NumberFormatException;
import java.util.Random;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    // initialize size of arguments
    double[] range = { 0, Integer.MAX_VALUE };
    String inputMessage = "Input size of arguments: ";
    String errorMessage = "Input value must be in range of: " + range[0] + ".." + range[1];
    int size = inputIntegerInRange(inputMessage, range, errorMessage);

    // initialize x
    double x = inputDouble("Input x: ");

    // initialize array of arguments range (-50..50)
    Random rand = new Random();
    double[] arguments = new double[size];
    for (int i = 0; i < size; i++) {
      arguments[i] = Double.parseDouble(String.format("%.2f", rand.nextDouble() * 100 - 50));
    }

    // output arguments
    System.out.println("\nOutput generated arguments:");
    for (double arg: arguments)
      System.out.print(arg + "\t");

    System.out.println();

    // initialize object
    ContinuedFraction object = new ContinuedFraction(size, x, arguments);

    // calculate
    try {
      double result = object.calculate(size - 1);

      // output result
      System.out.println("Calculation result: " + result);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  private static int inputIntegerInRange(String text, double[] range, String errorMessage) {
    int result = -1;
    while (result < range[0] || result > range[1]) {
      result = inputInteger(text);

      if (result < range[0] || result > range[1])
        System.out.println();
    }
    return result;
  }

  private static int inputInteger(String text) {
    boolean valid = false;
    int value = 0;
    while(!valid) {
      try {
        value = Integer.parseInt(inputValue(text));
        valid = true;
      } catch (NumberFormatException e) {
        System.out.println("Input value must be integer. Please, retry!");
      }
    }
    return value;
  }

  private static double inputDouble(String text) {
    boolean valid = false;
    double value = 0;
    while(!valid) {
      try {
        value = Double.parseDouble(inputValue(text));
        valid = true;
      } catch (NumberFormatException e) {
        System.out.println("Input value must be double. Please, retry!");
      }
    }
    return value;
  }

  private static String inputValue(String text) {
    System.out.print(text);
    return sc.nextLine();
  }
}
