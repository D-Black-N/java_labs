package lab7.var4.task6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n########## Write a string ##########");
    String line = sc.nextLine();

    System.out.println("\n########## Sort words alphabetically ##########");
    String[] words = line.split(" ");
    Arrays.sort(words);
    System.out.println(String.join("\n", words));
  }
}
