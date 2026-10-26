class LRUCache {
    int timestamp = 0;
    private final Map<Integer, LRUEntity> cacheMap = new HashMap<>();
    private LRUEntity left;
    private LRUEntity right;
    int capacity;

    public LRUCache(int capacity) {
        this.left = new LRUEntity(0, 0, timestamp);
        this.right = new LRUEntity(0, 0, timestamp);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        LRUEntity entity = cacheMap.get(key);
        if (entity == null) {
            return -1;
        }   
        cacheMap.remove(key);
        remove(entity);
        
        entity.putTimestamp(timestamp++);
        
        insert(entity);
        cacheMap.put(key, entity);
        
        return entity.getValue();
    }
    
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            remove(cacheMap.get(key));
        }
        LRUEntity entity = new LRUEntity(key, value, timestamp);
        cacheMap.put(key, entity);
        insert(entity);

        if (cacheMap.size() > this.capacity) {
            LRUEntity evictNode = this.left.next;
            remove(evictNode);
            cacheMap.remove(evictNode.getKey());
        }
    }

    private void remove(LRUEntity node) {
        LRUEntity prev = node.prev;
        LRUEntity nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    // Insert at the end
    private void insert(LRUEntity node) {
        LRUEntity prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

}

class LRUEntity {
    int timestamp;
    int key;
    int value;
    LRUEntity next;
    LRUEntity prev;
    LRUEntity(int key, int value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
        this.prev = null;
        this.next = null;
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
