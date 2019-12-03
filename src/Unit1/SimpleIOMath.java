package Unit1;


import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

;


/**
 * HolyGrail but with more bells and whistles
 * @author 22browner
 * @since 9 /10/19
 */

public class SimpleIOMath extends JFrame{

    private String name;
    private String numFB;
    private String fizzBuzz;
    private int age;
    private int favNumber;

    /**
     * The constant SEED.
     */
    private static long SEED; /* 420 */
    /**
     * The constant PIXELS.
     */
    public static int PIXELS = 80;
    /**
     * The constant SMOOTH_ITERATION.
     */
    public static int SMOOTH_ITERATION = 10;

    /**
     * The constant WATER_THRESHOLD.
     */
    public static int WATER_THRESHOLD = 87;
    /**
     * The constant LAND_THRESHOLD.
     */
//    public static int BEACH_THRESHOLD = 81;
    public static int LAND_THRESHOLD = 110;
    /**
     * The constant MOUNTAIN_THRESHOLD.
     */
    public static int MOUNTAIN_THRESHOLD = 130;

    /**
     * The constant NOISE_TO_ZERO.
     */
    public static double NOISE_TO_ZERO = 0.58;
    /**
     * The constant NOISE_TO_PEAK.
     */
    public static double NOISE_TO_PEAK = 0.7;

    /**
     * Main entry point
     *
     * @param args args for command line
     */
    public static void main(String[/*Ooh cool inline comments*/] args) {
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
//        obj.extra();
        new SimpleIOMath().setVisible(true);
    }

    /**
     * Prompt user.
     */
    public void promptUser() { //Prompts the user for the information
        Scanner input = new Scanner(System.in);
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        System.out.print("Question 1: What is your name? ");
        name = input.nextLine();
        System.out.print("Question 2: How old are you? ");
        age = input.nextInt();
        System.out.print("Question 3: What is your favorite number? ");
        favNumber = input.nextInt();
    }

    /**
     * Print info.
     */
    public void printInfo() { //Compiles and prints info from promptUser
        System.out.println("I'm gonna teach you how to sing it out\n" +
                "Come on, come on, come on\n" +
                "Let me tell you what it's all about\n" +
                "Reading, writing, arithmetic\n" +
                "Are the branches of the learning tree");
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.printf("At your next birthday, you will turn %d.\n", age + 1);
        for (int x = 1; x <= age; x++) {
            if (findPrime(x) && age%x==0) {
                System.out.printf("The first prime factor of %d is: %d\n", age, x);
                break;
            }
        }
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + favNumber*favNumber);
        SEED = favNumber + age;
        System.out.println("* End of program *");

        try {Thread.sleep(1000);}
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        System.out.println("Ok the thing is...");
        try {Thread.sleep(1000);}
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        System.out.println("I HAD to go graphical, it's practically tradition...");
        try {Thread.sleep(1000);}
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        System.out.println("Last time it was a comic, AND THIS TIME IS A PROCEDURALLY GENERATED MAP!");
        try {Thread.sleep(1000);}
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        System.out.println("In this modern world of graphical wonders wouldn't it be fit to present it in such way...");
        System.out.println("If you check in your toolbar you will see a Java applet of a map based on your favorite number and age!!!");
        try {Thread.sleep(1000);}
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        System.out.println("Algorithm made completely in-house :)");

    }

    private boolean findPrime(int n) { // Simple prime finder algoithm
        if (n <= 1)
            return false;
        for (int i = 2; i <= n; i++)
            if (n % i == 0)
                return true;
        return false;
    }


