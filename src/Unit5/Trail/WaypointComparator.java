package Unit5.Trail;

import java.util.Comparator;

public class WaypointComparator implements Comparator<Waypoint> {
    private boolean asc;
    private String sort;

    public WaypointComparator() {
        this.asc = true;
        this.sort = "NA";
    }

    public WaypointComparator(boolean a, String sort) {
        this.asc = a;
        this.sort = sort;
    }

    public int compare(Waypoint w1, Waypoint w2) {
        return -1;
    }
}
