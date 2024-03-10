package lab8;

import java.util.concurrent.TimeUnit;
import java.util.Random;
import lab8.app.*;

public class Main {
  public static void main(String[] args) {
    Client client = new Client("Danil");
    Shop shop = new Shop("Product Shop");
    Manufactury manufactury = new Manufactury("Product Manufactury");

    Runnable clientTask = () -> {
      try {
        Random rand = new Random();
        System.out.println("clientTask started!");
        while (true) {
          TimeUnit.SECONDS.sleep(10);
          client.buyProducts(rand.nextInt(1, 200), shop);
        }
      } catch (InterruptedException e) {
        System.out.println("clientTask interrupted!");
      }
    };

    Runnable shopTask = () -> {
      try {
        Random rand = new Random();
        System.out.println("shopTask started!");
        while (true) {
          TimeUnit.SECONDS.sleep(17);
          shop.buyProducts(rand.nextInt(100, 600), manufactury);
        }
      } catch (InterruptedException e) {
        System.out.println("clientTask interrupted!");
      }
    };

    Runnable manufacturyTask = () -> {
      try {
        Random rand = new Random();
        System.out.println("shopTask started!");
        while (true) {
          TimeUnit.SECONDS.sleep(22);
          manufactury.generateProducts(rand.nextInt(300, 750));
        }
      } catch (InterruptedException e) {
        System.out.println("clientTask interrupted!");
      }
    };

    Thread clientThread = new Thread(clientTask);
    clientThread.start();

    Thread shopThread = new Thread(shopTask);
    shopThread.start();

    Thread manufacturyThread = new Thread(manufacturyTask);
    manufacturyThread.start();

    System.out.println("Main thread finished...");
  }
}
