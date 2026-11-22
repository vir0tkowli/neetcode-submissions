class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> adjList = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));

        Map<Integer, Integer> result = new HashMap<>();

        for(int i =1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
            if (i == k) {
                result.put(i, 0);
            } else {
                result.put(i, Integer.MAX_VALUE);
            }
        }
        for(int[] time: times) {
            int src = time[0]; int dest = time[1]; int weight = time[2];
            adjList.get(src).add(new Pair<>(dest, weight));
        }

        queue.offer(new Pair<>(0, k));

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.poll();

            for(Pair<Integer, Integer> neighbors : adjList.get(current.getValue())) {
                int newWeight = current.getKey() + neighbors.getValue();
                if(result.get(neighbors.getKey()) > newWeight) {
                    queue.offer(new Pair<>(newWeight, neighbors.getKey()));
                    result.put(neighbors.getKey(), newWeight);
                }
            } 
        }

        int delay = 0;
        for (Integer value : result.values()) {
            if(value == Integer.MAX_VALUE) { 
                return -1;
            }
            delay = Math.max(delay, value);
        }

        return delay;
    }
}
