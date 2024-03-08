package lab6.var2.task6.lines;

import lab6.var2.task6.Point;

public class HorizontalLine implements Line {
  private int b;

  public HorizontalLine(int value) {
    this.b = value;
  }

  public boolean includePoint(Point point) {
    return b == point.getY();
  }

  public int getB() { return b; }

  @Override
  public String toString() {
    return "Line:{y=" + b + "}";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass())
      return false;

    HorizontalLine line = (HorizontalLine) obj;
    return b == line.getB();
  }

  @Override
  public int hashCode() {
    return 31 * 21 * b;
  }
}
