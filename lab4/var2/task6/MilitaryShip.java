package lab4.var2.task6;

public abstract class MilitaryShip implements Ship {
  protected String type;
  protected int    weight;
  protected int    speed;

  public String getType() { return type; }
  public int getWeight() { return weight; }
  public int getSpeed() { return speed; }

  public String toString() {
    return "#MilitaryShip={ weight: '" + weight + "', type: '" + type + "', speed: " + speed + " }";
  }

  public abstract void startAttack();
}
