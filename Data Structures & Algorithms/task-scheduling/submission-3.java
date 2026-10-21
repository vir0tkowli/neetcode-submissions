class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frqMap = new HashMap<>();
        for (char task : tasks) {
            frqMap.put(task, frqMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(frqMap.values());

        // Each entry: {remaining frequency, next allowed time}
        Queue<int[]> waitingQueue = new LinkedList<>();

        int resTime = 0;

        while (!maxHeap.isEmpty() || !waitingQueue.isEmpty()) {
            resTime++;

            // If no task is available, jump to the next allowed time.
            if (maxHeap.isEmpty()) {
                resTime = Math.max(resTime, waitingQueue.peek()[1]);
            } else {
                // Execute one task.
                int frequency = maxHeap.poll() - 1;

                if (frequency > 0) {
                    waitingQueue.offer(new int[]{frequency, resTime + n });
                }
            }

            // Move ready tasks into the heap.
            while (!waitingQueue.isEmpty() && waitingQueue.peek()[1] <= resTime) {
                maxHeap.offer(waitingQueue.poll()[0]);
            }

        }

        return resTime;
    }
}