package lab6.var1.task5;

import java.util.List;
import java.util.ArrayList;

public class MultiplyPolynoms {
  private Polynom first;
  private Polynom second;
  private Polynom result;

  public MultiplyPolynoms(Polynom one, Polynom another) {
    this.first = one;
    this.second = another;
  }

  public Polynom getResult() { return this.result; }

  public Polynom perform() {
    List<Integer> longCoefficients = new ArrayList<>();
    List<Integer> longDegrees = new ArrayList<>();

    for (int i = 0; i < first.getCoefficients().size(); i++) {
      for (int j = 0; j < second.getCoefficients().size(); j++) {
        longCoefficients.add(first.getCoefficients().get(i) * second.getCoefficients().get(j));
      }
    }

    for (int i = 0; i < first.getDegrees().size(); i++) {
      for (int j = 0; j < second.getDegrees().size(); j++) {
        longDegrees.add(first.getDegrees().get(i) + second.getDegrees().get(j));
      }
    }

    List<Integer> resultCoefficients = new ArrayList<>();
    List<Integer> resultDegrees = new ArrayList<>();

    int i = 0;
    while (i < longDegrees.size()) {
      int coefValue = longCoefficients.get(i);
      int degreeValue = longDegrees.get(i);
      int indexInDegrees = resultDegrees.indexOf(degreeValue);
      if (indexInDegrees == -1) {
        resultDegrees.add(degreeValue);
        resultCoefficients.add(coefValue);
      } else {
        int value = resultCoefficients.get(indexInDegrees);
        resultCoefficients.set(indexInDegrees, value + coefValue);
      }
      i++;
    }

    this.result = new Polynom(resultCoefficients, resultDegrees);
    return result;
  }
}
