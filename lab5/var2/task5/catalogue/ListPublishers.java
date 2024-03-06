package lab5.var2.task5.catalogue;

import java.util.ArrayList;
import lab5.var2.task5.models.Publisher;

public class ListPublishers {
  private ArrayList<Publisher> list = new ArrayList();
  
  public ListPublishers() {
    this.list.add(new Publisher("Saint-Petersburg"));
    this.list.add(new Publisher("Moscow"));
    this.list.add(new Publisher("Novosibirsk"));
  }

  public ArrayList<Publisher> getList() {
    return this.list;
  }

  public void setList(ArrayList<Publisher> publishers) {
    this.list = publishers;
  }

  public void addPublisher(Publisher publisher) {
    this.list.add(publisher);
  }

  public Publisher findPublisher(String name) {
    for (Publisher publisher: this.list) {
      if (publisher.getName().equals(name)) {
        return publisher;
      }
    }
    return null;
  }

  public Publisher findById(int id) {
    for (Publisher publisher: this.list) {
      if (publisher.getId() == id) {
        return publisher;
      }
    }
    return null;
  }

  public String toString() {
    String result = "List of publishers:\n";
    for (Publisher publisher: this.list) {
      result += publisher.toString() + "; ";
    }
    return result;
  }
}
