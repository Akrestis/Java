package com.company;

public class Main {

    public static void main(String[] args) {
        //Написать свою собственную реализацию HashMap, HashSet.

        MyMap myMap = new MyHashMap();
        myMap.put("1", "asdf");
        myMap.put("2", "qwert");
        myMap.put("3", "zxcv");
        myMap.put("1", "zzz");
        System.out.println(myMap);

        System.out.println(myMap.size());
        System.out.println(myMap.isEmpty());
        System.out.println(myMap.containsKey("1"));
        System.out.println(myMap.get("1"));
        System.out.println(myMap.remove("1"));
        System.out.println(myMap);
        myMap.clear();
        System.out.println(myMap);

        MySet mySet = new MyHashSet();
        mySet.add("asdf");
        mySet.add("qwer");
        mySet.add("zxcv");
        mySet.add("asdf");
        System.out.println(mySet);

        System.out.println(mySet.size());
        System.out.println(mySet.isEmpty());
        System.out.println(mySet.contains("asdf"));
        System.out.println(mySet.remove("zxcv"));
        System.out.println(mySet);
        mySet.clear();
        System.out.println(mySet);
    }
}

