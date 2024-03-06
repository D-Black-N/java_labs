package lab4.var2.task5;

public class Model extends Siemens {
  public Model(String manufacturer, String model, String type, String operator) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.type = type;
    this.operator = operator;
  }

  @Override
  public String toString() {
    return "#Model={ manufacturer: '" + manufacturer + "', model: '" + model + "', type: '" + type + "', operator: '" + operator + "' }";
  }

  public void call() {
    System.out.println("Calling... Operator '" + operator + "'");
  }

  @Override
  public void changeOperator(String operator) {
    this.operator = operator;
  }
}
