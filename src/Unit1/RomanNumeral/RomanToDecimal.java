package Unit1.RomanNumeral;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * The type Roman to decimal.
 * @author Ben Browner
 * @since 9/16/19
 */

public class RomanToDecimal {
    private final static TreeMap<Integer, String> dtr = new TreeMap<Integer, String>();
    private final static TreeMap<String, Integer> rtd = new TreeMap<String, Integer>();

    static {
        dtr.put(1000, "M");
        dtr.put(900, "CM");
        dtr.put(500, "D");
        dtr.put(400, "CD");
        dtr.put(100, "C");
        dtr.put(90, "XC");
        dtr.put(50, "L");
        dtr.put(40, "XL");
        dtr.put(10, "X");
        dtr.put(9, "IX");
        dtr.put(5, "V");
        dtr.put(4, "IV");
        dtr.put(1, "I");
        for (Map.Entry<Integer, String> e: dtr.entrySet()) {
            rtd.put(e.getValue(), e.getKey());
        }
    }

    /**
     * Roman to decimal converter. Handles invalid and illogical with a -1 flag
     *
     * @param roman is a string that should be a valid roman numeral
     * @return an interger
     */
    public static int romanToDecimal(String roman) {
        int sum = 0;
        int checksum = 0;
        roman = roman.toUpperCase();

        for (int i = 0; i < roman.length(); i++) {
            String sub = roman.substring(i, i+1);
            if (rtd.containsKey(sub)) {
                sum += rtd.get((sub));
                checksum += 1;

                try {
                    if (rtd.containsKey(roman.substring(i, i + 2))) {
                        sum -= rtd.get(sub) * 2;
                    }
                } catch (Exception e) {}
            }
        }
        // equalsIgnoreCase is a method that returns true if both string.equalsIgnoreCase(string2) is equal
        // does not check case of either string
        if ((checksum != roman.length()) || !(decimalToRoman(sum).equalsIgnoreCase(roman)))
            return -1;
        return sum;
    }

    // https://stackoverflow.com/a/19759564/11472529
    private static String decimalToRoman(int num) {
        int l =  dtr.floorKey(num);
        if (num == l)
            return dtr.get(num);
        return dtr.get(l) + decimalToRoman(num-l);
    }

//    private static void csvWriter(String[] data) {
//        File file = new File("/Users/22browner/IdeaProjects/HolyGrail/src/Unit1/RomanNumeral/22browner_whitebox.csv");
//        FileWriter fr = null;
//        try {
//            fr = new FileWriter(file);
//            fr.write("INPUT, EXPECTED OUTPUT, OUTPUT, COMMENTS\n");
//            for (String f: data)
//                fr.write(String.format("%s , , %d, \n", f, romanToDecimal(f), romanToDecimal(f)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            //close resources
//            try {
//                fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
//        csvWriter(args);
        for (String a: args) {
            int val = romanToDecimal(a);
            if (val == -1)
                System.out.printf("Input: %s => output: invalid\n", a);
            else
                System.out.printf("Input: %s => output: %d\n", a, val);

        }
    }
}
