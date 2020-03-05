package Unit5.Trail;

import java.util.Comparator;

/**
 * Comparator for Waypoint objects
 * @author Ben Browner
 * @since 3/5/2020
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private boolean asc;
    private int sort;

    /**
     * Default constructor that was useful during development and now not much
     */
    public WaypointComparator() {
        this.asc = true;
        this.sort = 0;
    }

    /**
     * Constructor that gets the sorting order and term to search
     * @param a sort in descending or ascending order
     * @param sort a int index that defines which key is being sorted
     */
    public WaypointComparator(boolean a, int sort) {
        this.asc = a;
        this.sort = sort;
    }

    /**
     * Compares two Waypoints depending on the sort keyphrase
     * @param w1 the first Waypoint object
     * @param w2 the second Waypoint object
     * @return the comparison
     */
    public int compare(Waypoint w1, Waypoint w2) {
        int diff = 0;
        switch (sort) {
            case(0):
                diff = w1.getName().compareTo(w2.getName());
                break;
            case(1):
                diff = Double.compare(w1.getDistToS(), w2.getDistToS());
                break;
            case(2):
                diff = Double.compare(w1.getDistToK(), w2.getDistToK());
                break;
            case(3):
                diff = Integer.compare(w1.getElevation(), w2.getElevation());
                break;
        }
        return (asc)? diff : -diff;
    }
}
