package com.company;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {

        //2. Написать метод.
        //Входящий параметр: отсортированный массив типа int который содержит отрицательные и положительные значения.
        //Вернуть отсортированный массив который состоит из квадратов значений.
        //Не использовать при этом стандартный метод sort.

        int[] arr = {-8, -4, 0, 1, 8, 11};
        System.out.println(Arrays.toString(squareArray(arr)));
    }

    private static int[] squareArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
