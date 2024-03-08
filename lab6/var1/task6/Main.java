package lab6.var1.task6;

public class Main {
  public static void main(String[] args) {
    System.out.println("########## Initialize list ##########");
    Sort sorter = new Sort(10);
    System.out.println(sorter.getList());

    System.out.println("########## Sort list ##########");
    sorter.sort();
    System.out.println(sorter.getList());
  }
}
