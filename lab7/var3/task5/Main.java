package lab7.var3.task5;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
  public static void main(String[] args) {
    System.out.println("\n########## Read file ##########");
    Scanner sc;
    try {
      sc = new Scanner(new File("/app/lab7/var3/task5/text.txt"));
    } catch(FileNotFoundException e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println("\n########## Change first and last word in sentence ##########");
    String pattern = "(\\p{L}+)([\\p{L}\\s-,:;]+?)(\\p{L}*)(\\.+)"
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String reversedLine = line.replaceAll(pattern, "$3$2$1$4");
      System.out.println(reversedLine);
    }
  }
}
