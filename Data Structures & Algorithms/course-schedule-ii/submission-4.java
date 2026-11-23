class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }

        for(int[] edges : prerequisites) {
            int src = edges[1]; int dest = edges[0];
            adjMap.get(src).add(dest);
            indegree.put(dest, indegree.getOrDefault(dest, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> i : indegree.entrySet()) {
            if(i.getValue() == 0) {
                queue.offer(i.getKey());
            }
        }

        int idx = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(visited.contains(current)) {
                return new int[0];
            }
            visited.add(current);
            result[idx++] = current;
            for(int neighbor : adjMap.get(current)) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) - 1);

                if(indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return idx == numCourses ? result : new int[0];    
    }
}
