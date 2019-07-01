package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) {

        //3) Заполнить массив из 10 элементов случайными целыми числами от 10(включительно) до 20(включительно).
        //Вывести среднее арифметическое.

        Random random = new Random();
        int[] arr = new int[10];
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(11) + 10;
            sum += arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(sum / arr.length);
    }
}
