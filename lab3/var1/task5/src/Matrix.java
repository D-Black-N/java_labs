package lab3.var1.task5.src;

import java.util.Random;
import java.lang.IllegalArgumentException;

public class Matrix {
  private int[][] matrix;
  private int     rows;
  private int     columns;

  public Matrix() {
    this.rows    = 3;
    this.columns = 3;
    this.matrix  = createMatrix();
  }

  public Matrix(int rows, int columns) {
    this.rows    = rows;
    this.columns = columns;
    this.matrix  = createMatrix();
  }

  public Matrix(int rows, int columns, int[][] initMatrix) {
    this.rows    = rows;
    this.columns = columns;
    this.matrix  = initMatrix;
  }

  public int getRows() { return this.rows; }
  public int getColumns() { return this.columns; }

  public int[][] changeMinMaxRows(int col) {
    if (col >= this.columns || col < 0) {
      throw new IllegalArgumentException("Column out of range 0.." + (this.columns - 1));
    }

    int[][] matrixDouble = this.matrix;
    int maxValue = matrixDouble[0][col];
    int minValue = matrixDouble[0][col];
    int maxRowId = 0;
    int minRowId = 0;

    for (int rowId = 1; rowId < this.rows; rowId++) {
      if (matrixDouble[rowId][col] > maxValue) {
        maxValue = matrixDouble[rowId][col];
        maxRowId = rowId;
      }
      if (matrixDouble[rowId][col] < minValue) {
        minValue = matrixDouble[rowId][col];
        minRowId = rowId;
      }
    }

    int[] changeRow = matrixDouble[minRowId];
    matrixDouble[minRowId] = matrixDouble[maxRowId];
    matrixDouble[maxRowId] = changeRow;

    return matrixDouble;
  }

  public Matrix square() {
    if (this.rows != this.columns) {
      return null;
    }

    int[][] resultMatrix = new int[this.rows][this.columns];
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++) {
        resultMatrix[i][j] = multiplyVectors(this.matrix[i], getColumn(j));
      }
    }
    return new Matrix(this.rows, this.columns, resultMatrix);
  }

  public void print() {
    for (int[] row: this.matrix) {
      for (int elem: row) {
        System.out.print(elem + "\t");
      }
      System.out.println();
    }
    System.out.println();
  }

  private int[] getColumn(int id) {
    int[] column = new int[this.rows];
    for (int i = 0; i < this.rows; i++) {
      column[i] = this.matrix[i][id];
    }
    return column;
  }

  private int multiplyVectors(int[] v1, int[] v2) {
    int result = 0;
    for (int i = 0; i < this.rows; i++) {
      result += v1[i] * v2[i];
    }
    return result;
  }

  private int[][] createMatrix() {
    Random rand = new Random();
    int[][] matrix = new int[this.rows][this.columns];
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++) {
        matrix[i][j] = rand.nextInt(-100, 100);
      }
    }
    return matrix;
  }
}
