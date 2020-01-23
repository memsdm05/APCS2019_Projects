package Other.polymorph;

public abstract class Animal {
    // abstract classes can contain private data
    // interfaces can only contain a list of methods -- all public
    private int numLegs;
    private boolean isFemale;
    private String color;

    public Animal(int numLegs, boolean isFemale, String color) {
        this.numLegs = numLegs;
        this.isFemale = isFemale;
        this.color = color;
    }

    public Animal(Animal other) {
        this.numLegs = other.numLegs;
        this.isFemale = other.isFemale;
        this.color = other.color;
    }

    public int getNumLegs() {return numLegs;}
    public boolean isFemale() {return isFemale;}
    public String getColor() {return color;}

    public abstract String speak();
    public abstract String product();

}
