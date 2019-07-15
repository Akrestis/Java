package com.company;

public class Main4 {

    public static void main(String[] args) {

        //4*. Написать рекурсивный(!!!) метод который выводит все перестановки строки.

        permutation("abc");
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}
