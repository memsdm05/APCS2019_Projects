package Other.polymorph;

public class Cow extends Animal {
    public boolean spotted;

    public Cow(int l, boolean f, String c, boolean s) {
        // if momma ain't happy, ain't nobody happy
        super(l, f, c);
        this.spotted = s;
    }

    public boolean getIsSpotted() { return spotted; }

    public String product() {return "milk?";}
    public String speak() {return "moo";}
}
