package Unit5.Trail;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class SortTest {
    private static double randHelper(int min, int max) {
        return min + Math.random()*(max+1-min);
    }

    private static boolean valid(Waypoint[] a, WaypointComparator wc) {
        for (int i = 0; i < a.length-1; i++) {
            if (wc.compare(a[i], a[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int SIZE = 1000000;
        int PASS = 5;
        int best_thread = 0;
        int worst_thread = 0;

        for (int a = 1; a <= PASS; a++) {
            System.out.println("\nPASS "+a);
            Waypoint[] arr1 = new Waypoint[SIZE];
            Waypoint[] arr2 = new Waypoint[SIZE];
            for (int i = 0; i < arr1.length; i++) {
                byte[] array = new byte[7]; // length is bounded by 7
                new Random().nextBytes(array);
                String str = new String(array, Charset.forName("UTF-8"));
                arr1[i] = new Waypoint("Test", str, "NC", randHelper(-100, 100), randHelper(-100, 100),
                        randHelper(0, 100), randHelper(0, 100), (int)randHelper(130, 1000));

            }
            for (int k = 0; k < 4; k++) {
                long best_num = 99999;
                long worst_num = 0;
                System.out.println("-------------------"+new TrailDatabase().getSearchTerms()[k]);
                for (int j = 0; j <= Runtime.getRuntime().availableProcessors()*2; j++) {
                    for (int i = 0; i < arr1.length; i++) {
                        arr2[i] = arr1[i];
                    }
                    WaypointComparator wc = new WaypointComparator(true, k);
                    WaypointSort st = new WaypointSort(wc);
                    long start = System.currentTimeMillis();
                    st.startSort(arr2, j);
                    long end = System.currentTimeMillis();
                    System.out.print(j + " threads -> ");
                    System.out.print((end - start) + " ms");
                    System.out.println(" - " + (valid(arr2, wc)? "PASS" : "FAIL"));

                    if (end - start < best_num) {
                        best_num = end - start;
                        best_thread = j;
                    }
                    if (end - start > worst_num) {
                        worst_num = end - start;
                        worst_thread = j;
                    }
                }
                System.out.println("BEST: " + best_thread + " threads -> " + best_num + " ms");
                System.out.println("WORST: " + worst_thread + " threads -> " + worst_num + " ms");
            }
        }
    }
}
