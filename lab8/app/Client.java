package lab8.app;

public class Client {
  private String name;

  public Client(String name) {
    this.name = name;
  }

  public int buyProducts(int count, Shop shop) {
    if (count < 0)
      return -1;

    return shop.sellProducts(count);
  }
}
