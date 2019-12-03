package Unit2.BMI;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * The type BMI calculator.
 * @author 22browner
 * @since 10/4/19
 */
public class BMICalculator {

    /**
     * Convert imperial to metric units, perform the BMI calculation.
     *
     * @param inches height of the user, int
     * @param pounds weight of the user, int
     * @return caulculated BMI, double
     */
    public static double computeBMI(int inches, int pounds) {
        double m = inches * 0.0254;
        double kg = pounds * 0.454;
        double bmi = kg / (m * m);
        if (bmi <= 0 || kg <= 0 || m <= 0)
            return 0.0;
        return bmi;
    }

    private static int parser(String input) {
        int inches = 0;
        int feet = Integer.parseInt(input.substring(0, input.indexOf("\'")));
        try {inches = Integer.parseInt(input.substring(input.indexOf("\'")+1, input.indexOf("\"")));}
        catch(Exception e) {}
        return feet * 12 + inches;
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your height in feet and inches ( Ex 6'1\"): ");
        String stuff = scan.nextLine();

        if (stuff.equals("0")) {System.err.println("lol no"); System.exit(1);}
        int inches = parser(stuff);


        System.out.print("Enter your weight in pounds: ");
        int pounds = scan.nextInt();


        System.out.print("Your BMI, expressed as weight(kg)/height(m)^2: ");
        System.out.printf("%.2f kg/m^2\n", computeBMI(inches, pounds));
        scan.close();

    }

}
