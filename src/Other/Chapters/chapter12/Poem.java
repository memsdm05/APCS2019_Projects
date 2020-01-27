package Other.Chapters.chapter12;

public abstract class Poem {
    public abstract int numLines();
    public abstract int getSyllables(int k);

    public void printRhythm() {
        for (int i = 0; i < numLines(); i++) {
            for (int j = 0; j < getSyllables(i)-1; j++) {
                System.out.print("ta-");
            }
            System.out.println("ta");
        }
    }
}
