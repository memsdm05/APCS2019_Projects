package Unit4.coin;

public abstract class Coin {
    public abstract double getValue(); // returns .01, .05, .5, 1.0 based on implementing class object's value

    public abstract String getName(); // returns "penny", "nickel", "half dollar", "dollar"

    public String getPluralName() { // define in the class: pennies, dimes...
        if (getName() == "penny") {
            return "pennies";
        }
        else {
            return getName() + "s";
        }
    }

}
