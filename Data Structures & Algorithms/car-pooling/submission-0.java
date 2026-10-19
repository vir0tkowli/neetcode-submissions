class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips.length == 1 && trips[0][0] <= capacity) {
            return true;
        } else if (trips.length == 1 && trips[0][0] > capacity) {
            return false;
        }
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<int[]> currentRiders = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int time = 0;
        int currentCapacity = 0;
        for(int[]trip: trips) {

            int curTripStart = trip[1], curTripEnd = trip[2];
            
            // Drop off passengers before picking up this trip.
            while(!currentRiders.isEmpty() && currentRiders.peek()[2] <= curTripStart) {
                currentCapacity -= currentRiders.peek()[0];
                currentRiders.poll();
            }
            currentCapacity += trip[0];
            if (currentCapacity > capacity) {
                return false;
            }
            currentRiders.offer(trip);

        }

        return true;

    }
}