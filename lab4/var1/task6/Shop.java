package lab4.var1.task6;

import java.util.ArrayList;

public class Shop {
  private String                name;
  private ArrayList<Department> departments;

  public Shop(String name) {
    this.name = name;
    this.departments = new ArrayList();
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public ArrayList<Department> getDepartments() { return departments; }

  public Department getDepartment(String name) {
    return departments.stream().filter(n -> n.equals(name)).findAny().orElse(null);
  }

  public void addDepartment(String name) {
    departments.add(new Department(name));
  }

  public void removeDepartment(String department) {
    departments.removeIf(n -> n.equals(department));
  }

  public void setDepartments(ArrayList<String> depNames) {
    for (String name : depNames) {
      departments.add(new Department(name));
    }
  }

  public void addProductsToDepartment(String depName, ArrayList<String> products) {
    Department department = getDepartment(depName);
    if (department == null) return;

    department.setProducts(products);
  }

  public void removeProductFromDepartment(String depName, String productName) {
    Department department = getDepartment(depName);
    if (department == null) return;

    department.removeProduct(productName);
  }

  public void addServicesToDepartment(String depName, ArrayList<String> services) {
    Department department = getDepartment(depName);
    if (department == null) return;

    department.setServices(services);
  }

  public void removeServiceFromDepartment(String depName, String serviceName) {
    Department department = getDepartment(depName);
    if (department == null) return;

    department.removeService(serviceName);
  }

  private class Department {
    private String            name;
    private ArrayList<String> products;
    private ArrayList<String> services;

    public Department(String name) {
      this.name = name;
      this.products = new ArrayList();
      this.services = new ArrayList();
    }

    public Department(String name, ArrayList<String> products, ArrayList<String> services) {
      this.name = name;
      this.products = products;
      this.services = services;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<String> getProducts() { return products; }
    public void setProducts(ArrayList<String> products) { this.products = products; }
    public void addProduct(String product) { products.add(product); }
    public void removeProduct(String product) { products.removeIf(n -> n.equals(product)); }

    public ArrayList<String> getServices() { return services; }
    public void setServices(ArrayList<String> services) { this.services = services; }
    public void addService(String service) { services.add(service); }
    public void removeService(String service) { services.removeIf(n -> n.equals(service)); }

    public boolean equals(String comparedName) { return name.equals(comparedName); }

    public String toString() {
      return "#Department={ name: '" + name + "', products: " + products.toString() + ", services: " + services.toString() + " }";
    }
  }
}
