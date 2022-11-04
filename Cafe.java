/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugerPackets, int nCreams,
            int nCups) { // What variables are needed to build a cafew
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

        System.out.println("You have built a cafe: ☕");
    }

    private void restock(int coffeeAdded, int sugarAdded, int creamsAdded, int cupsAdded) { // restock supplies
        this.nCoffeeOunces += coffeeAdded;
        this.nSugarPackets += sugarAdded;
        this.nCreams += creamsAdded;
        this.nCups += cupsAdded;

    }

    public void sellCoffee(int size, int SugarPackets, int Creams) { // sell coffee based on availibility of stock
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams
                && this.nCups > 0) { // checking if there is enough stock for order
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= SugarPackets;
            this.nCreams -= Creams;
            this.nCups -= 1;
            System.out.println("Here's your coffee of " + size + " oz of coffee, " + SugarPackets + " sugar packets, "
                    + Creams + " cream packets.");
        } else { // when there's not enough for the order
            System.out.println("Sorry we have to restock, thank you for your patience!");
            restock(200, 50, 50, 50);

        }

    }

    public static void main(String[] args) {
        Cafe CC = new Cafe("Campus Cafe", "1 Chapin Way", 2, 200, 20, 20, 40);
        CC.sellCoffee(500, 2, 5);
    }

}
