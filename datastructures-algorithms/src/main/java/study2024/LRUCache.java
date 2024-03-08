package study2024;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author yifan.tian
 * @Description    两个lru缓存实现机制
 * @Date 2024/2/29 10:16
 **/
public class LRUCache extends LinkedHashMap<Integer, Integer> {

	private Integer capacity;

	public LRUCache(int capacity) {
		super(capacity,0.75f,true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return super.get(key) != null ? super.get(key) : -1;
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}
