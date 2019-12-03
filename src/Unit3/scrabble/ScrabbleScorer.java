package Unit3.scrabble;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A scrabble scorer
 * @author Ben Browner
 * @since 11/5/19
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private String alphabet;
    /**
     * Instantiates a new Scrabble scorer.
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<String>();
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    /**
     * Builds dictionary.
     */
    public void buildDictionary() {
        try {
            Scanner file = new Scanner(new File("data/SCRABBLE_WORDS.txt"));
            while (file.hasNextLine()) {
                String next = file.nextLine();
                dictionary.add(next);
            }
            file.close();

        } catch (Exception e) {System.err.println(e);}
        Collections.sort(dictionary);
    }

    /**
     * Is valid word boolean.
     *
     * @param word word to be validated, String
     * @return if the word is a valid scrabble word, boolean cochran
     */
    public boolean isValidWord(String word) {
        word = word.toUpperCase();
        return Collections.binarySearch(dictionary, word) > 0;
    }

    /**
     * Caulculates scrabble word score
     *
     * @param word valided scrabble word, String
     * @return the word score, int
     */
    public int getWordScore(String word) {
        word = word.toUpperCase();
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += points[alphabet.indexOf(word.charAt(i))];
        }
        return sum;
    }
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        Scanner scan = new Scanner(System.in);
        app.buildDictionary();
        boolean runAgain = true;
        do {
            System.out.print("Enter a word to score or 0 to quit: ");
            String line = scan.nextLine();
            if (app.isValidWord(line))
                System.out.println(line + " = " + app.getWordScore(line));
            else {
                if (line.equals("0")) {
                    System.out.println("Exiting the program thanks for playing");
                    runAgain = false;
                }
                else
                    System.out.println(line + " is not a valid word in the dictionary");
            }
        }while (runAgain);
    }
}
