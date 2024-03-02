package lab1.var1.task3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
  public static void main(String[] args) {
    // initialize stdin
    Scanner sc = new Scanner(System.in);

    // input srings number
    boolean valid = false;
    int number = 0;
    do {
      System.out.print("Enter strings number: ");
      try {
        number = sc.nextInt();
        valid = true;
      } catch (InputMismatchException e) {
        sc.nextLine();
        System.out.println("Input value must be integer. Please, retry!");
      }
    } while(!valid);
    sc.nextLine();

    // initialize string array
    String[] strings = new String[number];

    // inputs string to array
    for (int i = 0; i < number; i++) {
      System.out.print("Enter: ");
      strings[i] = sc.nextLine();
    }

    // output strings line by line
    System.out.println("\nLine by line output:");
    for (int i = 0; i < number; i++) {
      System.out.println((i + 1) + ". " + strings[i]);
    }
    System.out.println();

    // output strings in one line
    System.out.println("One line output:");
    for (int i = 0; i < number; i++) {
      System.out.print(strings[i] + " || ");
    }
    System.out.println();
  }
}
