// Java program to print all valid words that
// are possible using character of array
package Other;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Trie {
    private ArrayList<Character> tileRack;

    public Trie() {
        tileRack = new ArrayList<Character>();
        char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int[] distro = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2};
        for (int j = 0; j < alpha.length; j++)
            for (int i = 0; i < distro[j]; i++)
                tileRack.add(alpha[j]);
        Collections.shuffle(tileRack);
        int tileLen = tileRack.size();
        for (int i = 0; i < tileLen-7; i++) {
            tileRack.remove(randHelper(0, tileRack.size()-1));
        }
    }
    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    // Alphabet size
    static final int SIZE = 26;

    // trie Node
    static class TrieNode
    {
        TrieNode[] Child = new TrieNode[SIZE];

        // isLeaf is true if the node represents
        // end of a word
        boolean leaf;

        // Constructor
        public TrieNode() {
            leaf = false;
            for (int i =0 ; i< SIZE ; i++)
                Child[i] = null;
        }
    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just
    // marks leaf node
    static void insert(TrieNode root, String Key)
    {
        int n = Key.length();
        TrieNode pChild = root;

        for (int i=0; i<n; i++)
        {
            int index = Key.charAt(i) - 'a';

            if (pChild.Child[index] == null)
                pChild.Child[index] = new TrieNode();

            pChild = pChild.Child[index];
        }

        // make last node as leaf node
        pChild.leaf = true;
    }

    // A recursive function to print all possible valid
    // words present in array
    static void searchWord(TrieNode root, boolean Hash[], String str)
    {
        // if we found word in trie / dictionary
        if (root.leaf == true)
            System.out.println(str);

        // traverse all child's of current root
        for (int K =0; K < SIZE; K++)
        {
            if (Hash[K] == true && root.Child[K] != null )
            {
                // add current character
                char c = (char) (K + 'a');

                // Recursively search reaming character
                // of word in trie
                searchWord(root.Child[K], Hash, str + c);
            }
        }
    }

    // Prints all words present in dictionary.
    static void PrintAllWords(ArrayList<Character> Arr, TrieNode root,
                              int n)
    {
        // create a 'has' array that will store all
        // present character in Arr[]
        boolean[] Hash = new boolean[SIZE];

        for (int i = 0 ; i < n; i++)
            Hash[Arr.get(i) - 'a'] = true;

        // tempary node
        TrieNode pChild = root ;

        // string to hold output words
        String str = "";

        // Traverse all matrix elements. There are only
        // 26 character possible in char array
        for (int i = 0 ; i < SIZE ; i++)
        {
            // we start searching for word in dictionary
            // if we found a character which is child
            // of Trie root
            if (Hash[i] == true && pChild.Child[i] != null )
            {
                str = str+(char)(i + 'a');
                searchWord(pChild.Child[i], Hash, str);
                str = "";
            }
        }
    }

    //Driver program to test above function
    public static void main(String args[])
    {
        // Let the given dictionary be following
        Trie app = new Trie();

        // Root Node of Trie
        TrieNode root = new TrieNode();

        // insert all words of dictionary into trie

        try {
            Scanner file = new Scanner(new File("data/SCRABBLE_WORDS.txt"));
            String next;
            while (file.hasNextLine()) {
                next = file.nextLine().toLowerCase();
                insert(root, next);
            }
        } catch (Exception e) {}


        ArrayList<Character> arr = app.tileRack;
        int N = arr.size();

        System.out.println(arr);
        PrintAllWords(arr, root, N);
    }
}
// This code is contributed by Sumit Ghosh