class Solution {
    public int[] getOrder(int[][] tasks) {
        // store {tasks[i][0], tasks[i][1], i} in one int[]:
         PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.<int[]>comparingInt(a -> a[1])
            .thenComparingInt(a -> a[2]));
        PriorityQueue<int[]> waitingQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int i = 0;    
        for (i = 0; i < tasks.length; i++) {
            waitingQueue.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }
        

        int[] res = new int[tasks.length];
        int time = 0;
        i = 0;
        while(!minHeap.isEmpty() || !waitingQueue.isEmpty()) {
            if (minHeap.isEmpty()) {
                // jump to the enqueue time
                time = Math.max(time, waitingQueue.peek()[0]);
            }
            while (!waitingQueue.isEmpty() && waitingQueue.peek()[0] <= time) {
                minHeap.offer(waitingQueue.poll());
            }
            int[] task = minHeap.poll();
            res[i++] = task[2];
            time += task[1];
        }

        return res;
    }
}