package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

     //1.) Создать список случайных чисел. Используя Stream Api подсчитать среднее арифиметическое квадратов этих чисел/

        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10) + 1);
        }
        System.out.println(list);

        System.out.println(list.stream().mapToInt(Integer::intValue).map(s->s*s).average());
    }
}
