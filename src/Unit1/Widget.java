package Unit1;

public class Widget implements Comparable<Widget>{
    private int id;
    private double cost;
    private String name;

    Widget(int id, double cost, String name) {
        this.id = id;
        this.cost = cost;
        this.name = name;
    }

    public int compareTo(Widget other) {
        Double d1 = this.cost;
        Double d2 = other.cost;
        return d1.compareTo(d2);
    }

    public static void main(String[] args) {
        Widget wig = new Widget(3, 1.34, "Beans");
    }

}
