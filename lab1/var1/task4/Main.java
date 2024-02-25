package lab1.var1.task4;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // initialize default password phrase
    String password = "qwerty";
    int attempts = 3;

    // set password phrase from args if exist
    if (args.length == 1) {
      System.out.println("Set default password phrase from args: " + args[0]);
      password = args[0];
    } else if (args.length > 1) {
      System.out.println("You must pass up to 1 argument!!!");
      return;
    } else {
      System.out.println("You are using default password phrase: " + password);
      System.out.println("To change default password phrase pass one argument to programm!");
    }

    // input string to compare with default password phrase
    Scanner sc = new Scanner(System.in);
    boolean logged = false;
    while (attempts != 0 && !logged) {
      System.out.print("Enter: ");
      String inputPhrase = sc.nextLine();
      if (inputPhrase.equals(password)) {
        logged = true;
        System.out.println("Success login!");
      } else {
        --attempts;
        System.out.println("Login failed! Attempts left: " + attempts);
      }
    }
    if (attempts == 0) {
      System.out.println("Program closed!");
    }
  }
}
