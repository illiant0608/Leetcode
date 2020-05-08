import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Entry find(Entry bucket, int key) {
        Entry e = bucket, prev = null;
        while (e != null && e.key != key) {
            prev = e;
            e = e.next;
        }
        return prev;
    }

    Entry[] entries = new Entry[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % 10000;
        if (entries[hash] == null)
            entries[hash] = new Entry(-1, -1);
        Entry prev = find(entries[hash], key);
        if (prev.next == null)
            prev.next = new Entry(key, value);
        else prev.next.value = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % 10000;
        if (entries[hash] == null) return -1;
        Entry prev = find(entries[hash], key);
        return prev.next == null ? -1 : prev.next.value;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % 10000;
        if (entries[hash] == null) return;
        Entry prev = find(entries[hash], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }
}
