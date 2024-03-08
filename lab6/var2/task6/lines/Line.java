package lab6.var2.task6.lines;

import java.lang.Math;
import lab6.var2.task6.Point;

public interface Line {
  public boolean includePoint(Point point);
  public String toString();
  public boolean equals(Object obj);
  public int hashCode();
}
