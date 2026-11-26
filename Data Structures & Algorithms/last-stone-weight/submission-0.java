class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while(maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            maxHeap.offer(first-second);
        }

        if(maxHeap.size() > 0) {
            return maxHeap.poll();
        } else {
            return 0;
        }
    }
}
