package Other;
import java.util.*;

public class ListStuff {
    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(100);
        System.out.println(nums.size());
        for (int i = 0; i < 20; i++) {
            nums.add(randHelper(0,100));
        }
        System.out.println(nums);
        System.out.println(nums.size());
    }
}
