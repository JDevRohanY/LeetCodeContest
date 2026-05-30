package LinkedListStackAndQueues;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private final int capacity;
    private int minFreq;
    private final Map<Integer, Integer> keyToValue;
    private final Map<Integer, Integer> keyToFreq;
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToValue = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) return -1;
        //if it contains
        incrementFreq(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            //u might increment it or do nothing depend on use case
            incrementFreq(key);
            return;
        }

        if (keyToValue.size() >= capacity) {
            //remove the min freq element
            evict();
        }

        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(key, k-> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    public void incrementFreq(int key) {
        int freq = keyToFreq.get(key);
        //update the freq
        keyToFreq.put(key, freq + 1);

        //now remove from old freq to keys
        freqToKeys.get(freq).remove(key);
        //now add to the new freq to keys
        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);

        if (freqToKeys.get(freq).isEmpty() && freq == minFreq) {
            minFreq++;
        }
    }

    private void evict() {
        //find the element with min freq
        LinkedHashSet<Integer> minBucket = freqToKeys.get(minFreq);
        int evictKey = minBucket.iterator().next();
        minBucket.remove(evictKey);
        keyToFreq.remove(evictKey);
        keyToValue.remove(evictKey);
    }
}
