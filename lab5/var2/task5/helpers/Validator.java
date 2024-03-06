package lab5.var2.task5.helpers;

import lab5.var2.task5.exeptions.*;
import java.time.Year;

public class Validator {
  public boolean validateString(String argument) {
    if (argument.length() == 0 || argument.length() > 100) {
      throw new ArgumentLengthExeption("String length must be in range of 0..100");
    }
    return true;
  }

  public boolean validateInt(int number) {
    if (number < 1) throw new NegativeNumberExeption("Integer must be greater than 0");
    return true;
  }

  public boolean validateYear(int year) {
    if (year < 1800 || year > Year.now().getValue()) {
      throw new YearRangeExeption("Year must be in range from 1800 to current year");
    }
    return true;
  }
}
