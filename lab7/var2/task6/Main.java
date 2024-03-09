package lab7.var2.task6;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    System.out.println("\n########## Read file ##########");
    Scanner sc;
    try {
      sc = new Scanner(new File("/app/lab7/var2/task6/text.txt"));
    } catch(FileNotFoundException e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println("\n########## Collect words ##########");
    Set<String> uniqueWords = new HashSet();
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String[] words = line.split("\\s|\\.|!|,|:|;+");
      for (String word : words) {
        if (word.length() > 1 && word.charAt(0) == word.charAt(word.length() - 1)) {
          uniqueWords.add(word);
        }
      }
    }

    System.out.println("########## Put words ##########");
    for (String uniqueWord : uniqueWords) {
      System.out.println(uniqueWord);
    }
  }
}
