class Solution {
    Map<Integer, List<Integer>> adjList;
    Map<Integer, Integer> indegree;
    public int minimumSemesters(int n, int[][] relations) {

        adjList = new HashMap<>();
        indegree = new HashMap<>();
        // courses start from 1 to N
        for(int course = 1; course <= n; course++) {
            adjList.put(course, new ArrayList<>());
            indegree.put(course, 0);
        }
        for(int[] relation : relations) {
            adjList.get(relation[0]).add(relation[1]);
            indegree.put(relation[1], indegree.get(relation[1]) + 1);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int course = 1; course <= n; course++) {
            if(indegree.get(course) == 0) {
                queue.offer(course);
            }
        }

        return bfs(queue, n);
    }

    private int bfs(Queue<Integer> queue, int n) {
        int semester = 0;
        int courseCount = 0;

        while (!queue.isEmpty()) {
            // Only these courses can be taken this semester.
            int levelSize = queue.size();
            semester++;

            for (int i = 0; i < levelSize; i++) {
                int curCourse = queue.poll();
                courseCount++;
            
                for (int dependency : adjList.get(curCourse)) {
                    indegree.put(dependency, indegree.get(dependency) - 1);
                    
                    if(indegree.get(dependency) == 0) {
                        queue.offer(dependency);
                    }
                }
            }
        }
        return courseCount == n ? semester : -1;
    }
}
