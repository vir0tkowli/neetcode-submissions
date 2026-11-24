class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
        if (cache.size() > capacity) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
    }
}
