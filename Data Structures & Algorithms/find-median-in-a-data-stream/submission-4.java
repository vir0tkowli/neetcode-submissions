class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        if(maxHeap.peek() > num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if(Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            if(maxHeap.size() > minHeap.size()) {
                int temp = maxHeap.poll();
                minHeap.offer(temp);
            } else {
                int temp = minHeap.poll();
                maxHeap.offer(temp);
            }
        }
        //System.out.printf("maxHeap: %s\n", maxHeap);
        //System.out.printf("minHeap: %s\n", minHeap);
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek())/2;
        } else if(minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    }
}
