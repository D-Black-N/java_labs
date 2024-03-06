package lab5.var1.task5;

import lab5.var1.task5.src.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("########## Input array of Matrix size ##########");
    int listSize = inputInteger();
    if (listSize < 0) return;

    try {
      ListMatrix listMatrix = new ListMatrix(listSize);
    } catch (OutOfMemoryError e) {
      System.out.prinln("Out of memory. Shut down");
      return;
    }

    System.out.println("########## Print Matrix List ##########");
    listMatrix.printMatrixList();

    System.out.println("########## Change MinMax rows in Matrix list ##########");
    int columnId = inputInteger();
    if (columnId < 0) return;

    try {
      ListMatrix changedList = listMatrix.changeRows(columnId);
      changedList.printMatrixList();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("########## Square matrix by id ##########");
    columnId = inputInteger();
    if (columnId < 0) return;

    try {
      Matrix squareMatrix = listMatrix.square(columnId);
      squareMatrix.print();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  private static int inputInteger() {
    int maxTries = 3;
    int count = 0;
    int value = -1;
    boolean valid = false;

    while(!valid && count != maxTries) {
      System.out.print("Enter: ");
      try {
        value = sc.nextInt();
        if (value < 0) {
          count++;
          System.out.println("Input error! You have " + (maxTries - count) + " attempt");
        } else {
          valid = true;
        }
      } catch (InputMismatchException e) {
        count++;
        System.out.println("Input error! You have " + (maxTries - count) + " attempt");
      }
    }

    return value;
  }
}
