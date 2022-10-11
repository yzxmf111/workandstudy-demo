package November.ZS;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCacheTwo {

    int capacity;
    Map<Integer,Integer> map;
    public LRUCacheTwo(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity,0.75f,true);
    }

    public int get(int key) {
        if (map.get(key) != null) {
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

        map.put(key,value);

        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

    public static void main(String[] args) {
        LRUCacheTwo cache = new LRUCacheTwo(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);




    }
}
