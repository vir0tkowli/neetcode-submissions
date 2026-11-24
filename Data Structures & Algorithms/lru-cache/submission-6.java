class LRUCache {
    public class Entity {
        int key;
        int value;
        Entity prev;
        Entity next;
        Entity(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Entity> map;
    Deque<Entity> queue;
    int capacity = 0;
    private final Entity head = new Entity(0, 0);
    private final Entity tail = new Entity(0, 0);

    public LRUCache(int capacity) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Entity e = map.get(key);
        if (e == null) {
            return -1;
        }

        //remove + insert into queue
        remove(e);
        insert(e);
        return e.value;
    }
    
    public void put(int key, int value) {
        Entity e = map.get(key);

        if(e != null) {
            e.value = value;
            remove(e);
        } else {
            e = new Entity(key, value);
        }
        
        map.put(key, e);
        insert(e);

        if(map.size() > capacity) {
            Entity oldest = head.next;
            remove(oldest);
            map.remove(oldest.key); 
        }
    }

    private void insert(Entity e) {
        Entity previousLast = tail.prev;
        previousLast.next = e;
        e.prev = previousLast;
        e.next = tail;
        tail.prev = e;
        //queue.offer(e);
    }

    private void remove(Entity e) {
        //queue.remove(e); // O(n)
        e.prev.next = e.next;
        e.next.prev = e.prev;
    }
}
