package lab6.var2.task6.lines;

import lab6.var2.task6.Point;

public class VerticalLine implements Line {
  private int b;

  public VerticalLine(int value) {
    this.b = value;
  }

  public boolean includePoint(Point point) {
    return b == point.getX();
  }

  public int getB() { return b; }

  @Override
  public String toString() {
    return "Line:{x=" + b + "}";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass())
      return false;

    VerticalLine line = (VerticalLine) obj;
    return b == line.getB();
  }

  @Override
  public int hashCode() {
    return 31 * 11 * b;
  }
}
