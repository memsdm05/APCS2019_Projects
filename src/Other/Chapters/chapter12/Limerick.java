package Other.Chapters.chapter12;

public class Limerick extends Poem {
    private int[] meta = {9,9,6,6,9};

    public int numLines() {
        return meta.length;
    }

    public int getSyllables(int k) {
        return meta[k];
    }
}
