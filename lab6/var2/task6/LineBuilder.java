package lab6.var2.task6;

import java.lang.IllegalArgumentException;
import lab6.var2.task6.lines.*;

public class LineBuilder {
  public static Line build(Point p1, Point p2) {
    Line line;
    if (p1 == null || p2 == null)
      throw new IllegalArgumentException("Points must be initialized");
    else if (p1.getX() - p2.getX() == 0 && p1.getY() - p2.getY() == 0)
      throw new IllegalArgumentException("Points must not have same coordinates");
    else if (p1.getX() - p2.getX() == 0)
      line = new VerticalLine(p1.getX());
    else if (p1.getY() - p2.getY() == 0)
      line = new HorizontalLine(p1.getY());
    else
      line = new SlopingLine(p1, p2);

    return line;
  }
}
