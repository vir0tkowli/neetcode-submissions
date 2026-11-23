class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] res = new int[tasks.length];
        PriorityQueue<int[]> pendingTasks = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> processingTasks = new PriorityQueue<>((a,b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);

        for (int i = 0; i < tasks.length; i++) {
            pendingTasks.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }

        int time = 0;
        int idx = 0;
        while(!pendingTasks.isEmpty() || !processingTasks.isEmpty()) {
            if (processingTasks.isEmpty()) {
                // The outer loop guarantees that a pending task exists here.
                time = Math.max(time, pendingTasks.peek()[0]);
            }
            while(!pendingTasks.isEmpty() && time >= pendingTasks.peek()[0]) {
                int[] task = pendingTasks.poll();
                processingTasks.offer(task);
                
            }

            if(!processingTasks.isEmpty()) {
                int[] completedTask = processingTasks.poll();
                time += completedTask[1];
                res[idx++] = completedTask[2];
            }
        }
        return res;
    }
}