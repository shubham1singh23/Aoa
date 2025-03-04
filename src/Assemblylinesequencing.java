public class Assemblylinesequencing {
    public static void main(String[] args) {
        int[] a1 = {7, 9, 3, 4, 8, 4}; // Processing times for stations on line 1
        int[] a2 = {8, 5, 6, 4, 5, 7}; // Processing times for stations on line 2
        int[] t1 = {2, 3, 1, 3, 4};    // Transfer times from line 1 to line 2
        int[] t2 = {2, 1, 2, 2, 1};    // Transfer times from line 2 to line 1
        int e1 = 2, e2 = 4, x1 = 3, x2 = 2; // Entry and exit times

        int n = a1.length; // Number of stations

        // Initial processing times including entry times
        int timeLine1 = e1 + a1[0];
        int timeLine2 = e2 + a2[0];

        // Process all stations
        for (int i = 1; i < n; i++) {
            int nextTimeLine1 = Math.min(timeLine1 + a1[i], timeLine2 + t2[i - 1] + a1[i]);
            int nextTimeLine2 = Math.min(timeLine2 + a2[i], timeLine1 + t1[i - 1] + a2[i]);
            timeLine1 = nextTimeLine1;
            timeLine2 = nextTimeLine2;
        }

        // Calculate minimum time including exit times
        int result = Math.min(timeLine1 + x1, timeLine2 + x2);
        System.out.println("The minimum time is " + result);
}
}