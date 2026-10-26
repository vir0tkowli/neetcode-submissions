class MedianFinder {
    List<Integer> stream;

    public MedianFinder() {
        stream = new ArrayList<>();
        
    }
    
    public void addNum(int num) {
        if(stream.size() < 0) {
            stream.add(num);
            return;
        }
        stream.add(num);
        Collections.sort(stream);
    }
    
    public double findMedian() {
        if(stream.size() == 1) {
            return stream.get(0);
        }

        int right = stream.size() -1;
        int mid = (right)/2;
        if (right % 2 == 1) {
            return ((long) stream.get(mid) + stream.get(mid + 1)) / 2.0;
        } else {
            return stream.get(mid);
        }
    }
}
