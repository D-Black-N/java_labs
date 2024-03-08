package lab6.var2.task6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import lab6.var2.task6.lines.*;

import java.lang.IllegalArgumentException;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    Random rand = new Random();

    System.out.println("\n########## Initialize points ##########");
    List<Point> points = new ArrayList();
    int pointSize = rand.nextInt(5, 10);
    for (int i = 0; i < pointSize; i++) {
      points.add(new Point(rand.nextInt(-15, 15), rand.nextInt(-15, 15)));
    }
    System.out.println(points);

    System.out.println("\n########## Create Lines and add points ##########");
    HashMap<Line, Set<Point>> linesWithPoints = new HashMap();
    for (int i = 0; i < pointSize - 1; i++) {
      final int first = i;
      for (int j = first + 1; j < pointSize; j++) {
        final int second = j;
        try {
          Line line = LineBuilder.build(points.get(first), points.get(second));
          if (linesWithPoints.containsKey(line)) {
            linesWithPoints.computeIfPresent(line, (key, value) -> {
              value.add(points.get(first));
              value.add(points.get(second));
              return value;
            });
          } else {
            Set<Point> linePoints = new HashSet();
            linePoints.add(points.get(first));
            linePoints.add(points.get(second));
            linesWithPoints.put(line, linePoints);
          }
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
      }
    }

    System.out.println("\n########## Print lines with points ##########");
    for (Map.Entry<Line, Set<Point>> line : linesWithPoints.entrySet()) {
      System.out.println(line);
    }

    System.out.println("\n########## Print lines to file ##########");
    String filePath = "/app/lab6/var2/task6/data/file.txt";
    File file = new File(filePath);
    BufferedWriter bf = null;
    try {
      bf = new BufferedWriter(new FileWriter(file)); 
      for (Map.Entry<Line, Set<Point>> line : linesWithPoints.entrySet()) {
        bf.write(line.getKey() + " = " + line.getValue());
        bf.newLine();
      }
      bf.flush();
    } catch (IOException e) { 
      System.out.println(e.getMessage());
    } finally {
      try { bf.close(); } catch (Exception e) {}
    }
  }
}
