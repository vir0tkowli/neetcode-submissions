class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> adjList = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(entry -> entry[0]));

        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] flight: flights) {
            int s = flight[0]; int dest = flight[1]; int cost = flight[2];

            adjList.get(s).add(new Pair(dest, cost));
        }

        int[][] result = new int[n][k+2];
        for (int[] costs : result) {
            Arrays.fill(costs, Integer.MAX_VALUE);
        }
        result[src][0] = 0;

        heap.offer(new int[]{0, src, 0});

        int minCost = Integer.MAX_VALUE;

        while(!heap.isEmpty() && k >= 0) {
            int[] current = heap.poll();
            int currentCost = current[0];
            int currentSrc = current[1];
            int flightsUsed = current[2];
            if (currentSrc == dst) {
                return currentCost;
            }
            if (flightsUsed > k) {
                continue;
            }
            int nextFlights = flightsUsed + 1;
            for(Pair<Integer, Integer> neighbor : adjList.get(currentSrc)) {
                int newCost = neighbor.getValue() + currentCost;

                if (newCost < result[neighbor.getKey()][nextFlights]) {
                    result[neighbor.getKey()][nextFlights] = newCost;
                    heap.offer(new int[]{newCost, neighbor.getKey(), nextFlights});
                }
                
            }

        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
