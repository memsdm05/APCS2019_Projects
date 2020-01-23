package Unit4.coin;

import java.util.ArrayList;
public class CoinSorterMachine{
    private ArrayList<Coin> coins;
    // initializes coins ArrayList
    public CoinSorterMachine() {
        coins = new ArrayList<Coin>();
    }
    // use one or two Scanner objects, prompting user for the appropriate file
    // name and importing the data from filename
    public void depositCoins() {

    }
    // Prints deposit summary using a DecimalFormat object (see output section)
    public void printDepositSummary() {

    }
    // return the total value of all Coin objects stored in coins as a double
    public double getTotalValue() {
        return 0.0;
    }

    // main method for the class should use these exact three lines of code
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
// end of class CoinSorterMachine
}
