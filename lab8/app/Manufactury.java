package lab8.app;

public class Manufactury {
  private String name;
  private int    productQuantity;

  public Manufactury(String name) {
    this.name            = name;
    this.productQuantity = 1000;
  }

  public int getProductQuantity() { return productQuantity; }
  public void setProductQuantity(int quantity) { productQuantity = quantity; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public int generateProducts(int increment) {
    System.out.println("Generating new products!");
    productQuantity += increment;
    return productQuantity;
  }

  public int sellProducts(int count) {
    System.out.println("Selling products to shop.");
    if (productQuantity - count < 0) {
      System.out.println("Not enought products!");
      return -1;
    }

    productQuantity -= count;
    return count;
  }
}
