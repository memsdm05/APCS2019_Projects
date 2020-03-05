package Unit5.Trail;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sorts Waypoints and presents them
 * @author Ben Browner
 * @since 3/5/2020
 */

public class TrailDatabase {
    private ArrayList<Waypoint> myPoints;

    /**
     * Initializes myPoints
     */
    public TrailDatabase() {
        myPoints = new ArrayList<Waypoint>();
    }

    /**
     * gets search terms
     * @return search terms
     */
    public String[] getSearchTerms() {
        return new String[] {"NA", "DS", "DK", "EL"};
    }

    /**
     * Populates myPoints with data entries from apptrailDB.txt
     */
    public void populateDatabase() {
        Scanner in;
        try {
            in = new Scanner(new File("data/apptrailDB.txt"));
            while (in.hasNextLine()) {
                String[] t = in.nextLine().split("\t");
                myPoints.add(new Waypoint(t[0], t[1], t[2],
                        Double.parseDouble(t[3]), Double.parseDouble(t[4]),
                        Double.parseDouble(t[5]), Double.parseDouble(t[6]),
                        Integer.parseInt(t[7])));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Prints myPoints using Waypoint's toString method.
     */
    public void printDatabase() {
        System.out.println("Feature, Name, State, Latitude, Longitude, Dist To Katahdin, Dist To Springer, Elevation");
        for (Waypoint myPoint : myPoints) {
            System.out.println(myPoint);
        }
    }

    /**
     * Sets up an array to send over to WaypointSort to be sorted
     * @param wc Waypoint Comparator that WaypointSort Uses
     */
    public void sortDB(WaypointComparator wc) {
        WaypointSort sort = new WaypointSort(wc);
        Waypoint[] wp = new Waypoint[myPoints.size()];
        for (int i = 0; i < wp.length; i++) {
            wp[i] = myPoints.get(i);
        }
        sort.startSort(wp);
        myPoints.clear();
        for (Waypoint waypoint : wp) {
            myPoints.add(waypoint);
        }
    }

    /**
     * Main entry point and graphical front end
     * @param args the sys args
     */
    public static void main(String[] args) {
        TrailDatabase app = new TrailDatabase();
        app.populateDatabase();
        Scanner in = new Scanner(System.in);
        boolean run = true;
        do {
            System.out.println("*** Welcome to the Appalachian Trail Database ***");
            System.out.println("+ Menu of search terms to use for sorting waypoints +");
            System.out.println("\tNA: by name");
            System.out.println("\tDS: by distance to Springer");
            System.out.println("\tDK: by distance to Katahdin");
            System.out.println("\tEL: by elevation");
            System.out.print("Enter your preferred sort by term or 'Q' to quit: ");
            String input = in.nextLine();
            if (input.equalsIgnoreCase("Q"))
                run = false;
            String[] options = app.getSearchTerms();
            int opt = -1;
            if (run) {
                for (int i = 0; i < options.length; i++)
                    if (input.equals(options[i]))
                        opt = i;
                if (opt == -1) {
                    System.out.println("Invalid search term");
                    continue;
                }
                System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
                input = in.nextLine();
                WaypointComparator wc;
                if (input.equalsIgnoreCase("A"))
                    wc = new WaypointComparator(true, opt);
                else if (input.equalsIgnoreCase("D"))
                    wc = new WaypointComparator(false, opt);
                else {
                    System.out.println("Invalid sorting order");
                    continue;
                }

                app.sortDB(wc);
                app.printDatabase();
            }

        }while (run);
    }
}
