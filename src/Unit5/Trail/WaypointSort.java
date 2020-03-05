package Unit5.Trail;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Mergesort implementation for sorting waypoints
 * @author Ben Browner
 * @since 3/5/2020
 */

public class WaypointSort extends Thread {
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
    public void startSort(Waypoint[] a, int threads) {
        temp = new Waypoint[a.length];
        parallelSort(a, 0, a.length-1, threads);
    }

    private void sort(Waypoint[] a, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;

            sort(a, l, mid);
            sort(a,mid+1, h);

            merge(a, l, mid, h);

        }
    }

    private void parallelSort(Waypoint[] a, int l, int h, int threads) {
        if (l < h) {
            if (threads < 1) {
                sort(a, l, h);
            }
            else {
                int mid = (l + h) / 2;
                Thread first = new Thread() {
                    public void run() {
                        parallelSort(a, l, mid, threads-1);
                    }
                };
                Thread second = new Thread() {
                    public void run() {
                        parallelSort(a, mid+1, h, threads-1);
                    }
                };

                first.start();
                second.start();

                try {
                    first.join();
                    second.join();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }

                merge(a, l, mid, h);
            }
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
