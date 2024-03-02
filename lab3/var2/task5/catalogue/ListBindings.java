package lab3.var2.task5.catalogue;

import java.util.ArrayList;
import lab3.var2.task5.models.Binding;

public class ListBindings {
  private ArrayList<Binding> list = new ArrayList();
  
  public ListBindings() {
    this.list.add(new Binding("softcover"));
    this.list.add(new Binding("hardcover"));
  }

  public ArrayList<Binding> getList() {
    return this.list;
  }

  public void setList(ArrayList<Binding> binding) {
    this.list = binding;
  }

  public void addBinding(Binding binding) {
    this.list.add(binding);
  }

  public Binding findById(int id) {
    for (Binding binding: this.list) {
      if (binding.getId() == id) {
        return binding;
      }
    }
    return null;
  }

  public String toString() {
    String result = "List of Bindings:\n";
    for (Binding binding: this.list) {
      result += binding.toString() + "; ";
    }
    return result;
  }
}
