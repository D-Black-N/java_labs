package lab3.var2.task5.helpers;

import java.lang.IllegalArgumentException;
import java.time.Year;

public class Validator {
  public boolean validateString(String argument) {
    if (argument.length() == 0 || argument.length() > 100) throwExeption("String length must be in range of 0..100");
    return true;
  }

  public boolean validateInt(int number) {
    if (number < 1) throwExeption("Integer must be greater than 0");
    return true;
  }

  public boolean validateYear(int year) {
    if (year < 1800 || year > Year.now().getValue()) throwExeption("Year must be in range from 1800 to current year");
    return true;
  }

  private void throwExeption(String message) {
    throw new IllegalArgumentException(message);
  } 
}
