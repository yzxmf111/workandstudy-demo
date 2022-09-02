package gogogo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description
 * @date 2022-08-30 16:56
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private Integer capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.get(key) == null ? -1 : super.get(key);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }


}
