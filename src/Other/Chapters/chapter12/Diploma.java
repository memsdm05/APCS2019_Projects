package Other.Chapters.chapter12;

public class Diploma {
    private String name;
    private String study;

    public Diploma(String name, String study) {
        this.name = name;
        this.study = study;
    }

    public String toString() {
        return "This certifies that " + this.name + "\nhas completed a MOOC in " + this.study;
    }
}
