class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length < 1) {
            return true;
        }
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for(int[] course: prerequisites) {
            int src = course[0];
            int dest = course[1];
            if(!courseMap.containsKey(src)) {
                courseMap.put(src, new ArrayList<>());
            }
            if(!courseMap.containsKey(dest)) {
                courseMap.put(dest, new ArrayList<>());
            }
            courseMap.get(src).add(dest);
        }
        Set<Integer> visited = new HashSet<>();
        
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(prerequisites, courseMap, visited, course)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] prerequisites, Map<Integer, List<Integer>> courseMap, Set<Integer> visited, int course) {
        if(visited.contains(course)) {
            return false;
        }
        
        if(courseMap.get(course) == null || courseMap.get(course).size() == 0) {
            return true;
        }

        visited.add(course);
        for(Integer dependency : courseMap.get(course)) {
            // Stop only when a dependency has a cycle.
            if (!dfs(prerequisites, courseMap, visited, dependency)) {
                return false;
            }
        }
        visited.remove(course);
         // All dependencies are safe. Avoid checking them again.
        courseMap.get(course).clear();
        
        return true;
    }
}
