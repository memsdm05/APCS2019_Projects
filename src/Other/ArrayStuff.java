package Other;
public class ArrayStuff {
    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    public static void main(String[] args) {
        String[] words = new String[100];
        for (int i = 0; i < 10; i++) {
            words[randHelper(0, words.length)] = "Boolean Cochran";
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null)
                System.out.println(i + ": " + words[i]);
        }

    }
}
