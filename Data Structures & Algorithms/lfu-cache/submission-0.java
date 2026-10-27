class LFUCache {

    HashMap<Integer, LFUCacheEntity> cache;
    TreeMap<Integer, LinkedHashSet<Integer>> freqCount;
    int capacity;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();  
        this.freqCount = new TreeMap<>();

        this.capacity = capacity;
    }
    
    public int get(int key) {
        LFUCacheEntity entity = cache.get(key);
        if(entity == null) {
            return -1;
        }

        increaseFrequency(entity);
        return entity.getValue();
    }

    private void increaseFrequency(LFUCacheEntity entity) {
        int key = entity.getKey();
        cache.remove(key);
       
        int oldCount = entity.getCount();
        // Remove from the old frequency group.
        LinkedHashSet<Integer> oldGroup = freqCount.get(oldCount);
        oldGroup.remove(key);
        if (oldGroup.isEmpty()) {
            freqCount.remove(oldCount);
        }

        entity.updateCount();
        int newCount = entity.getCount();
        cache.put(key, entity);
        freqCount.computeIfAbsent(newCount, frequency -> new LinkedHashSet<>()).add(key);

    }
    
    public void put(int key, int value) {
        LFUCacheEntity entity = cache.get(key);
        // Updating an existing key also counts as an access.
        if (entity != null) {
            entity.value = value;
            increaseFrequency(entity);
            return;
        }

        if (cache.size() == capacity) {
            // Find the lowest-frequency group.
            Map.Entry<Integer, LinkedHashSet<Integer>> lowest = freqCount.firstEntry();
            LinkedHashSet<Integer> keys = lowest.getValue();
            // The first key is the least recently used in this group.
            int keyToRemove = keys.getFirst();

            keys.remove(keyToRemove);
            cache.remove(keyToRemove);
            if (keys.isEmpty()) {
                freqCount.remove(lowest.getKey());
            }
        }
        entity = new LFUCacheEntity(key, value, 1);
        cache.put(key, entity);

        freqCount.computeIfAbsent(1, frequency -> new LinkedHashSet<>()).add(key);

    }
}


class LFUCacheEntity {
    int key;
    int value;
    int count;
    LFUCacheEntity(int key, int value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
    }

    public int getKey() {
        return this.key;
    }
    public int getValue() {
        return this.value;
    }
    public int getCount() {
        return this.count;
    }
    public void updateCount() {
        this.count = this.count + 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */