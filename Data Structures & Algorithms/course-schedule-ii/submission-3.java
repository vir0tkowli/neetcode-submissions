class Solution {
    Map<Integer, List<Integer>> prerequisiteMap;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // adjacency list
        prerequisiteMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int course = 0; course < numCourses; course++) {
            prerequisiteMap.put(course, new ArrayList<>());
        }

        for(int[] course: prerequisites) {
            int src = course[0];
            int dest = course[1];
            prerequisiteMap.get(src).add(dest);
        }

        for(int course = 0; course < numCourses; course++) {
            if(!dfs(prerequisites, visited, course, result)) {
                return new int[]{};
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int[][] prerequisites, Set<Integer> visited, int course, List<Integer> result) {
        if (visited.contains(course)) {
            return false;
        }

        if (!prerequisiteMap.containsKey(course)) {
            return true; // Already completed and added to result
        }

        visited.add(course);
        for(Integer neighbors: prerequisiteMap.get(course)) {
            if(!dfs(prerequisites, visited, neighbors, result)) {
                return false;
            }
        }

        visited.remove(course);
         // All dependencies are safe. Avoid checking them again.
        prerequisiteMap.remove(course);
        result.add(course);
        return true;
    }
}
