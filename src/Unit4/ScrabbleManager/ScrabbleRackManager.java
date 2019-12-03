package Unit4.ScrabbleManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ScrabbleRackManager {
    private ArrayList<String> distro_letters;
    public String[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    public int[] distro = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
    public String[] set = new String[7];

    /** class constructor */
    public ScrabbleRackManager() {
        distro_letters = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            int lol = randHelper(0, 25);
            set[i] = letters[lol];
        }
    }

    /**
     * builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile
     * rack
     */
    public ArrayList<String> getPlaylist() {
        ArrayList<String> dict = new ArrayList<String>();
        String next;
        int count;
        try {
            Scanner file = new Scanner(new File("data/SCRABBLE_WORDS.txt"));
            while (file.hasNextLine()) {
                count = 0;
                next = file.nextLine().toUpperCase();
                String[] tempSet = set.clone();
                for (int i = 0; i < next.length(); i++) {
                    for (int j = 0; j < 7; j++) {
                        if (tempSet[j].equals(next.substring(i, i+1))) {
                            count++;
                            tempSet[j] = "*";
                        }
                    }
                }
                if (count == next.length() && next.length() < 8) {
                    dict.add((count==set.length)? next + "*" : next);
                }
            }

            file.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        Collections.sort(dict);
        return dict;
    }

    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    /** displays the contents of the player's tile rack */
    public void printRack() {
        System.out.println("Letters in the rack: " + Arrays.toString(set));
    }

    /** print all of the playable words based on the letters in the tile rack */
    public void printMatches() {
        for (String s : getPlaylist()) {
            System.out.print(s + " ");
        }
    }
    /** main method for the class; use only 3 command lines in main */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}
