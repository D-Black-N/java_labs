package lab6.var1.task5;

import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

public class Polynom {
  private List<Integer> coefficients;
  private List<Integer> degrees;

  public Polynom(List<Integer> coefficients, List<Integer> degrees) {
    if (validateSizes(coefficients, degrees)) {
      this.coefficients = coefficients;
      this.degrees = degrees;
    } else {
      throw new IllegalArgumentException("Size of coefficients and degrees must be the same");
    }
  }

  public List<Integer> getCoefficients() { return this.coefficients; }
  public List<Integer> getDegrees() { return this.degrees; }

  public String toString() {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < degrees.size(); i++) {
      result.add(coefficients.get(i) + "X^" + degrees.get(i));
    }
    return String.join(" + ", result);
  }

  private boolean validateSizes(List<Integer> coefficients, List<Integer> degrees) {
    return coefficients.size() == degrees.size();
  }
}
