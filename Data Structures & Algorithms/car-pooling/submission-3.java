class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> tripMap = new TreeMap<>();
        for(int[]trip: trips) {
            int start = trip[1], end = trip[2];
            tripMap.put(start, tripMap.getOrDefault(start, 0) + trip[0]);
            tripMap.put(end, tripMap.getOrDefault(end, 0) - trip[0]);
        }

        int currentCapacity = 0;
        for(int value : tripMap.values()) {
            currentCapacity += value;
            if (currentCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}