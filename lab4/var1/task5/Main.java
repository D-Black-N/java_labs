package lab4.var1.task5;

public class Main {
  public static void main(String[] args) {
    Calendar calendar = new Calendar();

    System.out.println("########## Print initial holidays ##########");
    System.out.println(calendar.getHolidays());

    System.out.println("########## Print date without holiday ##########");
    System.out.println(calendar.getDate("2024-03-19"));

    System.out.println("########## Print date with holiday ##########");
    System.out.println(calendar.getDate("2024-03-08"));

    System.out.println("########## Add holiday and print all holidays ##########");
    calendar.addHoliday("2024-03-09", "Test holiday");
    System.out.println(calendar.getHolidays());
  }
}
