package Other.Chapters;

import java.util.ArrayList;
import java.util.Arrays;

public class Chap11Stuff {
    public static ArrayList<String> reverse(ArrayList<String> s) {
        ArrayList<String> copy = new ArrayList<>();
        for (String l : s) {
            copy.add(0, l);
        }
        return copy;
    }

    public static void smallest(ArrayList<Integer> stuff) {
        Integer small = stuff.get(0);
        for (Integer i : stuff) {
            if (i.compareTo(small) < 0) {
                small = i;
            }
        }
        stuff.remove(small);
    }

    public static void removeConsecutiveDuplicates(ArrayList<String> lst) {
        for (int i = lst.size()-1; i > 0; i--) {
            if (lst.get(i-1) == lst.get(i))
                lst.remove(i);
        }
    }

    public static void removeBoth(ArrayList<Object> list1, ArrayList<Object> list2) {
        for (Object i : list2)
            for (Object j : list1)
                if (i == j)
                    list1.remove(i);
    }

    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    public static void main(String[] args) {
        Chap11Stuff app = new Chap11Stuff();
        Integer[] nums = {1, 3, 5, 0, 5, 2, 4, 5, 23, 35, 23, 68};
        ArrayList<Integer> funnyList = new ArrayList<>(Arrays.asList(nums));
        smallest(funnyList);
        System.out.println(funnyList);
        // ["A", "A", "A", "B", "C", "C", "A", "A"]
        String[] asdf = {"A", "A", "A", "B", "C", "C", "A", "A"};
        ArrayList<String> s1 = new ArrayList<>(Arrays.asList(asdf));
        removeConsecutiveDuplicates(s1);
        System.out.println(s1);
    }
}
