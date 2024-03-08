package lab6.var1.task5;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("########## Initialize polynoms ##########");
    System.out.println("\n########## first polynom ##########");
    List<Integer> firstCoefficients = generateCoefficients(3);
    List<Integer> firstDegrees = generateDegrees(3);
    Polynom first = new Polynom(firstCoefficients, firstDegrees);
    System.out.println(first);

    System.out.println("\n########## second polynom ##########");
    List<Integer> secondCoefficients = generateCoefficients(3);
    List<Integer> secondDegrees = generateDegrees(3);
    Polynom second = new Polynom(secondCoefficients, secondDegrees);
    System.out.println(second);

    System.out.println("\n########## Multiply polynoms ##########");
    MultiplyPolynoms multiply = new MultiplyPolynoms(first, second);
    multiply.perform();
    System.out.println(multiply.getResult());
  }

  private static List<Integer> generateCoefficients(int size) {
    Random rand = new Random();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      result.add(rand.nextInt(-10, 10));
    }
    return result;
  }

  private static List<Integer> generateDegrees(int size) {
    List<Integer> result = new ArrayList<>();
    for (int i = size - 1; i >= 0; i--) {
      result.add(i);
    }
    return result;
  }
}
