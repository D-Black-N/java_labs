package lab3.var2.task5.models;

import lab3.var2.task5.helpers.Validator;
import java.lang.IllegalArgumentException;

public class Publisher {
  private int        id;                // publishing id
  private String     name;              // publishing name
  private static int autoIncrement = 1; // auto increment for id

  private Validator validator = new Validator();

  public Publisher() throws InstantiationException {
    throw new InstantiationException("Cannot be instantiated");
  }

  public Publisher(String publisherName) {
    this.id = autoIncrement; 
    try {
      if (validator.validateString(publisherName)) this.name = publisherName;
      autoIncrement++;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public String toString() {
    return "Publishing = { id: " + this.id + ", name: '" + this.name + "' }";
  }
}
