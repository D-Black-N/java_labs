package lab4.var2.task5;

public class Main {
  public static void main(String[] args) {
    Mobile phone = new Model("Siemens", "ModelX", "Screen", "Megafon");

    System.out.println("\n########## Print model ##########");
    System.out.println(phone);

    System.out.println("\n########## Make a call ##########");
    phone.call();
  }
}
