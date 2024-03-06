package lab4.var2.task5;

public abstract class Siemens implements Mobile {
  protected String manufacturer;
  protected String model;
  protected String type;
  protected String operator;

  public String getManufacturer() { return this.manufacturer; }
  public String getModel() { return this.model; }
  public String getType() { return this.type; }
  abstract void changeOperator(String operator);

  public String toString() {
    return "#Siemens={ manufacturer: '" + manufacturer + "', model: '" + model + "', type: '" + type + ", operator: '" + operator + " }";
  }
}
