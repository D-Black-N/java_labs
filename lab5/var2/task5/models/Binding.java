package lab5.var2.task5.models;

import lab5.var2.task5.helpers.Validator;
import lab5.var2.task5.exeptions.*;

public class Binding {
  private int        id;                // publishing id
  private String     name;              // publishing name
  private static int autoIncrement = 1; // auto increment for id

  private Validator validator = new Validator();

  public Binding() throws InstantiationException {
    throw new InstantiationException("Cannot be instantiated");
  }

  public Binding(String bindingName) {
    this.id = autoIncrement; 
    try {
      if (validator.validateString(bindingName)) this.name = bindingName;
      autoIncrement++;
    } catch (ArgumentLengthExeption e) {
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
    return "Binding = { id: " + this.id + ", name: '" + this.name + "' }";
  }
}
