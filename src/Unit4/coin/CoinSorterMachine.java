package Unit4.coin;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CoinSorterMachine{
    private ArrayList<Coin> coins;
    private String[] names;
    private int[] count;
    private double[] value;

    // initializes coins ArrayList
    public CoinSorterMachine() {
        coins = new ArrayList<Coin>();
        names = new String[]{"pennies", "nickels", "dimes", "quarters", "half dollars", "dollars"};
        count = new int[6];
        value = new double[6];
    }
    // use one or two Scanner objects, prompting user for the appropriate file
    // name and importing the data from filename
    public void depositCoins() {
        Scanner userScan = new Scanner(System.in);
        System.out.print("Enter the name of the data file for coin deposit: ");
        try {
            Scanner fileScan = new Scanner(new File(userScan.nextLine()));
            System.out.println("Depositing coins...");
            while (fileScan.hasNextLine()) {
                switch (fileScan.nextLine()) {
                    case "1":
                        coins.add(new Penny());
                        break;
                    case "5":
                        coins.add(new Nickel());
                        break;
                    case "10":
                        coins.add(new Dime());
                        break;
                    case "25":
                        coins.add(new Quarter());
                        break;
                    case "50":
                        coins.add(new HalfDollar());
                        break;
                    case "100":
                        coins.add(new Dollar());
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        for (Coin coin : coins) {
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(coin.getPluralName())) {
                    count[i]++;
                    value[i] += coin.getValue();
                    break;
                }
            }
        }

    }
    // Prints deposit summary using a DecimalFormat object (see output section)
    public void printDepositSummary() {
        DecimalFormat f = new DecimalFormat("'$'###,###,##0.00");
        System.out.println("Summary of deposit: ");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("\t%d %s ", count[i], names[i]);
            System.out.println(f.format(value[i]));
        }
        System.out.println("TOTAL DEPOSIT: " + f.format(getTotalValue()));
    }
    // return the total value of all Coin objects stored in coins as a double
    public double getTotalValue() {
        double sum = 0;
        for (Coin c : coins)
            sum += c.getValue();
        return sum;
    }

    // main method for the class should use these exact three lines of code
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
// end of class CoinSorterMachine
}
