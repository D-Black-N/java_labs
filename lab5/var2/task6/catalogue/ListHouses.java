package lab5.var2.task6.catalogue;

import java.util.ArrayList;
import lab5.var2.task6.models.House;

public class ListHouses {
  ArrayList<House> list = new ArrayList();

  public ListHouses(int flatNumbers) {
    int[] squares = { 30, 50, 70 };
    int[] rooms = { 1, 2, 3};
    for (int flatNum = 0; flatNum < flatNumbers; flatNum++) {
      this.list.add(
        new House(
          flatNum + 1,
          squares[(flatNum % 3)],
          (flatNum / 3 + 1),
          rooms[(flatNum % 3)],
          "Улица",
          "Панельный",
          15
        )
      );
    }
  }

  public ArrayList<House> selectHousesByRoomsNumber(int number) {
    ArrayList<House> houses = new ArrayList();
    for (House house: this.list) {
      if (house.getRoomsNumber() == number)
        houses.add(house);
    }
    return houses;
  }

  public ArrayList<House> filterByFloor(int startFloor, int endFloor, ArrayList<House> houses) {
    ArrayList<House> resultHouses = new ArrayList();
    for (House house: houses) {
      if (house.getFloor() >= startFloor && house.getFloor() <= endFloor)
        resultHouses.add(house);
    }
    return resultHouses;
  }

  public ArrayList<House> selectHousesFromSquare(int minSquare) {
    ArrayList<House> houses = new ArrayList();
    for (House house: this.list) {
      if (house.getSquare() >= minSquare)
        houses.add(house);
    }
    return houses;
  }
}
