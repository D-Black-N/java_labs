package lab3.var2.task5.models;

import java.util.ArrayList;
import java.lang.InstantiationException;
import java.lang.IllegalArgumentException;
import lab3.var2.task5.helpers.Validator;

public class Book {
  private int                id;                // identifier
  private String             name;              // name of book
  private ArrayList<Author>  authors;           // authors ids
  private int                publisherId;       // publisher id
  private int                pageNumbers;       // number of pages
  private int                publishYear;       // published year
  private int                price;             // book price
  private int                bindingId;         // type of binding id
  private static int         autoIncrement = 1; // auto increment value for id

  private Validator validator = new Validator();

  public Book() throws InstantiationException {
    throw new InstantiationException("Cannot be instantiated");
  }

  public Book(String name, ArrayList<Author> authors, int publish, int pages, int year, int price, int binding) {
    this.id = autoIncrement;
    try {
      if (validator.validateString(name)) this.name = name;
      if (validator.validateInt(publish)) this.publisherId = publish;
      if (validator.validateYear(year)) this.publishYear = year;
      if (validator.validateInt(price)) this.price = price;
      if (validator.validateInt(binding)) this.bindingId = binding;
      this.authors = authors;
      autoIncrement++;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public int getId() { return this.id; }

  public String getName() { return this.name; }
  public void setName(String newName) { if (validator.validateString(name)) this.name = newName; }

  public int getPublisherId() { return this.publisherId; }
  public void setPublisherId(int id) { if (validator.validateInt(id)) this.publisherId = id; }

  public int getPageNumbers() { return this.pageNumbers; }
  public void setPageNumbers(int numbers) { if (validator.validateInt(numbers)) this.pageNumbers = numbers; }

  public int getPublishYear() { return this.publishYear; }
  public void setPublishYear(int year) { if (validator.validateYear(year)) this.publishYear = year; }

  public int getPrice() { return this.price; }
  public void setPrice(int newPrice) { if (validator.validateInt(newPrice)) this.price = newPrice; }

  public int getBindingId() { return this.bindingId; }
  public void setBindingId(int id) { if (validator.validateInt(id)) this.bindingId = id; }

  public ArrayList<Author> getAuthors() { return this.authors; }
  public void setAuthors(ArrayList<Author> newAuthors) { this.authors = newAuthors; }

  public void addAuthor(Author newAuthor) { this.authors.add(newAuthor); }

  public String toString() {
    return "Book = { id: " + this.id + ", name: '" + this.name + "', publisherId: " + this.publisherId + ", pageNumbers: " +
            this.pageNumbers + ", publishYear: " + this.publishYear + ", price: " + this.price + ", bindingId: " + this.bindingId +
            ", authorsCount: " + this.authors.size() + " }";
  }
}
