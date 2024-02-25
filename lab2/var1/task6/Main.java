package lab2.var1.task6;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    // initialize Scanner
    Scanner sc = new Scanner(System.in);

    // input word numbers
    boolean valid = false;
    int numberWords = 0;
    do {
      System.out.print("Enter words number: ");
      try {
        numberWords = sc.nextInt();
        if (numberWords <= 0) {
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

    // set array of words
    String[] words = new String[numberWords];
    System.out.println("Enter " + numberWords + " words: ");
    for (int i = 0; i < numberWords; i++) {
      System.out.print("Enter: ");
      words[i] = sc.nextLine().replaceFirst("^\\s*", "").split(" ")[0]; // remove spaces before word, take only first word before space
    }

    // find word with symbol code strict increment
    boolean finded = false;
    int wordNumber = 0;
    while (!finded && wordNumber < numberWords) {
      String word = words[wordNumber];
      int wordLength = word.length();
      boolean incremented = true;
      int charNumber = 1;
      while (incremented && charNumber < wordLength) {
        if (word.charAt(charNumber) - word.charAt(charNumber - 1) <= 0) {
          incremented = false;
        }
        ++charNumber;
      }
      if (incremented == true) {
        finded = true;
      } else {
        ++wordNumber;
      }
    }

    // Result output
    if (finded) {
      System.out.println("Find word with strict increment letters: " + words[wordNumber]);
    } else {
      System.out.println("There are no words with strict increment letters!");
    }
  }
}