/*
    private void extra() { // fizzbuzz extra (NOT EXTRA I LIED LOOK AT THIS CRAP I HAVE A BETTER EXTRA MUHAHAHAHAHA)
        Scanner input = new Scanner(System.in);
        try {Thread.sleep(1500);}
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        System.out.println("or is it?");
        System.out.println("Play a game of Fizz Buzz with me and I'll let you be");
        System.out.println("If you last until 20 I'll close peacefully");
        System.out.println("https://en.wikipedia.org/wiki/Fizz_buzz");
        System.out.println("Let me start");
        try {Thread.sleep(3000);}
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        System.out.println("1");
        for (int num = 2; num < 21; num++) {

            String fizzBuzz = Integer.toString(num);

            if (num%3==0) {fizzBuzz = ""; fizzBuzz = fizzBuzz.concat("Fizz");}
            if (num%5==0) {fizzBuzz = ""; fizzBuzz = fizzBuzz.concat("Buzz");}

            if (num % 2 == 0) {
                System.out.println(fizzBuzz);
            }
            else {
                System.out.println(fizzBuzz);
                numFB = input.nextLine();
                if (!(fizzBuzz.equalsIgnoreCase(numFB))) {
                    System.out.println("Ah you got it wrong. You have been cursed with JAHVA!");
                    System.exit(1);
                }
            }
        }
        System.out.println("OORAH! You played my game!");
    }
*/


    // MAP GEN START FROM HERE
    /**
     * Instantiates a new Simple io math.
     */
    public SimpleIOMath() {
        super("Land of YOU!");
        setBounds(100, 100, 800, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Get box double [ ] [ ].
     *
     * @return the double [ ] [ ]
     */
    private static double[][] getBox() {
        Random rand = new Random(SEED);
        double[][] box = new double[PIXELS][PIXELS];
        for(int r = 0; r < box.length; r++) {
            for(int c = 0; c < box[r].length; c++) {
                if (rand.nextDouble() < NOISE_TO_ZERO) {
                    if (rand.nextDouble() < NOISE_TO_PEAK) {
                        box[r][c] =  150 + rand.nextDouble() * 100;
                    }
                    else {
                        box[r][c] = rand.nextDouble() * 100;
                    }

                }
                else {
                    box[r][c] = 0.0;
                }
            }
        }
        return box;
        //System.out.println(input);
    }

    /**
     * Grid print.
     *
     * @param box the box
     */
    public static void gridPrint(double[][] box) {
        for(int r = 0; r < box.length; r++) {
            System.out.println();
            for (int c = 0; c < box[r].length; c++) {
                System.out.print((int) (box[r][c]));
                System.out.print(' ');
            }
        }
        System.out.println();
    }

    /**
     * Blur double [ ] [ ].
     *
     * @param box  the box
     * @param iter the iter
     * @return the double [ ] [ ]
     */
    public static double[][] blur(double[][] box, int iter) {
        for(int i = 0; i < iter; i++) {
            // go through each element
            for(int r = 0; r < box.length; r++) {
                for(int c = 0; c < box[r].length; c++) {
                    double boxSum = 0.0;
                    int items = 0;

                    // offsets for each pixel
                    for(int y = -1; y < 2; y++) {
                        for(int x = -1; x < 2; x++) {
                            try {
                                boxSum += box[r+y][c+x];
                                items ++;
                            }
                            catch(Exception e) {}

                        }
                    }

                    box[r][c] = boxSum / items;
                }
            }
        }

        return box;
    }

    //public static double[][] getBox()    { return box; }

    /**
     * Grid paint.
     *
     * @param g   the g
     * @param box the box
     */
    public void gridPaint(Graphics g, double[][] box) {
        Color col;
        for(int r = 0; r < box.length; r++) {
            for(int c = 0; c < box[r].length; c++) {

                int shit = (int)(box[r][c]);

                if (shit < WATER_THRESHOLD) {
                    col = new Color(0, 0, shit+100);
                }
                else if (shit < LAND_THRESHOLD) {
                    col = new Color(0, shit+50, 0);
                }
                else if (shit < MOUNTAIN_THRESHOLD) {
                    col = new Color(shit+10, 69, 19);
                }
                else {
                    col = Color.white;
                }

                g.setColor(col);
                g.fillRect(r*(800/PIXELS), c*(800/PIXELS), (800/PIXELS), (800/PIXELS));
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        double[][] box = SimpleIOMath.getBox();
        double[][] blurBox = SimpleIOMath.blur(box, SMOOTH_ITERATION);
        gridPaint(g, blurBox);

    }

}
