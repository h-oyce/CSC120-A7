
/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building {
  private ArrayList<String> residents;
  private Boolean hasDiningHall;
  private Boolean hasElevator;

  public House(String name, String address, int nFloors, boolean hasdiningHall, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningHall = hasDiningHall;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house!");

  }

  public void moveIn(String resName) { // add the name of resident to house
    resName = resName.substring(0, 1).toUpperCase() + resName.substring(1).toLowerCase();
    this.residents.add(resName);

    System.out.println("Resident has been added!");
  }

  public String moveOut(String exResName) { // return the name of the person who moved out
    exResName = exResName.substring(0, 1).toUpperCase() + exResName.substring(1).toLowerCase();
    boolean resExists = false; // checking if resident lives here
    for (String x : this.residents) {
      if (x.equals(exResName)) {
        resExists = true;
      }
    }

    if (resExists == true) { // if resident lives here
      this.residents.remove(exResName);
      System.out.println("That person has been moved out");
    }

    if (resExists == false) { // resident doesn't live here
      System.out.println("That person doesn't lived here");

    }
    return exResName;
  }

  public boolean isResident(String person) {
    person = person.substring(0, 1).toUpperCase() + person.substring(1).toLowerCase();
    for (String x : this.residents) {
      if (x.equals(person)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void showOptions() { // overrides showOptions method from Building class
    System.out.println("Available options at " + this.name
        + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + moveIn(name) \n + moveOut(name) \n + isResident(name)");
  }

  public void goToFloor(int floorNum) {
    super.goToFloor(floorNum);
    if (hasElevator == true) {
      System.out.println("...Using elevator...");
      super.goToFloor(floorNum);
    } else {
      System.out.println("This house doesn't have an elevator. Please take the stairs.");
    }
  }

  public static void main(String[] args) {
    House Talbot = new House("Talbot", "25 Prospect St", 3, false, false);
    // Talbot.moveIn("Juniper");
    // Talbot.moveIn("Laura");
    // Talbot.moveIn("Chlo");
    // Talbot.moveOut("Laura");
    // System.out.println(Talbot.isResident("Grace"));
    // Talbot.showOptions();
    Talbot.enter();
    Talbot.goToFloor(1);
  }

}