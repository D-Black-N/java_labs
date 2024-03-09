package lab7.var1.task6;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String text = "Each lesson has a preparation task, a reading text and two tasks to check your understanding and to practise a variety of reading skills. Make a start today.";
    System.out.print("Enter subword: ");
    String subWord = sc.nextLine();
    System.out.print("Enter insert symbols: ");
    String inserted = sc.nextLine();
    String result = text.replaceAll("(" + subWord + ")\\b", "$1 " + inserted);
    System.out.println(result);
  }
}
