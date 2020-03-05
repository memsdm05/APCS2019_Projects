package Unit5.Trail;

/**
 * Mergesort implementation for sorting waypoints
 * @author Ben Browner
 * @since 3/5/2020
 */

public class WaypointSort {
    private WaypointComparator comp;
    private Waypoint[] temp;

    /**
     * Constructor with WaypointComparator param
     * @param c a WaypointComparator
     */
    public WaypointSort(WaypointComparator c) {
        this.comp = c;
    }

    /**
     * Public entry point for use in TrailDatabase
     * @param a array of Waypoint objects
     */
    public void startSort(Waypoint[] a) {
        temp = new Waypoint[a.length];
        sort(a, 0, a.length-1);
    }

    private void sort(Waypoint[] a, int l, int h) {
        int mid = (l + h) / 2;
        if (l < h) {

            sort(a, l, mid);
            sort(a,mid+1, h);

            merge(a, l, mid, h);

            }
    }

    private void merge(Waypoint[] a, int l, int m, int h) {
        int i = l, j = m+1, k = l;
        while (i <= m && j <= h) {
            if (comp.compare(a[i], a[j]) < 0)
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= m)
            temp[k++] = a[i++];


        while (j <= h)
            temp[k++] = a[j++];

        for (int n = l; n <= h; n++)
            a[n] = temp[n];
    }
}
