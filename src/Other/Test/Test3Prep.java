package Other.Test;


import java.util.Arrays;
import java.util.*;

public class Test3Prep {
    public String[] usedWords = {"music", "musical", "musically", "meditation", "pineapple"};

    /**
     * Returns true if sub is in str, false otherwise. Works
     * regardless of capitalization.
     */
    public boolean contains(String str, String sub)	{
        str = str.toLowerCase();
        sub = sub.toLowerCase();

        for (int i = 0; i < str.length()-sub.length(); i++)
            if (str.substring(i,i+sub.length()).equals(sub))
                return true;
        return false;
    }

    public int[] swapNums(int[] nums)	{
        int temp = nums[0];
        nums[0] = nums[nums.length-1];
        nums[nums.length-1] = temp;
        return nums;
    }

    /** Counts how many strings in wordArray are not found in usedWords
     *  @param wordArray an array of Strings
     *  @return an integer representing the number of Strings in wordArray
     *  not found in usedWords
     */
    public int countNotInWordBank(String[] wordArray)	{
        int count = 0;
        for (String word : usedWords) {
            boolean found = false;
            for (String test : wordArray) {
                if (word.equals(test)) {
                    found = true;
                    break;
                }
            }
            if(!found)
                count++;
        }
        return count;
    }

    /** Returns an array containing strings from wordArray not found in
     *  usedWords
     *  When writing notInVocab, you should call the countNotInWordBank
     *  method and have it work as expected, regardless of what you wrote to
     *  define that method.
//     *  @param wordArray, an array of String objects
     *  @return a String array of all the words in wordArray not found in
     *  usedWords
     */
    public String[] notInVocab(String[] wordArray)	{
        String[] notFounds = new String[countNotInWordBank(wordArray)];
        int count = 0;
        int index = 0;
        for (String word : usedWords) {
            boolean found = false;
            for (int i = 0; i < wordArray.length; i++) {
                index = i;
                if (word.equals(wordArray[i])) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                notFounds[count] = wordArray[index];
                count++;
            }

        }
//        return count;
        return notFounds;
    }




    public static void fiveByFive() {
        int n = 5;
        int[][] m = new int[n][n];
        for(int j = 0; j < n; j++)	{
            for(int k = j; k < n; k++)	{
                m[j][k] = k + 1;
                m[k][j] = k - 1;
            }
        }
        for (int[] ints : m) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Test3Prep app = new Test3Prep();
//        System.out.println(Integer.parseInt("987.65"));

        System.out.println(app.contains("Hello", "h"));
        int[] nums = {5, 7};
        System.out.println(Arrays.toString(app.swapNums(nums)));

        ArrayList<String> animals = new ArrayList<>();
        animals.add("fox");
        animals.add(0, "squirrel");
        animals.add("deer");
        String byeBye = animals.set(2, "groundhog");
        animals.add(1, "mouse");
        System.out.println(animals.get(2) + " and " + animals.get(3) + " are better than " +  byeBye);
        fiveByFive();
        String[] arr = {"music", "apple", "pineapple"};
        System.out.println(Arrays.toString(app.notInVocab(arr)));
        System.out.println(app.countNotInWordBank(arr));
    }
}
