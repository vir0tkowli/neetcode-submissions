class Solution {
    private PriorityQueue<Integer> minHeap;
    public int findKthLargest(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        minHeap = new PriorityQueue<>();
        for(int num: nums) {
            add(num, k);
        }
        return minHeap.peek();
    }

    private void add(int val, int k) {
        minHeap.offer(val);
        if(minHeap.size() > k) {
            minHeap.poll();
        }
    }
}
