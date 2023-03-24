package November.ZS;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //一旦超出就会删除最老的元素
        return size() > MAX_ENTRIES;

    }

    public LRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        System.out.println(cache.keySet());
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }

}
