package lab5.var1.task6;

public class ContinuedFraction {
  private int      n;
  private double   x;
  private double[] a;

  public ContinuedFraction(int iterations, double initValue, double[] sequence) {
    this.n = iterations;
    this.x = initValue;
    this.a = sequence;
  }

  public double calculate(int depth) {
    if (depth == 0)
      return a[0];

    if (depth >= this.n) {
      System.out.println("Error! Initial depth must be less than arguments length");
      return 1;
    }

    return addition(this.a[depth], subtraction(this.x, calculate(division(depth, 1))));
  }
  
  private double addition(double first, double second) {
    return first + second;
  }

  private int division(int first, int second) {
    return first - second;
  }
    
  private double subtraction(double first, double second) {
    if (second == 0) throw new IllegalArgumentException("Second argument must not be 0");

    return first / second;
  }

  private double multiply(double first, double second) {
    return first * second;
  }
}
