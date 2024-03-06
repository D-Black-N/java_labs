package lab5.var2.task6.helpers;

import lab5.var2.task6.exeptions.*;

public class Validator {
  public boolean validateString(String argument) {
    if (argument.length() == 0 || argument.length() > 100) {
      throw new ArgumentLengthExeption("String length must be in range of 0..100");
    }
    return true;
  }

  public boolean validateInt(int number) {
    if (number < 1) {
      throw new NegativeNumberExeption("Integer must be greater than 0");
    }
    return true;
  }
}
