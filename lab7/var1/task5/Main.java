package lab7.var1.task5;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
  public static void main(String[] args) {
    String text = "Основная цель - создание краткого текста в виде резюме, содержащего основную информацию из статьи или текста.";
    String substring = "Test test";
    System.out.print("Input index to insert substring: ");
    int index = inputInteger();
    String resultText = text.substring(0, index - 1) + substring + text.substring(index, text.length()); 
    System.out.println(resultText);
  }

  private static int inputInteger() {
    Scanner sc = new Scanner(System.in);
    int maxTries = 3;
    int count = 0;
    int value = -1;
    boolean valid = false;

    while(!valid && count != maxTries) {
      System.out.print("Enter: ");
      try {
        value = sc.nextInt();
        if (value < 0) {
          count++;
          System.out.println("Input error! You have " + (maxTries - count) + " attempt");
        } else {
          valid = true;
        }
      } catch (InputMismatchException e) {
        count++;
        System.out.println("Input error! You have " + (maxTries - count) + " attempt");
      }
    }

    return value;
  }
}
