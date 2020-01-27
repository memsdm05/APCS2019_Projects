package Other.Chapters.chapter12;

public class DiplomaWithHonors extends Diploma{
    private String name;
    private String study;

    public DiplomaWithHonors(String name, String study) {
        super(name, study);
    }

    public String toString() {
        return super.toString() + "\n*** with honors ***";
    }
}
