package Unit3.subword;

import Unit3.subword.SubWord; // import SubWord;
import java.io.File;
import java.util.*;

public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;
    private HashMap<String, Integer> root1Lead;
    private HashMap<String, Integer> root2Lead;
    private String alphabet;

    public SubWordFinder() {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        root1Lead = new HashMap<String, Integer>();
        root2Lead = new HashMap<String, Integer>();
        dictionary = new ArrayList<ArrayList<String>>(26);
        for (int i = 0; i < 26; i++)
            dictionary.add(new ArrayList<String>());
    }

    /**
     * Populates the dictionary from the text file contents
     * The dictionary object should contain 26 buckets, each
     * bucket filled with an ArrayList<String>
     * The String objects in the buckets are sorted A-Z because
     * of the nature of the text file words.txt
     */
    public void populateDictionary() {
        String next;
        try {
            // Works with Scrabble Words
            Scanner file = new Scanner(new File("data/words_all_os.txt"));
            while (file.hasNextLine()) {
                next = file.nextLine().toLowerCase();
                dictionary.get(alphabet.indexOf(next.charAt(0))).add(next);
            }
            file.close();

        } catch (Exception e) {System.err.println("Could not load file: " + e);}

        for (ArrayList<String> strings : dictionary) {
            Collections.sort(strings);
        }

    }



    /**
     * Retrieve all SubWord objects from the dictionary.
     * A SubWord is defined as a word that can be split into two
     * words that are also found in the dictionary.  The words
     * MUST be split evenly, e.g. no unused characters.
     * For example, "baseball" is a SubWord because it contains
     * "base" and "ball" (no unused characters)
     * To do this, you must look through every word in the dictionary
     * to see if it is a SubWord object
     * @return An ArrayList containing the SubWord objects
     * pulled from the file words.txt ;
     */
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subwords = new ArrayList<SubWord>();
        String root1;
        String root2;
        for (ArrayList<String> bucket : dictionary) {
            for (String word : bucket) {
                for (int i = 2; i < word.length() - 1; i++) {
                    root1 = word.substring(0, i);
                    root2 = word.substring(i);
                    if (inDictionary(root1) && inDictionary(root2)) {
                        subwords.add(new SubWord(word, root1, root2));

                        if (root1Lead.containsKey(root1))
                            root1Lead.replace(root1, root1Lead.get(root1)+1);
                        else
                            root1Lead.put(root1, 1);

                        if (root2Lead.containsKey(root2))
                            root2Lead.replace(root2, root2Lead.get(root2)+1);
                        else
                            root2Lead.put(root2, 1);


                    }
                }
            }
        }
        return subwords;
    }

    /**
     * Look through the entire dictionary object to see if
     * word exists in dictionary
     * @param word The item to be searched for in dictionary
     * @return true if word is in dictionary, false otherwise
     * NOTE: EFFICIENCY O(log N) vs O(N) IS A BIG DEAL HERE!!!
     * You MAY NOT use Collections.binarySearch() here; you must use
     * YOUR OWN DEFINITION of a binary search in order to receive
     * the credit as specified on the grading rubric.
     */
    public boolean inDictionary(String word) {
        ArrayList<String> current = dictionary.get(alphabet.indexOf(word.charAt(0)));
        /*
        BINARY SEARCH
        1. Set L to 0 and R to len-1
        2. If L > R, terminate as no
        3. Set m (pos of middle element) to floor((L+R)/2)
        4. If Am < t, set L to m + 1 and go to step 2
        5. If Am > t, set R to m -l and go to step 2
        6. Now Am = T, search is done; return m
         */
        int middle = 0, left = 0, right = current.size()-1;
        while (left <= right) {
            middle = (int)((left+right)/2);
            if (current.get(middle).compareTo(word) < 0)
                left = middle + 1;
            else if (current.get(middle).compareTo(word) > 0)
                right = middle - 1;
            else
                return true;
        }
        return false;

    }

    private void run() {
        populateDictionary();
        for (SubWord s : getSubWords()) {
            System.out.println(s.toString());
        }

        int firstLargest = 0;
        String firstTop = "No largest waaaa?";
        for (Map.Entry<String, Integer> entry : root1Lead.entrySet()) {
            if (entry.getValue() > firstLargest) {
                firstLargest = entry.getValue();
                firstTop = entry.getKey();
            }
        }

        int secondLargest = 0;
        String secondTop = "No largest waaaa?";
        for (Map.Entry<String, Integer> entry : root2Lead.entrySet()) {
            if (entry.getValue() > secondLargest) {
                secondLargest = entry.getValue();
                secondTop = entry.getKey();
            }
        }

        System.out.println("Most frequent first root: " + firstTop);
        System.out.println("Most frequent second root: " + secondTop);
    }

    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        app.run();
    }
}
