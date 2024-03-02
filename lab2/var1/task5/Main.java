package lab2.var1.task5;

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

    // output words with only latin symbols and count words with equal vowels and consonants
    String latinPattern = "^\\w+$";
    int latinCounter = 0;
    int equalLetters = 0;
    System.out.println("Output words with only latin symbols:");
    for (String word: words) {
      if (Pattern.matches(latinPattern, word)) {
        ++latinCounter;
        System.out.println(word);
        int vowCount = 0;
        int consCount = 0;
        for (char letter: word.toCharArray()) {
          if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'y' || letter == 'u') {
            vowCount++;
          } else {
            consCount++;
          }
        }
        if (vowCount == consCount) equalLetters++;
      }
    }
    System.out.println("Words number with only latins symbols: " + latinCounter);
    System.out.println("Words number with equal vowel and consonant letters: " + equalLetters);
  }
}
