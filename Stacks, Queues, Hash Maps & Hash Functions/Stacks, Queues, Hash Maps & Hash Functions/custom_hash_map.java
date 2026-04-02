package Submission_of_Stacks_Queues_Hash_Maps;

import java.util.LinkedList;

public class custom_hash_map {
    static class MyMap<K, V> {
        class Entry {
            K key;
            V value;
            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<Entry>[] buckets;
        private int capacity = 16;

        @SuppressWarnings("unchecked")
        public MyMap() {
            buckets = new LinkedList[capacity];
        }

        public void put(K key, V value) {
            int index = Math.abs(key.hashCode()) % capacity;
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<>();
            }
            for (Entry e : buckets[index]) {
                if (e.key.equals(key)) {
                    e.value = value;
                    return;
                }
            }
            buckets[index].add(new Entry(key, value));
        }

        public V get(K key) {
            int index = Math.abs(key.hashCode()) % capacity;
            if (buckets[index] != null) {
                for (Entry e : buckets[index]) {
                    if (e.key.equals(key)) return e.value;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("A", 10);
        map.put("B", 20);
        System.out.println(map.get("A"));
    }
}