package com.company;

public interface MyMap<K, V> {
    interface Entry<K, V> {
        K getKey();

        V getValue();

        void setValue(V value);
    }

    void clear();

    boolean containsKey(K key);

    K get(K key);

    boolean isEmpty();

    K remove(K key);

    Object put(K key, V value);

    int size();

    Entry[] toArray();
}
