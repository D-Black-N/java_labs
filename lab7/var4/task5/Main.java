package lab7.var4.task5;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n########## Write a string ##########");
    String line = sc.nextLine();

    System.out.println("\n########## Replace equal near symbols ##########");
    System.out.println(line.replaceAll("(.)\\1+", "$1"));
  }
}
