package lab5.var2.task6;

import java.util.Scanner;
import lab5.var2.task6.catalogue.ListHouses;
import java.util.InputMismatchException;
import lab5.var2.task6.exeptions.NegativeNumberExeption;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("########## Initialize flat numbers ##########");
    try {
      int initFlats = inputInteger();
    } catch (NegativeNumberExeption e) {
      System.out.println(e.getMessage());
      return;
    }

    ListHouses complex = new ListHouses(initFlats);

    System.out.println("########## Flats by roomNumbers ##########");
    try {
      int flatNumber = inputInteger();
    } catch (NegativeNumberExeption e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println(complex.selectHousesByRoomsNumber(flatNumber));

    System.out.println("########## Flats by roomNumbers and between floors ##########");
    System.out.println("Minimum floor");
    try {
      int minFloor = inputInteger();
    } catch (NegativeNumberExeption e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println("Maximum floor");
    try {
      int maxFloor = inputInteger();
    } catch (NegativeNumberExeption e) {
      System.out.println(e.getMessage());
      return;
    }

    System.out.println(complex.filterByFloor(minFloor, maxFloor, complex.selectHousesByRoomsNumber(flatNumber)));

    System.out.println("########## Flats from min square ##########");
    try {
      int minSquare = inputInteger();
    } catch (NegativeNumberExeption e) {
      System.out.println(e.getMessage());
      return;
    }
    System.out.println(complex.selectHousesFromSquare(minSquare));
  }

  private static int inputInteger() {
    int maxTries = 3;
    int count = 0;
    int value = 0;
    boolean valid = false;

    while(!valid && count != maxTries) {
      System.out.print("Enter: ");
      try {
        value = sc.nextInt();
        if (value < 1) {
          System.out.println("Input error! You have " + (maxTries - count) + " attempt");
          throw new NegativeNumberExeption();
        } else {
          valid = true;
        }
      } catch (InputMismatchException | NegativeNumberExeption e) {
        count++;
        System.out.println("Input error! You have " + (maxTries - count) + " attempt");
      }
    }

    if (!valid) {
      throw new NegativeNumberExeption("Attempt's limit. Error input positive integer.");
    } else {
      return value;
    }
  }
}
