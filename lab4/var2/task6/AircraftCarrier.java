package lab4.var2.task6;

public class AircraftCarrier extends MilitaryShip {
  private int square;

  public AircraftCarrier(int weight, int speed, int square) {
    this.type = "AircraftCarrier";
    this.weight = weight;
    this.speed = speed;
    this.square = square;
  }

  public void swim() {
    System.out.println("AircraftCarrier swimming!!!");
  }

  public void raiseFlag() {
    System.out.println("Flag raised!!!");
  }

  public void dropAnchor() {
    System.out.println("AircraftCarrier stopped!!!");
  }

  @Override
  public String toString() {
    return "#AircraftCarrier={ weight: '" + weight + "', type: '" + type + "', speed: " + speed + ", square: " + square + " }";
  }

  @Override
  public void startAttack() {
    System.out.println("AircraftCarrier fighters to launch");
  }
}
