package lab5.var2.task6.models;

import java.lang.IllegalArgumentException;
import lab5.var2.task6.helpers.Validator;

public class House {
  private int        id;                // ID
  private int        flatNumber;        // Номер квартиры
  private int        square;            // Площадь
  private int        floor;             // Этаж
  private int        roomsNumber;       // Количество комнат
  private String     street;            // Улица
  private String     buildingType;      // Тип здания
  private int        serviceLife;       // Срок эксплуатации
  private static int autoIncrement = 1; // auto increment value for id

  private Validator validator = new Validator();

  public House(int flat, int square, int floor, int roomsNumber, String street, String type, int serviceLife) {
    this.id = autoIncrement;
    try {
      if (validator.validateInt(flat)) this.flatNumber = flat;
      if (validator.validateInt(square)) this.square = square;
      if (validator.validateInt(floor)) this.floor = floor;
      if (validator.validateInt(roomsNumber)) this.roomsNumber = roomsNumber;
      if (validator.validateString(street)) this.street = street;
      if (validator.validateString(type)) this.buildingType = type;
      if (validator.validateInt(serviceLife)) this.serviceLife = serviceLife;
      if (validator.validateInt(flatNumber)) this.flatNumber = flat;
      autoIncrement++;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public int getId() { return this.id; }

  public int getFlatNumber() { return this.flatNumber; }
  public void setFlatNumber(int flatNumber) { this.flatNumber = flatNumber; }

  public int getSquare() { return this.square; }
  public void setSquare(int square) { this.square = square; }

  public int getFloor() { return this.floor; }
  public void setFloor(int floor) { this.floor = floor; }

  public int getRoomsNumber() { return this.roomsNumber; }
  public void setRoomsNumber(int roomsNumber) { this.roomsNumber = roomsNumber; }

  public String getStreet() { return this.street; }
  public void setStreet(String street) { this.street = street; }

  public String getBuildingType() { return this.buildingType; }
  public void setBuildingType(String buildingType) { this.buildingType = buildingType; }

  public int getServiceLife() { return this.serviceLife; }
  public void setServiceLife(int serviceLife) { this.serviceLife = serviceLife; }

  public String toString() {
    return "House = { id: " + this.id + ", flatNumber: " + this.flatNumber + ", square: " + this.square + ", floor: " + this.floor +
           ", roomsNumber: " + this.roomsNumber + ", street: '" + this.street + "', buildingType: '" + this.buildingType +
           "', serviceLife: " + this.serviceLife + " }";
  }
}
