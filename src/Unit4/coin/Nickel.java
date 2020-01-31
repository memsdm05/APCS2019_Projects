package Unit4.coin;

/**
 * Nickel class
 * @author Ben Browner
 * @since 1/30/20
 */

public class Nickel extends Coin {
    /**
     * Returns value of coin
     * @return the monetary weight of the coin, double
     */
    public double getValue() {
        return 0.05;
    }

    /**
     * Returns the name of the coin
     * @return the name of the coin
     */
    public String getName() {
        return "nickel";
    }
}
