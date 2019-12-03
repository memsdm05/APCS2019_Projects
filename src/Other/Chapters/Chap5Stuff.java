package Other.Chapters;

public class Chap5Stuff {
    char tab = '\t', newline = '\n';
    private final int year = 365, leapYear = year + 1;


    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    public static void main(String[] args) {
        System.out.println(randHelper(0, 2));
        System.out.println(1.0/2 * 10);

    }
}
