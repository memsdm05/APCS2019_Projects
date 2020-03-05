package Unit5.Trail;

/**
 * Waypoint object
 * @author Ben Browner
 * @since 2/5/20
 */
public class Waypoint{
    private String type, name, state;
    private double lat, lon, distToS, distToK;
    private int elevation;

    /**
     * Waypoint constructor
     * @param type the genre of feature
     * @param name the name of the feature
     * @param state which US state the feature is located
     * @param lat the latitude of the feature
     * @param lon the longitude of the feature
     * @param distToS the feature's distance to Springer
     * @param distToK the feature's distance to Katahdin
     * @param elevation the feature's elevation
     */
    public Waypoint(String type, String name, String state, double lat, double lon, double distToS, double distToK, int elevation) {
        this.name = name;
        this.type = type;
        this.state = state;
        this.lat = lat;
        this.lon = lon;
        this.distToK = distToK;
        this.distToS = distToS;
        this.elevation = elevation;
    }

    /**
     * get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get distance to Katahdin
     * @return distToK
     */
    public double getDistToK() {
        return distToK;
    }

    /**
     * get distance to Springer
     * @return distToS
     */
    public double getDistToS() {
        return distToS;
    }

    /**
     * get elevation
     * @return elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * to String method
     * @return a melody of waypoint elements
     */
    public String toString() {
        return type+"\t"+name+"\t"+state+"\t"+lat+"\t"+lon+"\t"+distToK+"\t"+distToS+"\t"+elevation;
    }
}
