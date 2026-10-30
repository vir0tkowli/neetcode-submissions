class HitCounter {
    private Queue<Integer> hits; 
    public HitCounter() {
        hits = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int firstTimestamp = hits.peek();
        while(timestamp - firstTimestamp >= 300 && !hits.isEmpty()) {
            hits.remove();
            if(hits.isEmpty()) {
                return 0;
            }
            firstTimestamp = hits.peek();
        }
        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
