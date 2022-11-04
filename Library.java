
/* This is a stub for the Library class */
import java.util.Hashtable;
import java.util.Set;

public class Library extends Building {
  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();

    System.out.println("You have built a library!");
  }

  public void addTitle(String title) { // adding books to collection
    this.collection.put(title, true);
    System.out.println("Book has been added to the collection");

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
    System.out.println(this.collection);
    for (String key : keys) {
      System.out.println("The status of " + key + " is " + this.collection.get(key));
    }
    ;

  }

  public static void main(String[] args) {
    Library Neilson = new Library("Neilson", "1 Chapin Way", 3);
    Neilson.addTitle("Catching Fire");
    Neilson.addTitle("Clockwork Orange");
    Neilson.addTitle("Heartstopper");
    Neilson.addTitle("This Poison Heart");
    Neilson.checkOut("Heartstopper");
    System.out.println(Neilson.containsTitle("Data Feminism"));
    System.out.println(Neilson.isAvailable("Heartstopper"));
    // Neilson.checkIn("Heartstopper");
    // System.out.println(Neilson.removeTitle("Heartstopper"));
    Neilson.printCollection();

  }

}