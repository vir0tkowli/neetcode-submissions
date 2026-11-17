class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 1) {
            return new int[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();

        int start = 0; 
 
        while(start < nums.length) {
            maxHeap.offer(nums[start]);
            if(maxHeap.size() > k) {
                maxHeap.remove(nums[start -k]);
                //result.add(maxHeap.peek());
            } 
            // Record every complete window, including the first one.
            if (start >= k - 1) {
                result.add(maxHeap.peek());
            }
            
            start++;
        }

        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
