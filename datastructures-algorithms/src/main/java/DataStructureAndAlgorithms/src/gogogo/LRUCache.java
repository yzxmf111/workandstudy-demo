package gogogo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity)  {
        super(capacity, 0.75F, true);

    }

    public int get(int key) {
        return super.get(key) == null ? -1 : super.get(key);
    }

    public void put(int key, int value) {
        //需要重写removeEldestEntry方法
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
