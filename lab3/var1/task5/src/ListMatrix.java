package lab3.var1.task5.src;

import java.util.ArrayList;

public class ListMatrix {
  private int      size;
  private Matrix[] list;

  public ListMatrix(int size) {
    this.size = size;
    this.list = initList();
  }

  public ListMatrix(int size, Matrix[] initList) {
    this.size = size;
    this.list = initList;
  }

  public Matrix[] getList() { return this.list; }
  public int getSize() { return this.size; }

  public ListMatrix changeRows(int col) {
    Matrix[] listDouble = new Matrix[this.size];
    for (int i = 0; i < this.size; i++) {
      listDouble[i] = new Matrix(this.list[i].getRows(), this.list[i].getColumns(), this.list[i].changeMinMaxRows(col));
    }
    return new ListMatrix(this.size, listDouble);
  }

  public Matrix square(int id) {
    if (id >= this.size || id < 0) {
      throw new IllegalArgumentException("Argument out of range 0.." + (this.size - 1));
    }

    return this.list[id].square();
  }

  public void printMatrixList() {
    for (Matrix matrix: this.list) {
      matrix.print();
    }
  }

  private Matrix[] initList() {
    Matrix[] list = new Matrix[this.size];
    for (int i = 0; i < this.size; i++) {
      list[i] = new Matrix();
    }
    return list;
  }
}
