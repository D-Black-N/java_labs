package lab4.var1.task5;

import java.util.ArrayList;

public class Calendar {
  private ArrayList<String>  dates = new ArrayList();
  private ArrayList<Holiday> holidays = new ArrayList();

  public Calendar() {
    for (int i = 1; i < 32; i++) {
      String prefix = i > 10 ? "0" : "";
      this.dates.add("2024-03-" + prefix + i);
    }
    addHoliday("2024-03-08", "Woman day");
  }

  public ArrayList<String> getDates() {
    return this.dates;
  }

  public String getDate(String date) {
    int i = 0;
    while (this.dates.size() != i && this.dates.get(i).equals(date))
      i++;
    if (i < this.dates.size()) {
      String result = this.dates.get(i);
      Holiday holiday = findHoliday(date);
      if (holiday != null) {
        result += ", Description: " + holiday.getDescription();
      }
      return result;
    } else {
      return "Date not found";
    }
  }

  public void addHoliday(String date, String description) {
    this.holidays.add(new Holiday(date, description));
  }

  public void removeHoliday(String date) {
    int i = 0;
    while (this.holidays.size() != i && this.holidays.get(i).getDate().equals(date))
      i++;
    if (i < this.holidays.size()) {
      this.holidays.remove(i);
    } else {
      System.out.println("Holiday not found");
    }
  }

  public ArrayList<Holiday> getHolidays() {
    return this.holidays;
  }

  public class Holiday {
    private String date;
    private String description;

    public Holiday(String date, String description) {
      this.date = date;
      this.description = description;
    }

    public String getDate() {
      return this.date;
    }

    public String getDescription() {
      return this.description;
    }

    public String toString() {
      return "Holiday={ date: " + this.date + ", description: '" + this.description + "' }";
    }
  }

  private Holiday findHoliday(String date) {
    int i = 0;
    while (this.dates.size() != i && this.dates.get(i).equals(date))
      i++;
    if (i < this.holidays.size()) {
      return this.holidays.get(i);
    } else {
      return null;
    }
  }
}
