package Unit4.coin;



public abstract class Coin {
    /**
     * returns .01, .05, .5, etc based on implementing class object's value
     * @return value of coin, double
     */
    public abstract double getValue();

    /**
     * returns "penny", "nickel", etc
     * @return name of coin, String
     */
    public abstract String getName(); //

    /**
     * define in the class: pennies, dimes...
     * @return plural noun of coin, String
     */
    public String getPluralName() {
        if (getName() == "penny") // pennies are the only outlier
            return "pennies";
        else
            return getName() + "s";
    }

}
