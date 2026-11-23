class LRUCache {
    public class Entity {
        int key;
        int value;
        Entity(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Entity> map;
    Deque<Entity> queue;
    int capacity = 0;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        //remove + insert into queue
        remove(map.get(key));
        insert(map.get(key));
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        
        map.put(key, new Entity(key, value));
        insert(map.get(key));

        if(map.size() > capacity) {
            Entity e = queue.removeFirst();
            map.remove(e.key);
        }
    }

    private void insert(Entity e) {
        queue.offer(e);
    }

    private void remove(Entity e) {
        queue.remove(e);
    }
}
