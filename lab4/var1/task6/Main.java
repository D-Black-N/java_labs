package lab4.var1.task6;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Shop shop = new Shop("My shop");

    String[] depNames = { "Meat", "Milk", "Fish" };
    for (String name : depNames) {
      shop.addDepartment(name);
    }

    System.out.println("\n########## Print shop name ##########");
    System.out.println(shop.getName());

    System.out.println("\n########## Print departments ##########");
    System.out.println(shop.getDepartments());

    System.out.println("\n########## Add department ##########");
    shop.addDepartment("Some new deparment");
    System.out.println(shop.getDepartments());

    System.out.println("\n########## Remove department ##########");
    shop.removeDepartment("Fish");
    System.out.println(shop.getDepartments());

    System.out.println("\n########## Add products and services to department ##########");
    ArrayList<String> services = new ArrayList();
    ArrayList<String> products = new ArrayList();
    products.add("Product1");
    products.add("Product2");
    services.add("Service1");
    services.add("Service2");
    shop.addProductsToDepartment("Meat", products);
    shop.addServicesToDepartment("Meat", services);
    System.out.println(shop.getDepartment("Meat"));

    System.out.println("\n########## Remove products and services from department ##########");
    shop.removeProductFromDepartment("Meat", "Product1");
    shop.removeServiceFromDepartment("Meat", "Service1");
    System.out.println(shop.getDepartment("Meat"));
  }
}
