Hi True or False,

Mostly everything is the same. Waypoint.java, WaypointComparator.java, and TrailDatabase.java are the three required java
files, yes, but two are included for spiciness. WaypointSort.java is a multi-threaded implementation of Mergesort. It's
called in sortDB, so please include this in the same package as TrailDatabase. Unfortunately, multi-threading does not
work well with small datasets (446-ish elements from apptrailDB.txt) but I still wanted to show off the algorithm.

Included is SortTest.java. When run in the same package as WaypointComparator and WaypointSort it prints out nice info
about the algorithm. The test goes through 5 passes (default) of every sort option for 1 to amount of processes * 2 threads
and prints their elapsed times. You can decrease the pass size by editing the integer PASS. There is an astonishing decrease
of time by every thread. However whats more interesting is more threads doesn't always mean better performance.

P.S. your implementation of Mergesort was by far the best compared to the ones on Stack Overflow