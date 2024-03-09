package lab7.var2.task5;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
  public static void main(String[] args) {
    Scanner sc;
    try {
      sc = new Scanner(new File("/app/lab7/var2/task5/text.txt"));
    } catch(FileNotFoundException e) {
      System.out.println(e.getMessage());
      return;
    }
    Pattern pattern = Pattern.compile("\\b[УуЕеАаОоЭэЁёЯяИиЮю]\\p{L}*[УуЕеАаОоЭэЁёЯяИиЮю]\\b");

    long countWords = 0;
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      Matcher matcher = pattern.matcher(line);
      countWords += matcher.results().count();
    }
    System.out.println("Result: " + countWords);
  }
}
