package com.company;

public class Main {

    public static void main(String[] args) {
        IntLinkedList myList = new IntLinkedList();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        System.out.println(myList);

        System.out.println(myList.size());

        System.out.println(myList.isEmpty());

        System.out.println(myList.get(5));

        myList.removeByIndex(5);
        System.out.println(myList);

        myList.add(5, 10);
        System.out.println(myList);

        myList.set(1, 10);
        System.out.println(myList);

        myList.removeByValue(10);
        System.out.println(myList);

        System.out.println(myList.subList(1,4));

        System.out.println(myList.peek());
        System.out.println(myList.pop());
        System.out.println(myList);

        System.out.println(myList.element());
        System.out.println(myList.remove());
        System.out.println(myList);

        myList.clear();
        System.out.println(myList);
    }
}

