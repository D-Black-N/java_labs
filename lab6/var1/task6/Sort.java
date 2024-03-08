package lab6.var1.task6;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Sort {
  private List<Double> list;

  public Sort(int iterations) {
    Random rand = new Random();
    list = new ArrayList();
    for (int i = 0; i < iterations; i++) {
      list.add(Double.parseDouble(String.format("%.2f", rand.nextDouble() * 100 - 50)));
    }
  }

  public List<Double> getList() {
    return list;
  }

  public void sort() {
    int insertPosition = 0;
    boolean flag = false;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) >= 0 && flag) {
        list.add(insertPosition, list.get(i));
        list.remove(i + 1);
        insertPosition++;
      } else {
        flag = true;
      }
    }
  }
}
