class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (maxHeap.size() < 1) {
            maxHeap.offer(num);
            return;
        }
        if(maxHeap.peek() > num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if(Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if(minHeap.size() > maxHeap.size()) {
                int current = minHeap.poll();
                maxHeap.offer(current);
            } else {
                int current = maxHeap.poll();
                minHeap.offer(current);
            }
        }
    }
    
    public double findMedian() {
        // if((minHeap.size() + maxHeap.size())%2 == 1) {
        //     int left = maxHeap.size() > 0 ? maxHeap.peek() : 0;
        //     int right = minHeap.size() > 0 ? minHeap.peek() : 0;

        //     return ((long) left + right)/2.0;
        // } else {
        //     return maxHeap.peek();
        // }
        if (maxHeap.size() == minHeap.size()) {
            return ((long) maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
