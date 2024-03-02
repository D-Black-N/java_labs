package lab3.var2.task5;

import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Library library = new Library();

    System.out.print("\n\n########## Find books by author ##########\n");
    System.out.println(library.booksByAuthor(inputLine("author")));

    System.out.print("\n\n########## Find books by publisher ##########\n");
    System.out.println(library.booksByPublisher(inputLine("publisher")));

    System.out.print("\n\n########## Find books from year ##########\n");
    System.out.print("Enter from year: ");
    int year = sc.nextInt();
    sc.nextLine();
    System.out.println(library.booksFromYear(year));
  }

  private static String inputLine(String recordName) {
    System.out.print("Enter " + recordName + " name: ");
    return sc.nextLine();
  }
}
