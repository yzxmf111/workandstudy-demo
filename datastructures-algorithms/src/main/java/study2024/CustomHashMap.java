package study2024;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/2/27 15:06
 **/
import java.util.ArrayList;
import java.util.List;

class Entry<K, V> {
	K key;
	V value;

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

public class CustomHashMap<K, V> {
	private static final int DEFAULT_CAPACITY = 16;
	private List<Entry<K, V>>[] buckets;
	private int size;

	public CustomHashMap() {
		this(DEFAULT_CAPACITY);
	}

	public CustomHashMap(int capacity) {
		this.buckets = new ArrayList[capacity];
		this.size = 0;
	}

	public void put(K key, V value) {
		int index = getIndex(key);
		if (buckets[index] == null) {
			buckets[index] = new ArrayList<>();
		}

		// Check if key already exists
		for (Entry<K, V> entry : buckets[index]) {
			if (entry.key.equals(key)) {
				entry.value = value;
				return;
			}
		}

		buckets[index].add(new Entry<>(key, value));
		size++;
	}
	//这里没考虑扩容
	public V get(K key) {
		int index = getIndex(key);
		if (buckets[index] != null) {
			for (Entry<K, V> entry : buckets[index]) {
				if (entry.key.equals(key)) {
					return entry.value;
				}
			}
		}
		return null;
	}

	public int size() {
		return size;
	}

	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % buckets.length;
	}

	public static void main(String[] args) {
		CustomHashMap<String, Integer> map = new CustomHashMap<>();
		map.put("one", 1);
		map.put("one", 1111);
		map.put("two", 2);
		map.put("three", 3);

		System.out.println(map.get("one"));    // Output: 1
		System.out.println(map.get("two"));    // Output: 2
		System.out.println(map.get("four"));   // Output: null
	}
}

