package Other;
/**
 * Class JavaCTF is a test of your problem-solving skills, patience and
 * collective brain power. You must be clever and think on your feet!
 * @author Julian Cochran
 * @version 2.0 October 20, 2015
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaCTF {
    private String al;
    private ArrayList<String> alphabet;
    private int points;

    /**
     * Default constructor for class JavaCTF
     */
    public JavaCTF()	{
        al = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        String [] chs = al.split(" ");
        alphabet = new ArrayList<String>(Arrays.asList(chs));
        alphabet.add(" ");
        points = 0;
    }

    /**
     * This is question 1. Solve it!
     * @param cipher It's a secret -- SHHHHHH....
     * @return I'm not going to tell you that...
     */
    public boolean question1(String cipher)	{
        String formattedInput = cipher.toUpperCase();
        int alphabet_index = -1;
        // computer science is awesome atbash
        String hash = "";
        String bash = "23111310562182672317211223212617726253217111321262562425718";

        for(int i = 0; i < formattedInput.length(); i++)	{

            alphabet_index = alphabet.indexOf(formattedInput.substring(i, i+1));
            hash += (alphabet_index == 26) ? alphabet_index+"" : (25-alphabet_index)+"";
        }
        System.out.println(hash);
        points = hash.equals(bash) ? points+3 : points;
        System.out.println(hash.equals(bash) ? "Correct! Save your answer for later! Your score: " + points : "Incorrect; try again");
        return hash.equals(bash);
    }

    /**
     * This is question 2.  Solve it!
     * @param cipher It's a secret -- SHHHHHH....
     * @return I'm not going to tell you that...
     */
    public boolean question2(String cipher)	{
        try	{
            String[] splitInput = cipher.toUpperCase().split(" ");
            String formattedInput = "";
            for(int x = 0; x < splitInput.length-1; x++)
                formattedInput += (splitInput[x] + " ");



            int lastInt = Integer.parseInt(splitInput[splitInput.length-1]);
            int alphabet_index = -1;
            //
            String hash = "";
            //13: 13A14B15C16D17E18F19G20H21I22J23K24L25M0N1O2P3Q4R5S6T7U8V9W10X11Y
            //              O W LJ    __    __          __
            // 15 10 18 7 5 17 1
            String bash = "15101875171626141126151317513426016";

            for (int y = 0; y < 27; y++) {
                for(int i = 0; i < "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length()-1; i++) {
                    alphabet_index = alphabet.indexOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i, i + 1));
                    hash += (alphabet_index == 26) ? alphabet_index + "" : ((alphabet_index + y) % 26) + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i, i + 1);
                }
                System.out.println(y + ": " + hash);
                alphabet_index = -1;
                hash = "";
            }

            for(int i = 0; i < formattedInput.length()-1; i++) {
                alphabet_index = alphabet.indexOf(formattedInput.substring(i, i + 1));
                hash += (alphabet_index == 26) ? alphabet_index + "" : ((alphabet_index + lastInt) % 26) + "";
            }
            System.out.println(hash);
            points = hash.equals(bash) ? points+4 : points;
            System.out.println(hash.equals(bash) ? "Correct! Save your answer for later! Your score: " + points : "Incorrect; try again");
            return hash.equals(bash);
        }
        catch(Exception e)	{
            System.out.println("Incorrect; try again");
            return false;
        }
    }

    /**
     * This is question 3.  Solve it!
     * @param cipher It's a secret -- SHHHHHH....
     * @return I'm not going to tell you that...
     */
    public boolean question3(String cipher)	{
        String hash = "";
        for(int x = 0; x < cipher.length(); x++)
            hash += "" + (int)cipher.charAt(x);
        String bash = "1051101163210997105110401181111051004159";
        points = hash.equals(bash) ? points+3 : points;
        System.out.println(hash.equals(bash) ? "Correct! Save your answer for later! Your score: " + points : "Incorrect; try again");
        return hash.equals(bash);
    }

    public int getPoints()	{	return points;	}

    /**
     * Main method for class JavaCTF
     * @param args Command-line arguments, if needed.
     */
    public static void main(String[] args) {
        JavaCTF muhahahaha = new JavaCTF();
        Scanner in = new Scanner(System.in);
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Stop. Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
        System.out.println("King Arthur would tell you, \"Case sensitivity doesn't matter to me...I am king!\n");
        boolean[] q = new boolean[3];

        //question 1
        System.out.print("Question 1 (3 points): Tell me how you REALLY feel: ");
        q[0] = muhahahaha.question1(in.nextLine().toLowerCase());
        //question 2
        System.out.print("Question 2 (4 points): Whoop-dee-doo! Borat says, \"Tell me if you're confused and add a number too.\": ");
        q[1] = muhahahaha.question2(in.nextLine().toLowerCase());
        //question 3
        System.out.print("Question 3 (3 points): K&R entry? (hint: it's the 1st one) ");
        q[2] = muhahahaha.question3(in.nextLine().toLowerCase());

        //System.out.println("DEBUG: " + q[0] + " " + q[1] + " " + q[2]);

        if (q[0] && q[1] && q[2])
            System.out.println("*** YOU HAVE SUCCEEDED IN YOUR QUEST! SUBMIT YOUR ANSWERS IN THE FORM URL BELOW. ***");
        else
            System.out.println("*** YOUR CURRENT SCORE IS " + muhahahaha.getPoints() + ". YOU MAY TRY RUNNING THIS AGAIN, OTHERWISE ENTER YOUR ANSWERS IN THE FORM URL BELOW. ***");
        System.out.println("https://docs.google.com/forms/d/e/1FAIpQLScR0EgayENfTkx2s-95vZRNV_i3sDL-Oufv-lmiWahSJxXvrQ/viewform");
    }
}

// end of class JavaCTF
