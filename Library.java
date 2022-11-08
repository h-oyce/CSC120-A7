
/* This is a stub for the Library class */
import java.util.Hashtable;
import java.util.Set;
import java.util.Scanner;

public class Library extends Building {
  private Hashtable<String, Boolean> collection;
  private Boolean hasElevator;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = true;

    System.out.println("You have built a library!");
  }

  public void addTitle(String title) { // adding books to collection
    this.collection.put(title, true);
    System.out.println("Book has been added to the collection");

  }

  public void addTitle(int numTitles) { // add multiple books at once
    Scanner scan = new Scanner(System.in);
    int num = 1;
    while (num <= numTitles) {
      String title = scan.nextLine();
      System.out.println("Enter title");
      this.collection.put(title, true);
      num += 1;
    }

  }

  public String removeTitle(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.remove(title);
    }

    return title;
  }

  public void checkOut(String title) { // checking out books from collection
    if (this.collection.get(title) == true) {
      this.collection.put(title, false);
      System.out.println("You have borrowed that book");
    } else {
      System.out.println("Sorry, but we do not have have that book");
    }
  }

  public void checkIn(String title) { // changed the name to "checkIn" as "return" was giving me some errors
    if (this.collection.get(title) == false) {
      this.collection.put(title, true);
      System.out.println("You have retruned that book");
    } else {
      System.out.println("Sorry, but we already have our copy of that book");
    }
  }

  public boolean containsTitle(String title) { // returns true if the title appears as a key in the Libary's collection
    if (this.collection.containsKey(title)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isAvailable(String title) { // returns true if the title is currently available
    if (this.collection.get(title) == true) {
      return true;
    } else {
      return false;
    }
  }

  public void printCollection() { // prints out the entire collection in an easy-to-read way
    Set<java.lang.String> keys = this.collection.keySet();
    for (String key : keys) {
      System.out.println("The status of " + key + " is " + this.collection.get(key));
    }
    ;

  }

  public void printCollection(Boolean status) { // prints out collection based on availibility status
    Set<java.lang.String> keys = this.collection.keySet();
    if (status = true) {
      for (String key : keys) {
        if (this.collection.get(key) == true) {
          System.out.print(key + ", ");
        }
        ;
      }
      System.out.print("are all availible");
    }
    if (status = false) {
      for (String key : keys) {
        if (this.collection.get(key) == true) {
          System.out.print(key + ", ");
        }
      }
      System.out.print("are all not availible");
    }
  }

  @Override
  public void showOptions() { // overrides showOptions method from Building class
    System.out.println("Available options at " + this.name
        + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + checkIn(title) \n + containsTitle(title) \n + isAvailible(title) \n + printCollection()");
  }

  public void goToFloor(int floorNum) {
    super.goToFloor(floorNum);
    if (hasElevator == true) {
      System.out.println("...Using elevator...");
      super.goToFloor(floorNum);
    } else {
      System.out.println("This library doesn't have an elevator. Please take the stairs.");
    }
  }

  public static void main(String[] args) {
    Library Neilson = new Library("Neilson", "1 Chapin Way", 3);
    Neilson.addTitle(3);
    // Neilson.addTitle("This Poison Heart");
    // Neilson.checkOut("Heartstopper");
    // System.out.println(Neilson.containsTitle("Data Feminism"));
    // System.out.println(Neilson.isAvailable("Heartstopper"));
    // Neilson.checkIn("Heartstopper");
    // System.out.println(Neilson.removeTitle("Heartstopper"));
    // Neilson.printCollection(true);
    // Neilson.showOptions();
    // Neilson.enter();
    // Neilson.goToFloor(2);

  }

}