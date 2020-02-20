package Unit5.Trail;

public class Waypoint{
    private String name;
    private int height;
    private int x;
    private int y;

    public Waypoint(String name, int height, int x, int y) {
        this.name = name;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
