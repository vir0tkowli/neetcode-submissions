class Solution {
    Map<Integer, List<Integer>> adjList;
    Map<Integer, Integer> indegree;
    Deque<Integer> courseQueue;
    Map<Integer, Integer> earliestFinishTimes;
    public int minimumTime(int n, int[][] relations, int[] time) {
        adjList = new HashMap<>();
        indegree = new HashMap<>();
        courseQueue = new ArrayDeque<>();
        earliestFinishTimes = new HashMap<>();

        for(int course = 1; course <= n; course++) {
            adjList.put(course, new ArrayList<>());
            indegree.put(course, 0);
        }

        for(int[] relation: relations) {
            int src = relation[0];
            int dest = relation[1];
            adjList.get(src).add(dest);
            indegree.put(dest, indegree.get(dest) + 1);
        }
        // Track the earliest finish time of each course instead.
        for (int course = 1; course <= n; course++) {
            earliestFinishTimes.put(course, time[course - 1]);
        }

        for(int course = 1; course <= n; course++) {
            if(indegree.get(course) == 0) {
                courseQueue.offer(course);
            }
        }
        return topologicalSort(time);
    }

    private int topologicalSort(int[] time) {
        int totalTime = 0;
        while(!courseQueue.isEmpty()) {
            int curCourse = courseQueue.poll();
            totalTime = Math.max(totalTime, earliestFinishTimes.get(curCourse));
            
            for(Integer neighbor : adjList.get(curCourse)) {
                int possibleFinishTime = earliestFinishTimes.get(curCourse) + time[neighbor - 1];
                // Wait for the latest-finishing prerequisite.
                earliestFinishTimes.put(neighbor, Math.max(earliestFinishTimes.get(neighbor), possibleFinishTime));

                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) -1);
                if(indegree.get(neighbor) == 0) {
                    courseQueue.offer(neighbor);
                }
            }
            
        }
        return totalTime;
    }
}
