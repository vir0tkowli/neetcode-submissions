class KthLargest {
    PriorityQueue<Integer> minHeap;
    private final int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if(minHeap.peek() < val) {
            minHeap.offer(val);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
