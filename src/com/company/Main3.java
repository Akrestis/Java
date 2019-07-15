package com.company;

public class Main3 {

    public static void main(String[] args) {

        //3*. Написать метод. Входящие параметры: отсортированный массив и число.
        //Метод должен вернуть true если это число есть в массиве, используя бинарный поиск.

        int num = 11;
        int[] arr = {-4, -1, 0, 4, 11, 28};

        System.out.println(contains(arr, num));
    }

    private static boolean contains(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        while (arr[(end - start) / 2 + start] != num && end - start != 1) {
            if (arr[(end - start) / 2 + start] > num) {
                end = (end - start) / 2 + start;
            } else {
                start = (end - start) / 2 + start;
            }
        }
        if (arr[(end - start) / 2 + start] == num) {
            return true;
        } else return arr[end] == num || arr[start] == num;
    }
}
