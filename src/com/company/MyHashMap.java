package com.company;

import java.util.Arrays;

public class MyHashMap implements MyMap {

    private static class HashMapEntry implements MyMap.Entry {

        private String key;
        private String value;
        private int hashCode;
        private HashMapEntry next;

        private HashMapEntry(String key, String value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
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
    public String put(String key, String value) {
        String result = putInternal(key, value);
        if (result == null) {
            size++;
        }
        if (size > threshold) {
            resize();
        }
        return result;
    }

    private String putInternal(String key, String value) {
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
            putInternal(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean containsKey(String key) {
        int position = key.hashCode() % table.length;
        return table[position] != null;
    }

    @Override
    public String get(String key) {
        int position = key.hashCode() % table.length;
        if (table[position] != null) {
            return table[position].value;
        } else {
            return null;
        }
    }

    @Override
    public String remove(String key) {
        int position = key.hashCode() % table.length;
        if (table[position] != null) {
            if (table[position].next != null) {
                table[position].value = table[position].next.value;
                if (table[position].next.next == null) {
                    table[position].next = null;
                } else {
                    table[position].next = table[position].next.next;
                }
                return table[position].value;
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
