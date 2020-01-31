package Unit4.coin;

/**
 * Dime class
 * @author Ben Browner
 * @since 1/30/20
 */

public class Dime extends Coin {
    /**
     * Returns value of coin
     * @return the monetary weight of the coin, double
     */
    public double getValue() {
        return 0.1;
    }

    /**
     * Returns the name of the coin
     * @return the name of the coin
     */
    public String getName() {
        return "dime";
    }
}
