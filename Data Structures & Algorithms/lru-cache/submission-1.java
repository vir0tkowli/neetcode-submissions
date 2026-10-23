class LRUCache {
    int timestamp = 0;
    PriorityQueue<LRUEntity> cache;
    private final Map<Integer, LRUEntity> cacheMap = new HashMap<>();
    int capacity = 0;
    public LRUCache(int capacity) {
        cache = new PriorityQueue<>(Comparator.comparingInt(LRUEntity::getTimestamp));
        this.capacity = capacity;
    }
    
    public int get(int key) {
        LRUEntity entity = cacheMap.get(key);
        if (entity == null) {
            return -1;
        }   
        cache.remove(entity);
        entity.putTimestamp(timestamp++);
        cache.offer(entity);
        
        return entity.getValue();
    }
    
    public void put(int key, int value) {
        LRUEntity existing = cacheMap.get(key);
        if (existing != null) {
            cache.remove(existing);
        }

        LRUEntity entity = new LRUEntity(key, value, timestamp++);
        cache.offer(entity);
        cacheMap.put(key, entity);
        if(cache.size() > capacity) {
            LRUEntity removeEntity = cache.poll();
            cacheMap.remove(removeEntity.getKey());
        }
        
    }
}

class LRUEntity {
    int timestamp;
    int key;
    int value;
    LRUEntity(int key, int value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getKey() {
        return this.key;
    }
    public int getValue() {
        return this.value;
    }
    public int getTimestamp() {
        return this.timestamp;
    }
    public void putTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
