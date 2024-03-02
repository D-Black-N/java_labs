package lab3.var2.task5.models;

import java.util.ArrayList;
import lab3.var2.task5.helpers.Validator;
import java.lang.IllegalArgumentException;

public class Author {
  private int             id;                // publishing id
  private String          name;              // publishing name
  private ArrayList<Book> books;             // books of current author
  private static int      autoIncrement = 1; // auto increment for id

  private Validator validator = new Validator();

  public Author() throws InstantiationException {
    throw new InstantiationException("Cannot be instantiated");
  }

  public Author(String authorName) {
    this.id = autoIncrement; 
    this.books = new ArrayList();
    try {
      if (validator.validateString(authorName)) this.name = authorName;
      autoIncrement++;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public ArrayList<Book> getBooks() {
    return this.books;
  }

  public void setBooks(ArrayList<Book> newBooks) {
    this.books = newBooks;
  }

  public void addBook(Book newBook) {
    this.books.add(newBook);
  }

  public String toString() {
    return "Author = { id: " + this.id + ", name: '" + this.name + "', booksCount: " + this.books.size() + " }";
  }
}
