package lab5.var2.task5.catalogue;

import java.util.ArrayList;
import lab5.var2.task5.models.Author;

public class ListAuthors {
  private ArrayList<Author> list = new ArrayList();
  
  public ListAuthors() {
    this.list.add(new Author("Гоголь"));
    this.list.add(new Author("Горький"));
    this.list.add(new Author("Пушкин"));
    this.list.add(new Author("Достоевский"));
    this.list.add(new Author("Лермонтов"));
  }

  public ArrayList<Author> getList() {
    return this.list;
  }

  public void setList(ArrayList<Author> authors) {
    this.list = authors;
  }

  public void addAuthor(Author author) {
    this.list.add(author);
  }

  public Author findAuthor(String name) {
    for (Author author: this.list) {
      if (author.getName().equals(name)) {
        return author;
      }
    }
    return null;
  }

  public ArrayList<Author> selectAuthors(int[] ids) {
    ArrayList<Author> authors = new ArrayList();
    for (int id: ids) {
      authors.add(findById(id));
    }
    return authors;
  }

  public String toString() {
    String result = "List of authors:\n";
    for (Author author: this.list) {
      result += author.toString() + "; ";
    }
    return result;
  }

  private Author findById(int id) {
    for (Author author: this.list) {
      if (author.getId() == id) {
        return author;
      }
    }
    return null;
  }
}
