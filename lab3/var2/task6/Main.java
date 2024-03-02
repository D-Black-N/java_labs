package lab3.var2.task6;

import java.util.Scanner;
import lab3.var2.task6.catalogue.ListHouses;
import java.util.InputMismatchException;
// import lab3.var2.task6.models.*;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("########## Initialize flat numbers ##########");
    int initFlats = inputInteger();
    if (initFlats < 1) return;

    ListHouses complex = new ListHouses(initFlats);

    System.out.println("########## Flats by roomNumbers ##########");
    int flatNumber = inputInteger();
    if (flatNumber < 1) return;

    System.out.println(complex.selectHousesByRoomsNumber(flatNumber));

    System.out.println("########## Flats by roomNumbers and between floors ##########");
    System.out.println("Minimum floor");
    int minFloor = inputInteger();
    if (minFloor < 1) return;

    System.out.println("Maximum floor");
    int maxFloor = inputInteger();
    if (maxFloor < 1) return;

    System.out.println(complex.filterByFloor(minFloor, maxFloor, complex.selectHousesByRoomsNumber(flatNumber)));

    System.out.println("########## Flats from min square ##########");
    int minSquare = inputInteger();
    if (minSquare < 1) return;

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
