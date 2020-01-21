package Unit4.ScrabbleManager;

import java.io.File;
import java.util.*;

public class ScrabbleRackManager {
    private ArrayList<String> tileRack;
    private ArrayList<String> dict;
    private int tileLen;
    private int comp;
//    private ArrayList<ArrayList<ArrayList<String>>> dict;
    // Buckets of first letters(Buckets of length(dict))

    /** class constructor */
    public ScrabbleRackManager() {
        tileRack = new ArrayList<String>();
//        for (int i = 0; i < 26; i++) {
//            dict.add(new ArrayList<String>());
//        }
        String[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ".split("");
        int[] distro = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2};
        for (int j = 0; j < alpha.length; j++)
            for (int i = 0; i < distro[j]; i++)
                tileRack.add(alpha[j]);
        Collections.shuffle(tileRack);
        int temp = tileRack.size();
        for (int i = 0; i < temp-7; i++) {
            tileRack.remove(randHelper(0, tileRack.size()-1));
        }
        tileLen = tileRack.size();
    }

//    private int alphaIndex(char a) {
//        return (int)a - 65;
//    }
//
//    private void addElem(String e) {
//        int fr = alphaIndex(e.charAt(0));
//        if (e.length() <= 7) {
//            while (dict.get(fr).size() < e.length()) {
//                dict.get(fr).add(new ArrayList<String>());
//            }
//            dict.get(fr).get(e.length() - 1).add(e);
//        }
//    }

//    private ArrayList<String> getList(char first, int length) {
//        return dict.get(alphaIndex(first)).get(length-1);
//    }

    private boolean isValid(String s) {
        ArrayList<String> temp =  new ArrayList<String>(tileRack);
        for (int i = 0; i < s.length(); i++) {
            comp++;
            if (!temp.remove(s.substring(i, i + 1)) && !temp.remove(" ")) {
                comp++;
                return false;
            }
        }
        return true;
    }

    /**
     * builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile
     * rack
     */

    public ArrayList<String> getPlaylist() {
        ArrayList<String> valid = new ArrayList<String>();
        try {
            Scanner file = new Scanner(new File("data/SCRABBLE_WORDS.txt"));
            String next;
            while (file.hasNextLine()) {
                next = file.nextLine().toUpperCase();
                if (next.length() <= tileRack.size()) {
                    if (isValid(next)) {
                        valid.add(next + ((next.length() == tileRack.size()) ? "*" : ""));
                    }
                }
            }
        } catch (Exception e) {}
        return valid;
    }

    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    /** displays the contents of the player's tile rack */
    public void printRack() {
        getPlaylist();
        System.out.println("Letters in the rack: " + tileRack);
        System.out.println("You can play the following words from the letters in your rack:");
    }

    /** print all of the playable words based on the letters in the tile rack */
    public void printMatches() {
        int count = 0;
        boolean pop = false;
        for (String s : getPlaylist()) {
            pop = true;
            System.out.printf("%-"+ (tileLen+3) + "s", s);
            count++;
            if (count >= 9) {
                System.out.println();
                count = 0;
            }
        }
        if (!pop) System.out.println("Sorry, NO words can be played from those tiles.");
        System.out.println("\n* denotes BINGO");
    }
    /** main method for the class; use only 3 command lines in main */
    public static void main(String[] args){
        long tick = System.currentTimeMillis();
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
        long tock = System.currentTimeMillis();
        System.out.println(tock-tick);
        System.out.println(app.comp);
    }
}
