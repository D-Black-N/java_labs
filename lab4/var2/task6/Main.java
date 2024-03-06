package lab4.var2.task6;

public class Main {
  public static void main(String[] args) {
    Ship aircraftCarrier = new AircraftCarrier(5000, 42, 100);

    System.out.println("\n########## Print Ship ##########");
    System.out.println(aircraftCarrier);

    System.out.println("\n########## Make a swim ##########");
    aircraftCarrier.swim();

    System.out.println("\n########## Make drop anchor ##########");
    aircraftCarrier.dropAnchor();

    System.out.println("\n########## Make raise flag ##########");
    aircraftCarrier.raiseFlag();

    AircraftCarrier newAircraftCarrier = new AircraftCarrier(5000, 42, 100);

    System.out.println("\n########## Print AircraftCarrier ##########");
    System.out.println(newAircraftCarrier);

    System.out.println("\n########## Start attack ##########");
    newAircraftCarrier.startAttack();
  }
}
