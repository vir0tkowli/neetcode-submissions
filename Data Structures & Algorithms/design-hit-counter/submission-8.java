class HitCounter {
    private Deque<long[]> queue;
    public HitCounter() {
        queue = new LinkedList<>();

    }
    
    // aggregate hits by second, so memory depends on the 300-second window rather than the number of hits.
    public void hit(int timestamp) {
        if(!queue.isEmpty() && queue.peekLast()[0] == timestamp) {
            queue.peekLast()[1]++;
        } else {
            queue.offer(new long[]{timestamp, 1});
        }

        // Optional to clean up the queue as part of hit()
        long[] first = queue.peekFirst();
        while(!queue.isEmpty() && timestamp - first[0] >= 300) {
            queue.poll();
            if(queue.isEmpty()) {
                break;
            }
            first = queue.peekFirst();
        }
    }
    
    public int getHits(int timestamp) {
        long[] first = queue.peekFirst();
        while(!queue.isEmpty() && timestamp - first[0] >= 300) {
            queue.poll();
            if(queue.isEmpty()) {
                break;
            }
            first = queue.peekFirst();
        }

        int sum = 0;
        for (long[] group : queue) {
            sum += group[1];
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
