package lab6.var2.task5;

import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.nio.file.Paths;

public class Main {
  public static void main(String[] args) {
    System.out.println("\n########## Initialize file ##########");
    Scanner sc;
    try {
      sc = new Scanner(new File("/app/lab6/var2/task5/data/file.txt"));
    } catch(FileNotFoundException e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println("\n########## Read file ##########");
    String line;
    if (sc.hasNextLine())
      line = sc.nextLine();
    else {
      System.out.println("File is empty!");
      return;
    }
    System.out.println(line);

    System.out.println("\n########## Transform string to integers array ##########");
    String[] strNumbers = line.split(" ");
    System.out.println(Arrays.toString(strNumbers));
    Integer[] numbers = new Integer[strNumbers.length];
    try {
      for (int i = 0; i < numbers.length; i++) {
        numbers[i] = Integer.parseInt(strNumbers[i]);
      }
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println("\n########## Find negative value index ##########");
    int negativeIndex = 0;
    while (numbers[negativeIndex] >= 0 && negativeIndex < numbers.length)
      negativeIndex++;
    if (negativeIndex == 0 || negativeIndex >= numbers.length - 1) {
      System.out.println("File does not have separator");
      return;
    }
    System.out.println(negativeIndex);

    System.out.println("\n########## Build sorted c1 list ##########");
    List<Integer> c1 = new LinkedList(Arrays.asList(Arrays.copyOfRange(numbers, 0, negativeIndex - 1)));
    Collections.sort(c1);
    System.out.println(c1.toString());

    System.out.println("\n########## Build sorted c2 list ##########");
    List<Integer> c2 = new LinkedList<Integer>(Arrays.asList(Arrays.copyOfRange(numbers, negativeIndex + 1, numbers.length - 1)));
    Collections.sort(c2);
    System.out.println(c2);

    System.out.println("\n########## Combine two lists ##########");
    List<Integer> minList = c1.size() < c2.size() ? c1 : c2;
    List<Integer> maxList = c1.size() >= c2.size() ? c1 : c2;
    for (int i = 0; i < minList.size(); i++) {
      int elem = minList.get(i);
      int j = 0;
      while(maxList.get(j) < elem && j < maxList.size())
        j++;
      maxList.add(j, elem);
    }
    System.out.println(maxList);
  }
}
