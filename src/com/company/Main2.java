package com.company;

public class Main2 {

    public static void main(String[] args) {

        //3*) Сделать MyMap<K,V>

        MyMap myMap = new MyHashMap();
        myMap.put(1, true);
        myMap.put("2", "qwert");
        myMap.put(0.3, null);
        myMap.put(1, "zzz");
        System.out.println(myMap);

        System.out.println(myMap.size());
        System.out.println(myMap.isEmpty());
        System.out.println(myMap.containsKey(1));
        System.out.println(myMap.get(1));
        System.out.println(myMap.remove(1));
        System.out.println(myMap);
        myMap.clear();
        System.out.println(myMap);
    }
}
