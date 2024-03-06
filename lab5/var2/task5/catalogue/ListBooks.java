package lab5.var2.task5.catalogue;

import java.util.ArrayList;
import lab5.var2.task5.models.*;
import java.util.Random;
import java.time.Year;

public class ListBooks {
  private ArrayList<Book> list = new ArrayList();
  
  public ListBooks(ListAuthors authors, ListPublishers publishers, ListBindings bindings) {
    Random rand = new Random();
    for(Author author: authors.getList()) {
      for (int i = 0; i < 2; i++) {
        String bookName = author.getName() + "_книга_" + (i + 1);
        int[] authorIds = { author.getId() };
        Book book = new Book(
          bookName,
          authors.selectAuthors(authorIds),
          publishers.findById(rand.nextInt(1, 4)).getId(),
          rand.nextInt(50, 1001),
          rand.nextInt(1800, Year.now().getValue()),
          rand.nextInt(500, 5001),
          bindings.findById(i + 1).getId()
        );
        list.add(book);
        author.addBook(book);
      }
    }
  }

  public ArrayList<Book> getList() {
    return this.list;
  }

  public void setList(ArrayList<Book> books) {
    this.list = books;
  }

  public void addBook(Book book) {
    this.list.add(book);
  }

  public ArrayList<Book> selectBooksByPublisher(int publisherId) {
    ArrayList<Book> findedBooks = new ArrayList();
    for (Book book: list) {
      if (book.getPublisherId() == publisherId) {
        findedBooks.add(book);
      }
    }
    return findedBooks;
  }

  public ArrayList<Book> selectBooksFromYear(int fromYear) {
    ArrayList<Book> findedBooks = new ArrayList();
    for (Book book: list) {
      if (book.getPublishYear() >= fromYear) {
        findedBooks.add(book);
      }
    }
    return findedBooks;
  }

  public String toString() {
    String result = "List of Books:\n";
    for (Book book: this.list) {
      result += book.toString() + "; ";
    }
    return result;
  }
}
