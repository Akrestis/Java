package com.company;

public class Main1 {

    public static void main(String[] args) {

        //1. Число Фибоначи
        //написать метод который возвращает N-ное число фибоначи, по правилу:
        //F(0) = 0, F(1) = 1
        //F(N) = F(N - 1) + F(N - 2)

        System.out.println(fibonacci(4));
    }

    private static int fibonacci(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("parameter can't be negative");
        }
        if (count == 0 || count == 1) {
            return count;
        } else {
            int first = 0;
            int second = 1;
            int number = first + second;
            count--;
            while (count != 1) {
                first = second;
                second = number;
                number = first + second;
                count--;
            }
            return number;
        }
    }
}

