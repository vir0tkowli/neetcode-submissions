class MovingAverage {
    int sum;
    int numValues;
    int size;
    Deque<Integer> queue;
    public MovingAverage(int size) {
        sum = 0;
        numValues = 0;
        this.size = size;
        queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if(queue.size() < size) {
            numValues++;
        } else {
            int first = queue.pollFirst();
            sum -= first;
        }
        sum += val;
        queue.offer(val);
        return (double) sum/numValues;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
