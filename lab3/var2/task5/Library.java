package lab3.var2.task5;

import java.util.ArrayList;
import lab3.var2.task5.catalogue.*;
import lab3.var2.task5.models.*;

public class Library {
  private ListBooks      books;
  private ListAuthors    authors;
  private ListPublishers publishers;
  private ListBindings   bindings;

  public Library() {
    authors    = new ListAuthors();
    publishers = new ListPublishers();
    bindings   = new ListBindings();
    books      = new ListBooks(authors, publishers, bindings);
  }

  public String booksByAuthor(String authorName) {
    Author author = authors.findAuthor(authorName);
    if (author != null) {
      return author.getBooks().toString();
    } else {
      return "Author not found.";
    }
  }

  public String booksByPublisher(String publisherName) {
    Publisher publisher = publishers.findPublisher(publisherName);
    if (publisher != null) {
      ArrayList<Book> selectedBooks = books.selectBooksByPublisher(publisher.getId());
      if (selectedBooks.size() != 0) {
        return selectedBooks.toString();
      } else {
        return "Books from publisher " + publisherName + " not found.";
      }
    } else {
      return "Publisher not found.";
    }
  }

  public String booksFromYear(int fromYear) {
    ArrayList<Book> selectedBooks =  books.selectBooksFromYear(fromYear);
    if (selectedBooks.size() != 0) {
      return selectedBooks.toString() + "; ";
    } else {
      return "Books not found.";
    }
  }
}
