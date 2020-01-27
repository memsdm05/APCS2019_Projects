package Other.Chapters.chapter12;

public class Haiku extends Poem {
    private int[] meta = {5,7,5};

    public int numLines() {
        return meta.length;
    }

    public int getSyllables(int k) {
        return meta[k];
    }
}
