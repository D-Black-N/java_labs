package lab8.app;

public class Shop {
  private String name;
  private int    productQuantity;

  public Shop(String name) {
    this.name = name;
    this.productQuantity = 500;
  }

  public int getProductQuantity() { return productQuantity; }
  public void setProductQuantity(int quantity) { productQuantity = quantity; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public int buyProducts(int increment, Manufactury manufactury) {
    int result = manufactury.sellProducts(increment);
    if (result < 0) return -1;

    productQuantity += increment;
    return productQuantity;
  }

  public int sellProducts(int count) {
    System.out.println("Selling products to client.");
    if (productQuantity - count < 0) {
      System.out.println("Not enougth products!");
      return -1;
    }

    System.out.println("Selled " + count + " products");
    productQuantity -= count;
    return count;
  }
}
