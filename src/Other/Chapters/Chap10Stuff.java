package Other.Chapters;

public class Chap10Stuff {
    private int aNumber;
    private String aString;
    private boolean isItTrue;

    public Chap10Stuff(int aNumber, String aString, boolean isItTrue) {
        this.aNumber = aNumber;
        this.aString = aString;
        this.isItTrue = isItTrue;
    }

    public Chap10Stuff(Chap10Stuff other) {
        this.aNumber = other.aNumber;
        this.aString = other.aString;
        this.isItTrue = other.isItTrue;
    }

    public Chap10Stuff() {
        this.aNumber = 0;
        this.aString = "";
        this.isItTrue = false;
    }

    public String toString() {
        return aNumber + " " + aString + " " + isItTrue;
    }

    public void setaString(String other) {
        this.aString = other;
    }

    
    public Chap10Stuff(double a) {}
    public Chap10Stuff(double a, double b) {}


    public static void main(String[] args) {
        Chap10Stuff app1 = new Chap10Stuff(1, 0);
        Chap10Stuff app2 = new Chap10Stuff(12, "hotdog", true);
        System.out.println(app2);
    }
}
