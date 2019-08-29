package com.company;

public class Main1 {

    public static void main(String[] args) {

        //1) Написать метод `String reverse(String s) {...}`.
        //Входящий параметр: s - строка которая состоит из слов через пробел
        //Метод должен вернуть слова в обратном порядке

        String input = "man has dog";

        System.out.println(revers(input));
    }

    private static String revers(String input) {
        String[] array = input.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            output.append(array[i]).append(" ");
        }
        return output.toString();
    }
}