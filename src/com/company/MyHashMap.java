package com.company;

import java.util.Arrays;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static class HashMapEntry<K, V> implements MyMap.Entry<K, V> {

        private K key;
        private V value;
        private int hashCode;
        private HashMapEntry next;

        private HashMapEntry(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private int size = 0;
    private HashMapEntry[] table = new HashMapEntry[16];
    private double loadFactor = 0.75;
    private double threshold = loadFactor * table.length;

    @Override
    public void clear() {
        size = 0;
        table = new HashMapEntry[16];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object put(K key, V value) {
        Object result = putInternal(key, value);
        if (result == null) {
            size++;
        }
        if (size > threshold) {
            resize();
        }
        return result;
    }

    private Object putInternal(K key, V value) {
        HashMapEntry newEntry = new HashMapEntry(key, value, key.hashCode());
        int position = key.hashCode() % table.length;
        if (table[position] == null) {
            table[position] = newEntry;
            return null;
        } else {
            HashMapEntry tmp = table[position];
            table[position] = newEntry;
            newEntry.next = tmp;
            return tmp.value;
        }
    }

    private void resize() {
        Entry[] arr = toArray();
        table = new HashMapEntry[table.length * 2];
        threshold = loadFactor * table.length;
        for (Entry entry : arr) {
            putInternal((K) entry.getKey(), (V) entry.getValue());
        }
    }

    @Override
    public boolean containsKey(K key) {
        int position = key.hashCode() % table.length;
        return table[position] != null;
    }

    @Override
    public K get(K key) {
        int position = key.hashCode() % table.length;
        if (table[position] != null) {
            return (K) table[position].value;
        } else {
            return null;
        }
    }

    @Override
    public K remove(K key) {
        int position = key.hashCode() % table.length;
        if (table[position] != null) {
            if (table[position].next != null) {
                table[position].value = table[position].next.value;
                if (table[position].next.next == null) {
                    table[position].next = null;
                } else {
                    table[position].next = table[position].next.next;
                }
                return (K) table[position].value;
            } else {
                table[position] = null;
                size--;
            }
        }
        return null;
    }

    @Override
    public Entry[] toArray() {
        HashMapEntry[] result = new HashMapEntry[size];
        int index = 0;
        for (int position = 0; position < table.length; position++) {
            if (table[position] != null) {
                result[index] = table[position];
                index++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
