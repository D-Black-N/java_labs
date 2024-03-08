package lab6.var2.task6.lines;

import lab6.var2.task6.Point;
import java.lang.Math;

public class SlopingLine implements Line {
  private double k;
  private double b;

  public SlopingLine(Point p1, Point p2) {
    this.k = Double.parseDouble(String.format("%.2f", (double) (p1.getY() - p2.getY()) / (p1.getX() - p2.getX())));
    this.b = Double.parseDouble(String.format("%.2f", p1.getY() - k * p1.getX()));
  }

  public boolean includePoint(Point point) {
    return point.getY() == k * point.getX() + b;
  }

  public double getK() { return k; }
  public double getB() { return b; }

  @Override
  public String toString() {
    String result = "Line:{y=" + k + "x";
    if (b < 0)
      result += "-" + Math.abs(b);
    else if (b > 0)
      result += "+" + b;

    return result + "}";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass())
      return false;

    SlopingLine line = (SlopingLine) obj;
    return b == line.getB() && k == line.getK();
  }

  @Override
  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = prime * result + (int) b;
    result = prime * result + (int) k;
    return result;
  }
}
