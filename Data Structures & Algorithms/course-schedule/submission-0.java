class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            prerequisiteMap.computeIfAbsent(prerequisite[0], key -> new ArrayList<>())
                .add(prerequisite[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, visited, prerequisiteMap)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int course, Set<Integer> visited, Map<Integer, List<Integer>> prerequisiteMap) {
        if(visited.contains(course)) {
            return false;
        }

        List<Integer> requiredCourses = prerequisiteMap.getOrDefault(course, Collections.emptyList());

        if (requiredCourses.isEmpty()) {
            return true;
        }

        visited.add(course);

        for (int prerequisite : prerequisiteMap.get(course)) {
            if (!dfs(prerequisite, visited, prerequisiteMap)) {
                return false;
            }
        }

        visited.remove(course);
        prerequisiteMap.put(course, new ArrayList<>());
        return true;
    }

}
