class RandomizedSet {

    Map<Integer, Integer> map;
    ArrayList<Integer> valList;

    public RandomizedSet() {
        map = new HashMap<>();
        valList = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } else {
            valList.add(val);
            map.put(val, valList.size()-1);
            return true;
        }
        
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        } else {
            int idx = map.get(val); 
            valList.remove(idx);
            map.remove(val);

            // Update indexes of elements that shifted left.
            for (int i = idx; i < valList.size(); i++) {
                map.put(valList.get(i), i);
            }

            return true;
        }
        
    }
    
    public int getRandom() {
        return valList.get((int) (Math.random() * valList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */