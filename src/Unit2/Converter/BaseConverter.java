package Unit2.Converter;

import java.io.*;
import java.util.*;
import java.net.URL;

/**
 * Converts 2-16 base numbers to 2-16 base numbers
 * @author 22browner
 * @since 10/4/19
 */
public class BaseConverter {
//    private ArrayList<String[]> lines = new ArrayList<String[]>();

    private final static HashMap<Character, Integer> phase1 = new HashMap<Character, Integer>();
    private final static HashMap<Integer, String> phase2 = new HashMap<Integer, String>();


    /**
     * Instantiates a new Base converter.
     */
    public BaseConverter() {
            for (int i = 0; i < 10; i++)
                phase1.put((char)(i+'0'), i);
            phase1.put('A', 10);
            phase1.put('B', 11);
            phase1.put('C', 12);
            phase1.put('D', 13);
            phase1.put('E', 14);
            phase1.put('F', 15);
            for (Map.Entry<Character, Integer> e: phase1.entrySet())
                phase2.put(e.getValue(), String.valueOf(e.getKey()));
    }

    /**
     *  Main method for class BaseConverter. Yours should look just like this!
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }

    /**
     * Convert a String num in fromBase to base-10 int.
     *
     * @param num       the num
     * @param fromBase  the from base
     * @return the int
     */


    public int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase), sum = 0;
        for (int i = 0; i < num.length(); i++)
            sum += phase1.get(num.charAt(i)) * Math.pow(base, num.length() - 1 - i);
        return sum;
    }

    /**
     * Convert a base-10 int to a String number of base toBase.
     *
     * @param num    the num
     * @param toBase the to base
     * @return the string
     */
    public String intToStr(int num, int toBase) {
        if (num < toBase) {return phase2.get(num % toBase);}
        return intToStr(num/toBase, toBase) + phase2.get(num % toBase);
    }

    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */


    public void inputConvertPrintWrite() {
        try {
            PrintStream ps = new PrintStream( "converted.dat" );
            Scanner scanner = new Scanner(new File("values.dat"));

            while (scanner.hasNextLine()) {
                String[] l = scanner.nextLine().split("\t");
                System.out.println(l.length);

                if (Integer.parseInt(l[1]) < 2 || Integer.parseInt(l[1]) > 16){
                    System.out.printf("Invalid input base %s\n", l[1]);
                    continue;
                }
                if (Integer.parseInt(l[2]) < 2 || Integer.parseInt(l[2]) > 16) {
                    System.out.printf("Invalid output base %s\n", l[2]);
                    continue;
                }

                try {
                    String converted = intToStr(strToInt(l[0], l[1]), Integer.parseInt(l[2]));
                    System.out.printf("%s base %s = %s base %s\n", l[0], l[1], converted, l[2]);
                    ps.printf("%s\t%s\t%s\t%s\n", l[0], l[1], converted, l[2]);
                } catch (Exception e) {
                    System.out.printf("Invalid input number %s\n", l[0]);
                }

            }
            scanner.close();
            ps.close();
        } catch (Exception e) {System.err.print(e);}
    }
}
