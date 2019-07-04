package com.company;

public class Main {

    public static void main(String[] args) {

        //Написать interface IntList и его реализацию IntArrayList - аналог List<Integer>.

        IntList myArray = new IntArrayList();

        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.add(6);
        myArray.add(7);
        myArray.add(8);
        myArray.add(9);
        myArray.add(10);
        System.out.println(myArray);

        System.out.println(myArray.size());

        System.out.println(myArray.isEmpty());

        System.out.println(myArray.get(3));

        myArray.remove(5);
        System.out.println(myArray);

        myArray.add(5, 10);
        System.out.println(myArray);

        myArray.set(1, 10);
        System.out.println(myArray);

        myArray.removeByValue(10);
        System.out.println(myArray);

        System.out.println(myArray.subList(1,3));

        myArray.clear();
        System.out.println(myArray);

    }
}

