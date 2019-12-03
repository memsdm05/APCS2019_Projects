package Unit3.ISBN;

import java.io.File;
import java.util.Scanner;

/**
 * ISBN Validator
 * @author Ben Browner
 * @since 11/1/19
 */

public class ISBNValidator {
    private String[] validNums; // initialize to hold 1000 items
    private String[] invalidNums; // initialize to hold 1000 items

    /**
     * Simple constructor; initializes arrays
     */
    public ISBNValidator() {
        validNums = new String[1500];
        invalidNums = new String[1500];
    }

    /**
     * Imports .dat file, calls isValidISBN method and stores Strings into corresponding arrays
     */
    public void importData() {
        int i = 0, k = 0;
        String next;
        try {
            Scanner file = new Scanner(new File("data/isbn_files/isbn2.dat/"));
            while (file.hasNextLine()) {
                next = file.nextLine();
                if (isValidISBN(next)) {
                    validNums[i++] = next;
                }
                else {
                    invalidNums[k++] = next;
                }

            }
            file.close();

        } catch (Exception e) {System.err.println(e);}
    }

    // added for better readablity.
    private int strIndex(String string, int index) {
        return Integer.parseInt(string.substring(index,index+1));
    }

    /**
     * Determines validity of supplied ISBN number; called inside importData
     * @param isbn un-formatted ISBN code, String
     * @return is isbn valid, boolean
     */
    public boolean isValidISBN(String isbn) {
        isbn = isbn.replaceAll("-", "");
        String first3 = isbn.substring(0, 3);
        int checksum = 0;
        /* Mr. Cochran I have a real problem with the "978" and "979" checks. First off, it has no
        future proofing and will be bypassed once new leadings numbers are added. Two, if you want to
        make it update you would need it to have some kind of web polling to get it uodated. Don't worry,
        even I'm not THAT crazy.
         */
        if (isbn.length() != 13 && !first3.equals("978") && !first3.equals("979"))
            return false;

        for (int i = 0; i < 13; i++) {
            if (Character.isDigit(isbn.charAt(i)))
                checksum += (i%2==0)? strIndex(isbn, i) : strIndex(isbn, i)*3;
        }

        return checksum%10 == 0;
    }

    /**
     * output the user-picked ISBN list or quit the application
     */
    public void runProgram() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        boolean runAgain = true;
        do {
            System.out.println("All ISBN data has been imported and validated. Would you like to:");
            System.out.println("\t1) View all valid ISBN numbers");
            System.out.println("\t2) View all invalid ISBN numbers");
            System.out.println("\t3) Quit");
            System.out.print("Your selection: ");

            input = scan.nextInt();
            int lengthCounter = 0;
            if (input == 1) {
                for (String i : validNums) {
                    if (i != null) {
                        System.out.println(i);
                        lengthCounter++;
                    }
                }
                System.out.println(lengthCounter + " valid ISBN numbers");
            }
            else if (input == 2) {
                for (String i : invalidNums) {
                    if (i != null) {
                        System.out.println(i);
                        lengthCounter++;
                    }
                }
                System.out.println(lengthCounter + " invalid ISBN numbers");
            }
            else
                runAgain = false;

        }while (runAgain);

    }

    /**
     * Main entry point
     * @param args String[]
     */
    public static void main(String[] args){
        ISBNValidator app = new ISBNValidator ();
        System.out.println("* ISBN Validator Program *");
        System.out.println("...Importing data...");
        app.importData(); // imports data from the text file
        app.runProgram(); // runs using a while loop; see examples
        System.out.println("* End of Program *");
    }
}
